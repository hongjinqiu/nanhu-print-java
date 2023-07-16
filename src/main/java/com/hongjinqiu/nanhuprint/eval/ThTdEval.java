package com.hongjinqiu.nanhuprint.eval;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.explain.ExplainUtil;
import com.hongjinqiu.nanhuprint.eval.vo.RowColumnVO;
import com.hongjinqiu.nanhuprint.model.Td;
import com.hongjinqiu.nanhuprint.model.Th;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Th 的解析类
 */
public class ThTdEval extends AbstractEval {
	private String childKey = "ifAndForEachAndSet";

	@Override
	public String getChildKey() {
		return childKey;
	}

	/**
	 * 解析所有的 if,forEach,set,spring el 等动态标签,生成 xml,
	 *
	 * @param metaObj
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	@Override
	public String evalDynamicElement(Object metaObj, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator) {
		String tagName;
		List<Object> childLi = getChildLi(metaObj);
		if (metaObj instanceof  Th) {
			tagName = "th";
		} else {
			tagName = "td";
		}

		return EvalUtil.commonEvalDynamicElement(tagName, metaObj, childLi, env, expressionEvaluator);
	}

	/**
	 * id 与 parentId 映射关系赋值
	 *
	 * @param metaObj
	 * @param parentObj
	 */
	@Override
	public void setIdAndParentId(Object metaObj, Object parentObj) {
		String parentId = EvalUtil.getIdValue(parentObj);
		EvalUtil.commonSetIdAndParentId(metaObj, parentId);
	}

	/**
	 * 设置id,宽度映射,
	 * 取得 rowColumnFlag 对应的下标,
	 * 再从 absoluteWidths 中累加宽度
	 * @param metaObj
	 */
	@Override
	public void setContentWidth(Object metaObj, float[] absoluteWidths, int[][] rowColumnFlag) {
		String id;
		List<Object> childLi;
		int rowspan = 1, colspan = 1;
		if (metaObj instanceof Th) {
			Th th = (Th)metaObj;
			id = th.getId();
			childLi = th.getIfAndForEachAndSet();
			if (StringUtils.isNotEmpty(th.getRowspan())) {
				rowspan = getInt(th.getRowspan());
			}
			if (StringUtils.isNotEmpty(th.getColspan())) {
				colspan = getInt(th.getColspan());
			}
		} else {
			Td td = (Td)metaObj;
			id = td.getId();
			childLi = td.getIfAndForEachAndSet();
			if (StringUtils.isNotEmpty(td.getRowspan())) {
				rowspan = getInt(td.getRowspan());
			}
			if (StringUtils.isNotEmpty(td.getColspan())) {
				colspan = getInt(td.getColspan());
			}
		}

		RowColumnVO rowColumnVO = getRowColumnFlag(rowColumnFlag);
		if (rowColumnVO == null) {
			throw new NanhuprintException("表格列数与 tr 底下的表格列数不匹配, 表格id为:" + id);
		}
		List<RowColumnVO> refList = new ArrayList<>();
		for (int tmpRow = rowColumnVO.getRow(); tmpRow < rowColumnVO.getRow() + rowspan; tmpRow++) {
			for (int tmpColumn = rowColumnVO.getColumn(); tmpColumn < rowColumnVO.getColumn() + colspan; tmpColumn++) {
				rowColumnFlag[tmpRow][tmpColumn] = 1;
				refList.add(new RowColumnVO(tmpRow, tmpColumn));
			}
		}
		float totalWidth = 0;
		for (int i = rowColumnVO.getColumn(); i < rowColumnVO.getColumn() + colspan; i++) {
			totalWidth += absoluteWidths[i];
		}

		totalWidth = totalWidth - EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_LEFT_WIDTH));
		totalWidth = totalWidth - EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.PADDING_LEFT));
		totalWidth = totalWidth - EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.PADDING_RIGHT));
		totalWidth = totalWidth - EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_RIGHT_WIDTH));

		NanhuprintThreadLocal.getContentWidthMap().put(id, totalWidth);
		float[] thtdAbsoluteWidths = new float[]{totalWidth};
		int[][] thtdRowColumnFlag = new int[][]{
			new int[]{0}
		};
		EvalUtil.loopSetContentWidth(metaObj, thtdAbsoluteWidths, thtdRowColumnFlag, childLi);// 把 table 的 absoluteWidths, rowColumnFlag 往下传
	}

	/**
	 * 字符串转整型
	 */
	private int getInt(String value) {
		float valueFloat = EvalUtil.getPrefixFloatValue(value);
		return new Float(valueFloat).intValue();
	}

	/**
	 * 取得下标
	 * @param rowColumnFlag
	 * @return
	 */
	private RowColumnVO getRowColumnFlag(int[][] rowColumnFlag) {
		for (int row = 0; row < rowColumnFlag.length; row++) {
			for (int column = 0; column < rowColumnFlag[row].length; column++) {
				if (rowColumnFlag[row][column] == 0) {
					return new RowColumnVO(row, column);
				}
			}
		}
		// 一般不会运行到这里,除非行数不匹配,
		return null;
	}

	/**
	 * id 与 metaObj 的映射
	 *
	 * @param metaObj
	 */
	@Override
	public void setIdAndMetaObj(Object metaObj) {
		EvalUtil.commonSetIdAndMetaObj(metaObj);
	}

	/**
	 * 将字体设到 threadLocal 的 map 里面,
	 * fontStyle:
	 * html:normal|italic
	 * fontWeight:
	 * html:normal|bold
	 * pdf中的值为:NORMAL|BOLD|ITALIC|BOLDITALIC
	 * fontSize
	 * fontFamily
	 */
	@Override
	public void setFontToMap(Object metaObj) {
		String id = EvalUtil.getValueByReflect(metaObj, "id");
		String parentId = NanhuprintThreadLocal.getKeyIdValueParentIdMap().get(id);
		Font parentFont = NanhuprintThreadLocal.getFontMap().get(parentId);
		Font thisFont = parentFont;

		EvalUtil.commonSetFontToMap(metaObj, thisFont);
	}

	/**
	 * 将 xml 元素解析并输出 pdf
	 * Th 标签输出成 PdfPCell 元素,同时往下分发元素而已
	 *
	 * @param metaObj
	 * @param env
	 * @return
	 */
	@Override
	public List<Element> evalToPdf(Object metaObj, Map<String, Object> env) {
		ExplainUtil.addExplain(metaObj, "===================== th/td(id:" + getId(metaObj) + ") explain begin =====================");
		if (isDisplayNoneOrVisibilityHidden(metaObj, childKey)) {
			ExplainUtil.addExplain(metaObj, "===================== th/td(id:" + getId(metaObj) + ") explain end =====================");
			ExplainUtil.outputExplain(getId(metaObj));
			return new ArrayList<>();
		}

		List<Object> childLi = getChildLi(metaObj);
		List<Element> result = new ArrayList<>();

		PdfPCell cell = EvalUtil.getPdfPCell(metaObj, env);
		// height 没值时,读取一下 Tr 的 height 值,
		EvalUtil.applyTrAttributeToTdTh(metaObj, cell);
		EvalUtil.addCellSubElements(metaObj, cell, childLi, env);
		EvalUtil.commonCustomContent(metaObj, cell, env);
		result.add(cell);
		ExplainUtil.addExplain(metaObj, "===================== th/td(id:" + getId(metaObj) + ") explain end =====================");
		ExplainUtil.outputExplain(getId(metaObj));
		return result;
	}

	/**
	 * 取得 id 值
	 * @param metaObj
	 * @return
	 */
	private String getId(Object metaObj) {
		if (metaObj instanceof  Th) {
			Th th = (Th) metaObj;
			return th.getId();
		} else {
			Td td = (Td) metaObj;
			return td.getId();
		}
	}

	/**
	 * 取得下级元素列表
	 * @param metaObj
	 * @return
	 */
	private List<Object> getChildLi(Object metaObj) {
		List<Object> childLi;
		if (metaObj instanceof  Th) {
			Th th = (Th) metaObj;
			childLi = th.getIfAndForEachAndSet();
		} else {
			Td th = (Td) metaObj;
			childLi = th.getIfAndForEachAndSet();
		}
		return childLi;
	}
}
