package com.hongjinqiu.nanhuprint.eval.custom;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.enumerate.ShowPositionEnum;
import com.hongjinqiu.nanhuprint.eval.AbstractEval;
import com.hongjinqiu.nanhuprint.eval.EvalFactory;
import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import com.hongjinqiu.nanhuprint.eval.IEval;
import com.hongjinqiu.nanhuprint.eval.TableEval;
import com.hongjinqiu.nanhuprint.eval.explain.ExplainUtil;
import com.hongjinqiu.nanhuprint.eval.vo.HeightIndexParamVO;
import com.hongjinqiu.nanhuprint.model.Body;
import com.hongjinqiu.nanhuprint.model.Table;
import com.hongjinqiu.nanhuprint.model.Tbody;
import com.hongjinqiu.nanhuprint.model.Tbottom;
import com.hongjinqiu.nanhuprint.model.Thead;
import com.hongjinqiu.nanhuprint.model.Tloop;
import com.hongjinqiu.nanhuprint.model.Tr;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * body 配置参数为:
 * <params>
 * <param name="extendToFillBody" value="default"></param>
 * </params>
 * 时的解析实现类,实现第一个 table, 每页 thead 重复, 最后一页,用 tloop 的内容来填充,tbottom 固定表尾
 */
public class ExtendToFillBodyEval extends AbstractEval {
    private String childKey = "ifAndForEachAndSet";
    private Map<CacheKey, List<Element>> objCache = new HashMap<>();// 用来缓存thead-tr, tbody-tr, tbottom-tr,在计算高度后,可以缓存的就缓存下来,避免重复创建,

    /**
     * 缓存键，包含元素对象和页面边框标志
     */
    private static class CacheKey {
        private final Object obj;
        private final boolean isFirstLineOfPage;
        private final boolean isLastLineOfPage;

        public CacheKey(Object obj, boolean isFirstLineOfPage, boolean isLastLineOfPage) {
            this.obj = obj;
            this.isFirstLineOfPage = isFirstLineOfPage;
            this.isLastLineOfPage = isLastLineOfPage;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheKey cacheKey = (CacheKey) o;
            return isFirstLineOfPage == cacheKey.isFirstLineOfPage &&
                    isLastLineOfPage == cacheKey.isLastLineOfPage &&
                    obj.equals(cacheKey.obj);
        }

        @Override
        public int hashCode() {
            int result = obj.hashCode();
            result = 31 * result + (isFirstLineOfPage ? 1 : 0);
            result = 31 * result + (isLastLineOfPage ? 1 : 0);
            return result;
        }
    }

    @Override
    public String getChildKey() {
        return childKey;
    }

    /**
     * 将 xml 元素解析并输出 pdf,
     *
     * @return
     */
    public List<Element> evalToPdf(Document document, Body body, Map<String, Object> env) {
        List<Element> pdfPTableList = new ArrayList<>();
        if (body.getIfAndForEachAndSet() != null) {
            for (Object obj : body.getIfAndForEachAndSet()) {
                if (obj instanceof Table) {
                    Table table = (Table) obj;
                    ExplainUtil.addExplain(table, "===================== table(id:" + table.getId() + ") explain begin =====================");
                    // 取得 thead,tbody 中每一行,tloop,tbottom 的高度,
                    ExtendToFillBodyStruct extendToFillBodyStruct = calcExtendToFillBodyStruct(document, table, env);
                    if (extendToFillBodyStruct.getTloopHeight() == 0) {
                        throw new NanhuprintException("tloop中的内容高度不能为0,否则无法填充内容,会出现死循环,可以放一个 <span value=\" \" />, 使得有一行空字符,内容就不会为空!");
                    }
                    float documentContentHeight = getDocumentContentHeight(document);

                    // 一页全部放得下
                    float headAndBodyAndBottomHeightSum = extendToFillBodyStruct.getTheadHeightFirstPageSum() +
                            extendToFillBodyStruct.getTheadHeightEveryPageSum() +
                            extendToFillBodyStruct.getTbodyHeightSum() +
                            extendToFillBodyStruct.getTbottomHeightEveryPageSum() +
                            extendToFillBodyStruct.getTbottomHeightLastPageSum();

                    if (headAndBodyAndBottomHeightSum <= documentContentHeight) {
                        PdfPTable pdfPTable = getPdfPTableOnePage(document, table, extendToFillBodyStruct, env);
                        pdfPTable.setComplete(true);
                        pdfPTableList.add(pdfPTable);
                    } else {
                        // 一页放不下
                        List<PdfPTable> pdfPTables = getPdfPTableMoreThanOnePage(document, table, extendToFillBodyStruct, env);
                        pdfPTableList.addAll(pdfPTables);
                    }
                    ExplainUtil.addExplain(table, "===================== table(id:" + table.getId() + ") explain end =====================");
                    ExplainUtil.outputExplain(table.getId());
                }
            }
        }

        return pdfPTableList;
    }

    /**
     * 取得多页的 PdfPTable
     * @param document
     * @param table
     * @param extendToFillBodyStruct
     * @param env
     * @return
     */
    private List<PdfPTable> getPdfPTableMoreThanOnePage(Document document, Table table, ExtendToFillBodyStruct extendToFillBodyStruct, Map<String, Object> env) {
        EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_CURRENT_PAGE_NUMBER, 1);// 当前页,放1
        EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_TOTAL_PAGE_NUMBER, getPdfPTableMoreThanOneTotalPageNumber(document, extendToFillBodyStruct));// 总页数

        float documentContentHeight = getDocumentContentHeight(document);
        List<PdfPTable> pdfPTableList = new ArrayList<>();

        TableEval tableEval = new TableEval();
        Integer totalPage = (Integer)EvalUtil.getValueFromNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_TOTAL_PAGE_NUMBER);
        ExplainUtil.addExplain(table, "table(id:" + table.getId() + ") totalPage is:" + totalPage);
        int lastTbodyLineChildIndex = -1;
        // float currentPageHeight = 0;
        HeightIndexParamVO heightIndexParamVO = new HeightIndexParamVO(0, lastTbodyLineChildIndex);
        for (int i = 0; i < totalPage; i++) {
            if (i == 0) {
                PdfPTable pdfPTable = tableEval.getPdfPTableWithLockWith(table, getDocumentContentWidth(document));
                // 首页, thead(firstPage) + thead(everyPage) + tbody + tbottom(everyPage)
                addTheadAll(pdfPTable, table, env);
                float currentPageHeight = extendToFillBodyStruct.getTheadHeightFirstPageSum() + extendToFillBodyStruct.getTheadHeightEveryPageSum();
                currentPageHeight += extendToFillBodyStruct.getTbottomHeightEveryPageSum();

                heightIndexParamVO.setCurrentPageHeight(currentPageHeight);

                addTbody(extendToFillBodyStruct, pdfPTable, table, heightIndexParamVO, documentContentHeight, env);

                // 末尾添加 tbottom every page
                addTbottom(pdfPTable, table, ShowPositionEnum.EVERY_PAGE, env);
                // 确保表格边框在分页时正确渲染
                pdfPTable.setKeepTogether(false);
                pdfPTable.setSpacingAfter(0f);
                pdfPTable.setComplete(true);
                pdfPTableList.add(pdfPTable);
            } else if (i == (totalPage - 1)) {
                // 末页,thead(everyPage) + tbody + tloop + tbottom(everyPage) + tbottom(lastPage)
                addEnvCurrentPageNumber(env);

                PdfPTable pdfPTable = tableEval.getPdfPTableWithLockWith(table, getDocumentContentWidth(document));
                addThead(pdfPTable, table, ShowPositionEnum.EVERY_PAGE, env);

                float currentPageHeight = extendToFillBodyStruct.getTheadHeightEveryPageSum();
                currentPageHeight += extendToFillBodyStruct.getTbottomHeightEveryPageSum();
                currentPageHeight += extendToFillBodyStruct.getTbottomHeightLastPageSum();

                heightIndexParamVO.setCurrentPageHeight(currentPageHeight);
                addTbody(extendToFillBodyStruct, pdfPTable, table, heightIndexParamVO, documentContentHeight, env);

                float remainHeight = documentContentHeight - heightIndexParamVO.getCurrentPageHeight();
                int loopCount = Double.valueOf(remainHeight / extendToFillBodyStruct.getTloopHeight()).intValue();
                addTloop(pdfPTable, table, 0, loopCount, env);

                addTbottomAll(pdfPTable, table, env);

                // 确保表格边框在分页时正确渲染
                pdfPTable.setKeepTogether(false);
                pdfPTable.setSpacingBefore(0f);
                pdfPTable.setComplete(true);
                pdfPTableList.add(pdfPTable);
            } else {
                // 中间页, thead(everyPage) + tbody + tbottom(everyPage)
                addEnvCurrentPageNumber(env);

                PdfPTable pdfPTable = tableEval.getPdfPTableWithLockWith(table, getDocumentContentWidth(document));
                addThead(pdfPTable, table, ShowPositionEnum.EVERY_PAGE, env);

                float currentPageHeight = extendToFillBodyStruct.getTheadHeightEveryPageSum();
                currentPageHeight += extendToFillBodyStruct.getTbottomHeightEveryPageSum();

                heightIndexParamVO.setCurrentPageHeight(currentPageHeight);
                addTbody(extendToFillBodyStruct, pdfPTable, table, heightIndexParamVO, documentContentHeight, env);

                // 末尾添加 tbottom every page
                addTbottom(pdfPTable, table, ShowPositionEnum.EVERY_PAGE, env);

                // 确保表格边框在分页时正确渲染
                pdfPTable.setKeepTogether(false);
                pdfPTable.setSpacingBefore(0f);
                pdfPTable.setSpacingAfter(0f);
                pdfPTable.setComplete(true);
                pdfPTableList.add(pdfPTable);
            }
        }

        return pdfPTableList;
    }

    /**
     * 添加 tbody 中的 tr
     * @param extendToFillBodyStruct
     * @param pdfPTable
     * @param table
     * @param heightIndexParamVO
     * @param documentContentHeight
     * @param env
     */
    private void addTbody(ExtendToFillBodyStruct extendToFillBodyStruct, PdfPTable pdfPTable, Table table, HeightIndexParamVO heightIndexParamVO, float documentContentHeight, Map<String, Object> env) {
        float currentPageHeight = heightIndexParamVO.getCurrentPageHeight();
        int lastTbodyLineChildIndex = heightIndexParamVO.getLastTbodyLineChildIndex();

        // 获取 tbody 总行数
        int totalTbodyRows = getTotalTbodyRows(table);

        // 记录当前页添加的第一行和最后一行的索引
        int firstLineIndexInCurrentPage = -1;
        int lastLineIndexInCurrentPage = -1;

        // 先找出当前页可以放下哪些行
        List<Integer> linesInCurrentPage = new ArrayList<>();
        for (LineChild lineChild : extendToFillBodyStruct.getTbodyLineChilds()) {
            if (lineChild.getIndex() > lastTbodyLineChildIndex) {
                if (currentPageHeight + lineChild.getHeight() <= documentContentHeight) {
                    linesInCurrentPage.add(lineChild.getIndex());
                    currentPageHeight += lineChild.getHeight();
                } else {
                    break;
                }
            }
        }

        // 添加这些行，并设置页面第一行和最后一行的标志
        for (int i = 0; i < linesInCurrentPage.size(); i++) {
            int lineIndex = linesInCurrentPage.get(i);

            // 判断是否为当前页的第一行（但不是整个 tbody 的第一行）
            boolean isFirstLineOfPage = (i == 0) && (lineIndex != 0);
            // 判断是否为当前页的最后一行（但不是整个 tbody 的最后一行）
            boolean isLastLineOfPage = (i == linesInCurrentPage.size() - 1) && (lineIndex != totalTbodyRows - 1);

            // 设置环境变量标志
            EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_PAGE, isFirstLineOfPage);
            EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_PAGE, isLastLineOfPage);

            addTbody(pdfPTable, table, lineIndex, env);
            lastTbodyLineChildIndex = lineIndex;

            // 清除标志
            EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_PAGE, false);
            EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_PAGE, false);
        }

        heightIndexParamVO.setCurrentPageHeight(currentPageHeight);
        heightIndexParamVO.setLastTbodyLineChildIndex(lastTbodyLineChildIndex);
    }

    /**
     * 取得总页数
     */
    private int getPdfPTableMoreThanOneTotalPageNumber(Document document, ExtendToFillBodyStruct extendToFillBodyStruct) {
        float documentContentHeight = getDocumentContentHeight(document);
        int totalPageNumber = 0;

        // 添加表身
        float currentPageHeight = extendToFillBodyStruct.getTheadHeightFirstPageSum()
                + extendToFillBodyStruct.getTheadHeightEveryPageSum()
                + extendToFillBodyStruct.getTbottomHeightEveryPageSum();
        for (LineChild lineChild : extendToFillBodyStruct.getTbodyLineChilds()) {
            if (currentPageHeight + lineChild.getHeight() <= documentContentHeight) {// 这一行,当页可以放下
                currentPageHeight += lineChild.getHeight();
            } else {// 这一行,当页放不下
                totalPageNumber++;
                currentPageHeight = extendToFillBodyStruct.getTheadHeightEveryPageSum() + extendToFillBodyStruct.getTbottomHeightEveryPageSum();
                currentPageHeight += lineChild.getHeight();
            }
        }
        // 此时的 pdfPTable 为最后一页,
        // 最后一页可以放下 tbottomHeight
        if (currentPageHeight + extendToFillBodyStruct.getTbottomHeightLastPageSum() <= documentContentHeight) {
            totalPageNumber++;
        } else {
            totalPageNumber += 2;
        }

        return totalPageNumber;
    }

    /**
     * 添加 tbody 中对应 index 的那一行
     */
    private void addTbody(PdfPTable pdfPTable, Table table, int index, Map<String, Object> env) {
        // 获取 tbody 总行数
        int totalTbodyRows = getTotalTbodyRows(table);

        // 设置是否为第一行或最后一行的标志
        if (index == 0) {
            EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_TBODY, true);
        } else {
            EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_TBODY, false);
        }

        if (index == totalTbodyRows - 1) {
            EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_TBODY, true);
        } else {
            EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_TBODY, false);
        }

        // 将 env 存储到 ThreadLocal 中，以便 getCssAttributeInternal 可以访问
        NanhuprintThreadLocal.setEnv(env);

        List<Element> elements = createTbody(table, env, index);
        addCell(pdfPTable, elements);
        pdfPTable.completeRow();

        // 清除标志
        EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_TBODY, false);
        EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_TBODY, false);
    }

    /**
     * 环境变量中的 nanhuprint_result.currentPageNumber + 1
     */
    private void addEnvCurrentPageNumber(Map<String, Object> env) {
        Integer currentPageNumber = (Integer) EvalUtil.getValueFromNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_CURRENT_PAGE_NUMBER);
        currentPageNumber++;
        EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_CURRENT_PAGE_NUMBER, currentPageNumber);
    }

    /**
     * 获取 tbody 的总行数
     */
    private int getTotalTbodyRows(Table table) {
        if (table.getIfAndForEachAndSet() != null) {
            for (Object obj : table.getIfAndForEachAndSet()) {
                if (obj instanceof Tbody) {
                    Tbody tbody = (Tbody) obj;
                    if (tbody.getIfAndForEachAndSet() != null) {
                        int count = 0;
                        for (Object subObj : tbody.getIfAndForEachAndSet()) {
                            if (subObj instanceof Tr) {
                                count++;
                            }
                        }
                        return count;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 取得一页 PdfPTable
     *
     * @param document
     * @param table
     * @param extendToFillBodyStruct
     * @param env
     * @return
     */
    private PdfPTable getPdfPTableOnePage(Document document, Table table, ExtendToFillBodyStruct extendToFillBodyStruct, Map<String, Object> env) {
        EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_CURRENT_PAGE_NUMBER, 1);// 当前页,放1
        EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_TOTAL_PAGE_NUMBER, 1);// 当前页,放1

        float documentContentHeight = getDocumentContentHeight(document);
        TableEval tableEval = new TableEval();
        PdfPTable pdfPTable = tableEval.getPdfPTableWithLockWith(table, getDocumentContentWidth(document));
        // 假设 headHeight 必然小于 documentContentHeight,
        // 添加表头
        addTheadAll(pdfPTable, table, env);

        //  添加表身
        addTbodyAll(pdfPTable, table, env);

        // tloop 内容填充
        float heightSum = extendToFillBodyStruct.getTheadHeightFirstPageSum()
                + extendToFillBodyStruct.getTheadHeightEveryPageSum()
                + extendToFillBodyStruct.getTbodyHeightSum()
                + extendToFillBodyStruct.getTbottomHeightEveryPageSum()
                + extendToFillBodyStruct.getTbottomHeightLastPageSum();

        float remainHeight = documentContentHeight - heightSum;
        int loopCount = Double.valueOf(remainHeight / extendToFillBodyStruct.getTloopHeight()).intValue();
        addTloop(pdfPTable, table, 0, loopCount, env);

        // tbottom 内容填充
        addTbottomAll(pdfPTable, table, env);
        pdfPTable.setComplete(true);
        return pdfPTable;
    }

    /**
     * 添加表尾, 全部添加
     *
     * @param pdfPTable
     * @param table
     * @param env
     */
    private void addTbottomAll(PdfPTable pdfPTable, Table table, Map<String, Object> env) {
        List<Element> elements = createTbottomAll(table, env);
        addCell(pdfPTable, elements);
        pdfPTable.completeRow();
    }

    /**
     * 添加表尾
     * @param pdfPTable
     * @param table
     * @param env
     * @param showPositionEnum
     */
    private void addTbottom(PdfPTable pdfPTable, Table table, ShowPositionEnum showPositionEnum, Map<String, Object> env) {
        List<Element> elements = createTbottom(table, showPositionEnum, env);
        addCell(pdfPTable, elements);
        pdfPTable.completeRow();
    }

    /**
     * 用 tloop 内容来填充表身,由于循环时,有可能需要填充交替行,例如每一行不同的颜色,因此,传了
     * 开始下标 beginLoop,
     * 结束下标 endLoop,
     * [beginLoop, endLoop)
     * 以避免换页时,交替内容没对上
     */
    private void addTloop(PdfPTable pdfPTable, Table table, int beginLoop, int endLoop, Map<String, Object> env) {
        for (int i = beginLoop; i < endLoop; i++) {
            List<Element> elements = createTloop(table, env, i);
            addCell(pdfPTable, elements);
            pdfPTable.completeRow();
        }
    }

    /**
     * 添加表身
     */
    private void addTbodyAll(PdfPTable pdfPTable, Table table, Map<String, Object> env) {
        List<LineChild> lineChildren = createTbody(table, env);
        for (LineChild lineChild : lineChildren) {
            addCell(pdfPTable, lineChild.getElements());
            pdfPTable.completeRow();
        }
    }

    /**
     * 添加表头
     *
     * @param pdfPTable
     * @param table
     * @param env
     */
    private void addTheadAll(PdfPTable pdfPTable, Table table, Map<String, Object> env) {
        List<Element> elements = createTheadAll(table, env);
        addCell(pdfPTable, elements);
        pdfPTable.completeRow();
    }

    /**
     *
     * @param pdfPTable
     * @param table
     * @param env
     */
    private void addThead(PdfPTable pdfPTable, Table table, ShowPositionEnum showPositionEnum, Map<String, Object> env) {
        List<Element> elements = createThead(table, showPositionEnum, env);
        addCell(pdfPTable, elements);
        pdfPTable.completeRow();
    }

    /**
     * 循环列表,类型转化,添加到 pdfPTable 中
     */
    private void addCell(PdfPTable pdfPTable, List<Element> elements) {
        for (Element element : elements) {
            pdfPTable.addCell((PdfPCell) element);
        }
    }

    /**
     * 先把元素在 table 中添加一遍,以计算出高度
     *
     * @param document
     * @param table
     * @param env
     * @return
     */
    private ExtendToFillBodyStruct calcExtendToFillBodyStruct(Document document, Table table, Map<String, Object> env) {
        ExtendToFillBodyStruct extendToFillBodyStruct = new ExtendToFillBodyStruct();

        TableEval tableEval = new TableEval();
        PdfPTable pdfPTable = tableEval.getPdfPTableWithLockWith(table, getDocumentContentWidth(document));

        {
            // 计算 headHeight
            float begin = pdfPTable.getTotalHeight();
            addThead(pdfPTable, table, ShowPositionEnum.FIRST_PAGE, env);
            float end = pdfPTable.getTotalHeight();
            extendToFillBodyStruct.setTheadHeightFirstPageSum(end - begin);
        }
        {
            // 计算 headHeight
            float begin = pdfPTable.getTotalHeight();
            addThead(pdfPTable, table, ShowPositionEnum.EVERY_PAGE, env);
            float end = pdfPTable.getTotalHeight();
            extendToFillBodyStruct.setTheadHeightEveryPageSum(end - begin);
        }
        {
            // 计算 tbodyHeight
            List<LineChild> tbodyLineChilds = createTbody(pdfPTable, table, document, env);
            float tbodyHeight = 0;
            for (LineChild lineChild : tbodyLineChilds) {
                tbodyHeight += lineChild.getHeight();
            }
            extendToFillBodyStruct.setTbodyLineChilds(tbodyLineChilds);
            extendToFillBodyStruct.setTbodyHeightSum(tbodyHeight);
        }
        {
            // 计算 tloopHeight
            float begin = pdfPTable.getTotalHeight();
            List<Element> elements = createTloop(table, env, 0);
            addCell(pdfPTable, elements);
            pdfPTable.completeRow();
            float end = pdfPTable.getTotalHeight();
            extendToFillBodyStruct.setTloopHeight(end - begin);
        }
        {
            // 计算 tbottom everyPage height
            float begin = pdfPTable.getTotalHeight();
            addTbottom(pdfPTable, table, ShowPositionEnum.EVERY_PAGE, env);
            float end = pdfPTable.getTotalHeight();
            extendToFillBodyStruct.setTbottomHeightEveryPageSum(end - begin);
        }
        {
            // 计算 tbottom lastPage height
            float begin = pdfPTable.getTotalHeight();
            addTbottom(pdfPTable, table, ShowPositionEnum.LAST_PAGE, env);
            float end = pdfPTable.getTotalHeight();
            extendToFillBodyStruct.setTbottomHeightLastPageSum(end - begin);
        }

        pdfPTable.setComplete(true);

        // 注意：由于使用了复合缓存键（包含页面边框标志），不需要清空任何缓存
        //
        // 1. objCache 使用 CacheKey(tr, isFirstLineOfPage, isLastLineOfPage) 作为键
        //    - 高度计算时：CacheKey(tr, false, false)
        //    - 渲染页面边界时：CacheKey(tr, true, false) 或 CacheKey(tr, false, true)
        //    不同的缓存键自动避免冲突
        //
        // 2. cssAttributeMap 使用 "id_attribute_isFirstLineOfPage_isLastLineOfPage" 作为键
        //    - 高度计算时：id_cls_false_false
        //    - 渲染页面边界时：id_cls_true_false 或 id_cls_false_true
        //    不同的缓存键自动避免冲突
        //
        // 这样既保持了缓存的性能优势，又正确支持了页面边框 CSS 功能

        return extendToFillBodyStruct;
    }

    /**
     * 创建 thead, 为空, 则默认为 firstPage
     *
     * @param table
     * @param env
     * @return
     */
    private List<Element> createThead(Table table, ShowPositionEnum showPositionEnum, Map<String, Object> env) {
        List<Element> result = new ArrayList<>();
        if (table.getIfAndForEachAndSet() != null) {
            for (Object obj : table.getIfAndForEachAndSet()) {
                if (obj instanceof Thead) {
                    Thead thead = (Thead) obj;
                    String showPosition = StringUtils.defaultIfEmpty(thead.getShowPosition(), ShowPositionEnum.FIRST_PAGE.getCode());
                    if (showPositionEnum.getCode().equalsIgnoreCase(showPosition)) {
                        if (thead.getIfAndForEachAndSet() != null) {
                            for (Object subObj : thead.getIfAndForEachAndSet()) {
                                if (subObj instanceof Tr) {
                                    result.addAll(createTrOrReturnCache((Tr) subObj, env));
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 创建 thead
     *
     * @param table
     * @param env
     * @return
     */
    private List<Element> createTheadAll(Table table, Map<String, Object> env) {
        List<Element> result = new ArrayList<>();
        if (table.getIfAndForEachAndSet() != null) {
            for (Object obj : table.getIfAndForEachAndSet()) {
                if (obj instanceof Thead) {
                    Thead thead = (Thead) obj;
                    if (thead.getIfAndForEachAndSet() != null) {
                        for (Object subObj : thead.getIfAndForEachAndSet()) {
                            if (subObj instanceof Tr) {
                                result.addAll(createTrOrReturnCache((Tr) subObj, env));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 创建 tbody
     *
     * @param table
     * @param env
     * @return
     */
    private List<LineChild> createTbody(PdfPTable pdfPTable, Table table, Document document, Map<String, Object> env) {
        List<LineChild> lineChildren = new ArrayList<>();

        if (table.getIfAndForEachAndSet() != null) {
            for (Object obj : table.getIfAndForEachAndSet()) {
                if (obj instanceof Tbody) {
                    Tbody tbody = (Tbody) obj;
                    if (tbody.getIfAndForEachAndSet() != null) {
                        // 先计算总行数
                        int totalRows = 0;
                        for (Object subObj : tbody.getIfAndForEachAndSet()) {
                            if (subObj instanceof Tr) {
                                totalRows++;
                            }
                        }

                        int i = 0;
                        for (Object subObj : tbody.getIfAndForEachAndSet()) {
                            if (subObj instanceof Tr) {
                                // 设置是否为第一行或最后一行的标志
                                if (i == 0) {
                                    EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_TBODY, true);
                                } else {
                                    EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_TBODY, false);
                                }

                                if (i == totalRows - 1) {
                                    EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_TBODY, true);
                                } else {
                                    EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_TBODY, false);
                                }

                                // 将 env 存储到 ThreadLocal 中，以便 getCssAttributeInternal 可以访问
                                NanhuprintThreadLocal.setEnv(env);

                                LineChild lineChild = new LineChild();

                                List<Element> elements = createTrOrReturnCache((Tr) subObj, env);
//								float begin = pdfPTable.calculateHeights();
                                float begin = pdfPTable.getTotalHeight();
                                addCell(pdfPTable, elements);
                                pdfPTable.completeRow();
//								float end = pdfPTable.calculateHeights();
                                float end = pdfPTable.getTotalHeight();
                                lineChild.setIndex(i);
                                lineChild.setHeight(end - begin);
//								lineChild.setElements(elements);

                                lineChildren.add(lineChild);

                                // 清除标志
                                EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_TBODY, false);
                                EvalUtil.setValueToNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_TBODY, false);

                                i++;
                            }
                        }
                    }
                }
            }
        }

        return lineChildren;
    }

    /**
     * 创建 tbody, 不计算每一行高度,只是把行按 tr 分组添加到 LineChild 中
     *
     * @param table
     * @param env
     * @return
     */
    private List<LineChild> createTbody(Table table, Map<String, Object> env) {
        List<LineChild> lineChildren = new ArrayList<>();
        if (table.getIfAndForEachAndSet() != null) {
            for (Object obj : table.getIfAndForEachAndSet()) {
                if (obj instanceof Tbody) {
                    Tbody tbody = (Tbody) obj;
                    if (tbody.getIfAndForEachAndSet() != null) {
                        int i = 0;
                        for (Object subObj : tbody.getIfAndForEachAndSet()) {
                            if (subObj instanceof Tr) {
                                LineChild lineChild = new LineChild();

                                List<Element> elements = createTrOrReturnCache((Tr) subObj, env);
                                lineChild.setIndex(i);
                                lineChild.setElements(elements);

                                lineChildren.add(lineChild);
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return lineChildren;
    }

    /**
     * 取得 tbody 中对应下标的那一行 tr 生成的 List<Element>
     *
     * @param table
     * @param env
     * @param index
     * @return
     */
    private List<Element> createTbody(Table table, Map<String, Object> env, int index) {
        if (table.getIfAndForEachAndSet() != null) {
            for (Object obj : table.getIfAndForEachAndSet()) {
                if (obj instanceof Tbody) {
                    Tbody tbody = (Tbody) obj;
                    if (tbody.getIfAndForEachAndSet() != null) {
                        int i = 0;
                        for (Object subObj : tbody.getIfAndForEachAndSet()) {
                            if (subObj instanceof Tr) {
                                if (i == index) {
                                    return createTrOrReturnCache((Tr) subObj, env);
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    /**
     * 创建一行或者直接从缓存中返回
     *
     * @param tr
     * @param env
     * @return
     */
    private List<Element> createTrOrReturnCache(Tr tr, Map<String, Object> env) {
        // 获取当前的页面边框标志
        Boolean isFirstLineOfPage = (Boolean) EvalUtil.getValueFromNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_PAGE);
        Boolean isLastLineOfPage = (Boolean) EvalUtil.getValueFromNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_PAGE);

        // 创建复合缓存键
        CacheKey cacheKey = new CacheKey(
            tr,
            isFirstLineOfPage != null && isFirstLineOfPage,
            isLastLineOfPage != null && isLastLineOfPage
        );

        // 尝试从缓存中获取
        if (objCache.get(cacheKey) != null) {
            return objCache.get(cacheKey);
        }

        // 缓存中没有，创建新元素
        EvalFactory evalFactory = new EvalFactory();
        IEval evalImplment = evalFactory.routeEval(tr);
        List<Element> result = evalImplment.evalToPdf(tr, env);

        // 如果 tr 子元素中包含 customContent 参数，则不缓存（因为内容是动态的）
        if (!recursiveFindCustomContent(tr)) {
            objCache.put(cacheKey, result);
        }

        return result;
    }

    /**
     * 递归查找自身或子元素包含有 customContent 的内容,有则不缓存
     *
     * @param metaObj
     * @return
     */
    private boolean recursiveFindCustomContent(Object metaObj) {
        List<Object> childLi = EvalUtil.getChildLi(metaObj);
        String customContent = EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_CUSTOM_CONTENT);
        if (StringUtils.isNotEmpty(customContent)) {
            return true;
        }
        if (childLi != null) {
            for (Object child : childLi) {
                if (recursiveFindCustomContent(child)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 取得 tloop 子元素生成的 element,tloop 有一个属性 mode,当配置 mode="two" 时,xml 中可以配置两行元素,以实现例如交替颜色填充之类的需求
     *
     * @param table
     * @param env
     * @return
     */
    private List<Element> createTloop(Table table, Map<String, Object> env, int index) {
        List<Element> result = new ArrayList<>();
        if (table.getIfAndForEachAndSet() != null) {
            for (Object obj : table.getIfAndForEachAndSet()) {
                if (obj instanceof Tloop) {
                    Tloop tloop = (Tloop) obj;
                    boolean isTwo = false;
                    if (StringUtils.isNotEmpty(tloop.getMode()) && tloop.getMode().equalsIgnoreCase(NanhuprintConstant.NANHUPRINT_TLOOP_ATTR_MODE_VALUE_TWO)) {
                        if (tloop.getIfAndForEachAndSet() == null || tloop.getIfAndForEachAndSet().size() < 2) {
                            throw new NanhuprintException("标签<tloop 配置了 mode='two',但是却没有包含两个子元素");
                        }
                    }
                    if (tloop.getIfAndForEachAndSet() != null) {
                        List<Object> childLi = new ArrayList<>();
                        if (isTwo) {
                            if (index % 2 == 0) {
                                childLi.add(tloop.getIfAndForEachAndSet().get(0));
                            } else {
                                childLi.add(tloop.getIfAndForEachAndSet().get(1));
                            }
                        } else {
                            childLi.addAll(tloop.getIfAndForEachAndSet());
                        }
                        for (Object subObj : childLi) {
                            EvalFactory evalFactory = new EvalFactory();
                            IEval evalImplment = evalFactory.routeEval(subObj);
                            result.addAll(evalImplment.evalToPdf(subObj, env));
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 创建 tbottom
     *
     * @param table
     * @param env
     * @return
     */
    private List<Element> createTbottomAll(Table table, Map<String, Object> env) {
        List<Element> result = new ArrayList<>();
        if (table.getIfAndForEachAndSet() != null) {
            for (Object obj : table.getIfAndForEachAndSet()) {
                if (obj instanceof Tbottom) {
                    Tbottom tbottom = (Tbottom) obj;
                    if (tbottom.getIfAndForEachAndSet() != null) {
                        for (Object subObj : tbottom.getIfAndForEachAndSet()) {
                            if (subObj instanceof Tr) {
                                result.addAll(createTrOrReturnCache((Tr) subObj, env));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private List<Element> createTbottom(Table table, ShowPositionEnum showPositionEnum, Map<String, Object> env) {
        List<Element> result = new ArrayList<>();
        if (table.getIfAndForEachAndSet() != null) {
            for (Object obj : table.getIfAndForEachAndSet()) {
                if (obj instanceof Tbottom) {
                    Tbottom tbottom = (Tbottom) obj;
                    String showPosition = StringUtils.defaultIfEmpty(tbottom.getShowPosition(), ShowPositionEnum.LAST_PAGE.getCode());
                    if (showPositionEnum.getCode().equalsIgnoreCase(showPosition)) {
                        if (tbottom.getIfAndForEachAndSet() != null) {
                            for (Object subObj : tbottom.getIfAndForEachAndSet()) {
                                if (subObj instanceof Tr) {
                                    result.addAll(createTrOrReturnCache((Tr) subObj, env));
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 取得 document.width - marginLeft - marginRight
     *
     * @param document
     * @return
     */
    private float getDocumentContentWidth(Document document) {
        float width = document.getPageSize().getRight() - document.getPageSize().getLeft();
        return width - document.leftMargin() - document.rightMargin();
    }

    /**
     * 取得 document.height - marginTop - marginBottom
     *
     * @param document
     * @return
     */
    private float getDocumentContentHeight(Document document) {
        float height = document.getPageSize().getTop() - document.getPageSize().getBottom();
        return height - document.topMargin() - document.bottomMargin();
    }
}
