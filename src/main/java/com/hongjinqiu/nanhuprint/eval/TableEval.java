package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.explain.ExplainUtil;
import com.hongjinqiu.nanhuprint.event.BackgroundImageVO;
import com.hongjinqiu.nanhuprint.event.NanhuprintTableImageEvent;
import com.hongjinqiu.nanhuprint.model.Table;
import com.hongjinqiu.nanhuprint.model.Tbody;
import com.hongjinqiu.nanhuprint.model.Tbottom;
import com.hongjinqiu.nanhuprint.model.Td;
import com.hongjinqiu.nanhuprint.model.Th;
import com.hongjinqiu.nanhuprint.model.Thead;
import com.hongjinqiu.nanhuprint.model.Tr;
import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * com.hongjinqiu.nanhuprint.model.Table 的解析类
 */
public class TableEval extends AbstractEval {
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
		Table table = (Table) metaObj;
		return EvalUtil.commonEvalDynamicElement("table", metaObj, table.getIfAndForEachAndSet(), env, expressionEvaluator);
	}

	/**
	 * id 与 parentId 映射关系赋值
	 * @param metaObj
	 * @param parentObj
	 */
	@Override
	public void setIdAndParentId(Object metaObj, Object parentObj) {
		String parentId = EvalUtil.getIdValue(parentObj);
		EvalUtil.commonSetIdAndParentId(metaObj, parentId);
	}

	/**
	 * 设置id,宽度映射,需要根据传进来的 absoluteWidths 计算每个单元格的宽度
	 * @param metaObj
	 */
	@Override
	public void setContentWidth(Object metaObj, float[] absoluteWidths, int[][] rowColumnFlag) {
		Table table = (Table)metaObj;

        float tableContentWidth;
        String tableWidth = EvalUtil.getCssAttribute(table, NanhuprintConstant.WIDTH);
        // A:宽度没赋值,
        if (StringUtils.isEmpty(tableWidth)) {
            tableContentWidth = absoluteWidths[0];// 宽度为0时,因为是渲染成 百分百,因此,直接取值,
        } else if (tableWidth.endsWith(NanhuprintConstant.PERCENT)) {// B:宽度设百分比
            tableContentWidth = absoluteWidths[0] * EvalUtil.getPrefixFloatValue(tableWidth) / 100;
        } else {// 绝对值宽度
            tableContentWidth = EvalUtil.getPrefixFloatValue(tableWidth);
        }
        float[] maybePercentWidths = getColumnWidthsForCalcContentWidth(table);
        float[] tableAbsoluteWidths = new float[maybePercentWidths.length];
        float total = 0;
        for (int i = 0; i < maybePercentWidths.length; i++) {
            total += maybePercentWidths[i];
        }
        for (int i = 0; i < maybePercentWidths.length; i++) {
            tableAbsoluteWidths[i] = maybePercentWidths[i]/ total * tableContentWidth;
        }

        NanhuprintThreadLocal.getContentWidthMap().put(table.getId(), tableContentWidth);

        int columnCount = tableAbsoluteWidths.length;
        int rowCount = getRowCount(table);
        if (rowCount > 0) {
            int[][] tableRowColumnFlag = new int[rowCount][columnCount];
            for (int[] array: tableRowColumnFlag) {
                Arrays.fill(array, 0);
            }
            EvalUtil.loopSetContentWidth(metaObj, tableAbsoluteWidths, tableRowColumnFlag, table.getIfAndForEachAndSet());
        }
	}

	/**
	 * 取得 table 的行数, thead + tbody + tbottom 的 tr 之和
	 * @param table
	 */
	private int getRowCount(Table table) {
		int rowCount = 0;
		if (table.getIfAndForEachAndSet() != null) {
			for (Object child: table.getIfAndForEachAndSet()) {
				if (child instanceof Thead) {
					Thead element = (Thead)child;
					rowCount += addRowCountIfTr(element.getIfAndForEachAndSet());
				} else if (child instanceof Tbody) {
					Tbody element = (Tbody)child;
					rowCount += addRowCountIfTr(element.getIfAndForEachAndSet());
				} else if (child instanceof Tbottom) {
					Tbottom element = (Tbottom)child;
					rowCount += addRowCountIfTr(element.getIfAndForEachAndSet());
				}
			}
		}
		return rowCount;
	}

	/**
	 * 逐行 + 1
	 * @param childLi
	 * @return
	 */
	private int addRowCountIfTr(List<Object> childLi) {
		int rowCount = 0;
		if (childLi != null) {
            for (Object subChild: childLi) {
                if (subChild instanceof Tr) {
                    rowCount++;
                }
            }
        }
		return rowCount;
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
	 * 将 xml 元素解析并输出 pdf,对应 PdfPTable,
	 * @param metaObj
	 * @param env
	 * @return
	 */
	@Override
	public List<Element> evalToPdf(Object metaObj, Map<String, Object> env) {
		Table table = (Table)metaObj;
		ExplainUtil.addExplain(metaObj, "===================== table(id:" + table.getId() + ") explain begin =====================");
		if (isDisplayNoneOrVisibilityHidden(metaObj, childKey)) {
			ExplainUtil.addExplain(metaObj, "===================== table(id:" + table.getId() + ") explain end =====================");
			ExplainUtil.outputExplain(table.getId());
			return new ArrayList<>();
		}

		List<Element> result = new ArrayList<>();
		PdfPTable pdfPTable = getPdfPTable(table);
		if (table.getIfAndForEachAndSet() != null && table.getIfAndForEachAndSet().size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj: table.getIfAndForEachAndSet()) {
				IEval evalImplment = evalFactory.routeEval(obj);
				List<Element> elements = evalImplment.evalToPdf(obj, env);
				if (elements != null && elements.size() > 0) {
					for (Element element: elements) {
						pdfPTable.addCell((PdfPCell)element);
					}
				}
			}
			pdfPTable.completeRow();
			EvalUtil.commonCustomContent(metaObj, pdfPTable, env);
			pdfPTable.setComplete(true);
		}
		result.add(pdfPTable);
		ExplainUtil.addExplain(metaObj, "===================== table(id:" + table.getId() + ") explain end =====================");
		ExplainUtil.outputExplain(table.getId());
		return result;
	}

	/**
	 * A:宽度没赋值,
	 * B:宽度设百分比
	 * C:宽度设绝对值(像素等)
	 *
	 * 1.Table 元素width 属于 A
	 * 		pdfPTable.setWidthPercentage(100);
	 * 1.1.子元素 A,
	 * 		pdfPTable.setWidths(new float[]{1,1,1,......});
	 * 1.2.子元素 B
	 * 		pdfPTable.setWidths(new float[]{
	 * 			{配置的value1},{配置的value2},{配置的value3},......
	 * 		});
	 * 1.3.子元素 C
	 *		pdfPTable.setTotalWidth(子元素的宽度和);
	 *		pdfPTable.setLockedWidth(true);
	 *		pdfPTable.setWidths(new float[]{
	 * 			{配置的value1},{配置的value2},{配置的value3},......
	 * 		});
	 * 1.4.子元素 A + B
	 * 		pdfPTable.setWidthPercentage(100);
	 * 		1.4.1.有赋值之和为 Sum1,未赋值单元格数为 n, sum1 < 100, 则未赋值单元格宽度为; (100 - sum1) / n
	 * 		1.4.2.有赋值之和为 Sum1,未赋值单元格数为 n, sum1 > 100, 则未赋值单元格宽度为; 1
	 * 1.5.子元素 A + C
	 * 		按 1.4 处理
	 * 1.6.子元素 B + C
	 *		按 1.2 处理
	 * 1.7.子元素 A + B + C
	 * 		按 1.4 处理
	 * 2.Table 元素width 属于 B
	 * 		pdfPTable.setWidthPercentage(属性设的值);
	 * 2.1.子元素 A,
	 *		按 1.1 处理
	 	2.2. 子元素 B,
	 		按 1.2 处理
	 	2.3. 子元素 C,
	 		按 1.2 处理
	 	2.4. 子元素 A + B,
	 		pdfPTable.setWidthPercentage(属性设的值);
	 		其余的按 1.4 处理
	 	2.5. 子元素 A + C,
	 		按 2.4 处理
	 	2.6. 子元素 B + C,
	 		按 1.2 处理
	 	2.7. 子元素 A + B + C,
	 		按 2.4 处理
	 * 3.Table 元素width 属于 C
	 * 		pdfPTable.setTotalWidth(设置的宽度值);
	 *		pdfPTable.setLockedWidth(true);
	 *	3.1. 子元素 A,
	 *		按 1.1. 处理
		3.2. 子元素 B,
	 		按 1.2. 处理
		3.3 子元素 C,
	 		按 1.2. 处理
		3.4 子元素 A + B,
	 		按 1.4. 处理
		3.5 子元素 A + C,
	 		如果小于自己设的绝对值宽度,则用 sum - subSum 平分,否则,没宽度的单元格设1,
		3.6 子元素 B + C,
	 		按 1.2. 处理
		3.7 子元素 A + B + C,
	 		按 1.4. 处理
	 * @param table
	 * @return
	 */
	private PdfPTable getPdfPTable(Table table) {
		List<String> widths = getColumnWidths(table);
		int numColumns = widths.size();
		if (numColumns == 0) {
			throw new NanhuprintException("The number of columns in PdfPTable constructor must be greater than zero. <table>标签至少应该包含 thead,tbody,tbottom 子标签,子标签至少应该有一个 tr,td");
		}

		String tableWidth = EvalUtil.getCssAttribute(table, NanhuprintConstant.WIDTH);

		// 共用绝对值宽度的方法,
		if (StringUtils.isNotEmpty(tableWidth) && !(tableWidth.endsWith(NanhuprintConstant.PERCENT))) {
			return getPdfPTableWithLockWith(table, EvalUtil.getPrefixFloatValue(tableWidth));
		}

		PdfPTable pdfPTable = new PdfPTable(numColumns);
		ExplainUtil.addExplain(table, "表格列数->" + numColumns);

		EvalUtil.setPdfPTableCommonAttribute(table, pdfPTable);
		setPdfPTableBackgroundImageEvent(table, pdfPTable);

		int countA = getColumnACount(widths);
		int countB = getColumnBCount(widths);
		int countC = getColumnCCount(widths);

		// A:宽度没赋值,
		if (StringUtils.isEmpty(tableWidth)) {
			pdfPTable.setWidthPercentage(100);
			ExplainUtil.addExplain(table, "table 宽度没设值,程序赋值为百分比 -> 100");
			if (numColumns == countA) {// 1.1.子元素 A,
				dealTableWidth1_1(table, widths, pdfPTable);
			} else if (numColumns == countB) {// 1.2.子元素 B
				dealTableWidth1_2(table, widths, pdfPTable);
			} else if (numColumns == countC) {// 1.3.子元素 C
				dealTableWidth1_3(table, widths, pdfPTable);
			} else if (numColumns == (countA + countB)) {// 1.4.子元素 A + B
				dealTableWidth1_4(table, 100, widths, pdfPTable);
			} else if (numColumns == (countA + countC)) {// 1.5.子元素 A + C
				dealTableWidth1_4(table, 100, widths, pdfPTable);
			} else if (numColumns == (countB + countC)) {// 1.6.子元素 B + C
				dealTableWidth1_2(table, widths, pdfPTable);
			} else if (numColumns == (countA + countB + countC)) {// 1.7.子元素 A + B + C
				dealTableWidth1_4(table, 100, widths, pdfPTable);
			}
		} else if (tableWidth.endsWith(NanhuprintConstant.PERCENT)) {// B:宽度设百分比
			float tableWidthFloat = EvalUtil.getPrefixFloatValue(tableWidth);
			tableWidthFloat = tableWidthFloat == 0 ? 100 : tableWidthFloat;
			pdfPTable.setWidthPercentage(tableWidthFloat);
			ExplainUtil.addExplain(table, "table 宽度设了百分比,setWidthPercentage->" + tableWidthFloat);
			if (numColumns == countA) {// 2.2.子元素 A,
				dealTableWidth1_1(table, widths, pdfPTable);
			} else if (numColumns == countB) {// 2.2.子元素 B
				dealTableWidth1_2(table, widths, pdfPTable);
			} else if (numColumns == countC) {// 2.3.子元素 C
				dealTableWidth1_2(table, widths, pdfPTable);// 这里用的是 1_2, 拷贝时不要拷贝错了,不是 1_3
			} else if (numColumns == (countA + countB)) {// 2.4.子元素 A + B
				dealTableWidth1_4(table, 100, widths, pdfPTable);
			} else if (numColumns == (countA + countC)) {// 2.5.子元素 A + C
				dealTableWidth1_4(table, 100, widths, pdfPTable);
			} else if (numColumns == (countB + countC)) {// 2.6.子元素 B + C
				dealTableWidth1_2(table, widths, pdfPTable);
			} else if (numColumns == (countA + countB + countC)) {// 2.7.子元素 A + B + C
				dealTableWidth1_4(table, 100, widths, pdfPTable);
			}
		}


		return pdfPTable;
	}

	/**
	 * 取得绝对值宽度的表格,在 body 配置为 extendToFillBody 时,会用到这个方法,
	 * 固定表格的宽度,使得可以计算出表格的内容的高度
	 */
	public PdfPTable getPdfPTableWithLockWith(Table table, float width) {
		List<String> widths = getColumnWidths(table);
		int numColumns = widths.size();
		if (numColumns == 0) {
			throw new NanhuprintException("The number of columns in PdfPTable constructor must be greater than zero. <table>标签至少应该包含 thead,tbody,tbottom 子标签,子标签至少应该有一个 tr,td");
		}
		PdfPTable pdfPTable = new PdfPTable(numColumns);
		ExplainUtil.addExplain(table, "表格列数->" + numColumns);

		EvalUtil.setPdfPTableCommonAttribute(table, pdfPTable);
		setPdfPTableBackgroundImageEvent(table, pdfPTable);

		int countA = getColumnACount(widths);
		int countB = getColumnBCount(widths);
		int countC = getColumnCCount(widths);

		pdfPTable.setTotalWidth(width);
		pdfPTable.setLockedWidth(true);
		ExplainUtil.addExplain(table, "table 宽度配置为绝对值,table.setLockedWidth(true),setTotalWidth->" + width);
		if (numColumns == countA) {// 3.3.子元素 A,
			dealTableWidth1_1(table, widths, pdfPTable);
		} else if (numColumns == countB) {// 3.2.子元素 B
			dealTableWidth1_2(table, widths, pdfPTable);
		} else if (numColumns == countC) {// 3.3.子元素 C
			dealTableWidth1_2(table, widths, pdfPTable);
		} else if (numColumns == (countA + countB)) {// 3.4.子元素 A + B
			dealTableWidth1_4(table, 100, widths, pdfPTable);
		} else if (numColumns == (countA + countC)) {// 3.5.子元素 A + C
			dealTableWidth1_4(table, width, widths, pdfPTable);
		} else if (numColumns == (countB + countC)) {// 3.6.子元素 B + C
			dealTableWidth1_2(table, widths, pdfPTable);
		} else if (numColumns == (countA + countB + countC)) {// 3.7.子元素 A + B + C
			dealTableWidth1_4(table, 100, widths, pdfPTable);
		}

		return pdfPTable;
	}

	/**
	 * 设置背景图,
	 * 注:div 也是渲染成 PdfPTable, 但是 div 上配置的 backgroundImage 是映射到 PdfPCell 上,
	 * 这个方法是给 table 调用
	 */
	private void setPdfPTableBackgroundImageEvent(Table table, PdfPTable pdfPTable) {
		String attributeValue = EvalUtil.getCssAttribute(table, NanhuprintConstant.BACKGROUND_IMAGE);
		if (org.apache.commons.lang3.StringUtils.isNotEmpty(attributeValue)) {
			// url('http://xxxx')
			try {
				Pattern pattern = Pattern.compile("url\\(['\"]?(.*?)['\"]?\\)", Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(attributeValue);
				if (matcher.find()) {
					String urlText = matcher.group(1);

					BackgroundImageVO backgroundImageVO = new BackgroundImageVO();
					backgroundImageVO.setImg(Image.getInstance(new URL(urlText)));
					backgroundImageVO.setBackgroundSize(EvalUtil.getCssAttribute(table, NanhuprintConstant.BACKGROUND_SIZE));
					backgroundImageVO.setBackgroundPositionX(EvalUtil.getCssAttribute(table, NanhuprintConstant.BACKGROUND_POSITION_X));
					backgroundImageVO.setBackgroundPositionY(EvalUtil.getCssAttribute(table, NanhuprintConstant.BACKGROUND_POSITION_Y));
					backgroundImageVO.setBackgroundImageOpacityByPdf(EvalUtil.getCssAttribute(table, NanhuprintConstant.BACKGROUND_IMAGE_OPACITY_BY_PDF));

					NanhuprintTableImageEvent imgEvent = new NanhuprintTableImageEvent(backgroundImageVO);
					pdfPTable.setTableEvent(imgEvent);
				}
			} catch (MalformedURLException e) {
				logger.error(e.getMessage(), e);
//					throw new NanhuprintException(e);
			} catch (BadElementException e) {
				logger.error(e.getMessage(), e);
//					throw new NanhuprintException(e);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
//					throw new NanhuprintException(e);
			}
		}
	}

	/**
	 * 1.1.子元素 A,
	 */
	private void dealTableWidth1_1(Table table, List<String> widths, PdfPTable pdfPTable) {
		try {
			float[] widthsFloat = dealTableWidth1_1_common(widths);
			ExplainUtil.addExplain(table, "子标签 td/th 都没设宽度,setWidths->(" + ObjectUtils.defaultIfNull(widthsFloat, "null") + ")");
			pdfPTable.setWidths(widthsFloat);
		} catch (DocumentException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}
	}

	private float[] dealTableWidth1_1_common(List<String> widths) {
		float[] widthsFloat = new float[widths.size()];
		Arrays.fill(widthsFloat, 1);
		return widthsFloat;
	}

	/**
	 * 1.2.子元素 B
	 * @param widths
	 * @param pdfPTable
	 */
	private void dealTableWidth1_2(Table table, List<String> widths, PdfPTable pdfPTable) {
		try {
			float[] widthsFloat = dealTableWidth1_2_common(widths);
			ExplainUtil.addExplain(table, "子标签 td/th 宽度都配置为百分比,setWidths->(" + ObjectUtils.defaultIfNull(widthsFloat, "null") + ")");
			pdfPTable.setWidths(widthsFloat);
		} catch (DocumentException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}
	}

	private float[] dealTableWidth1_2_common(List<String> widths) {
		float[] widthsFloat = new float[widths.size()];
		for (int i = 0; i < widths.size(); i++) {
			widthsFloat[i] = EvalUtil.getPrefixFloatValue(widths.get(i));
		}
		return widthsFloat;
	}

	/**
	 * 1.3.子元素 C
	 * @param widths
	 * @param pdfPTable
	 */
	private void dealTableWidth1_3(Table table, List<String> widths, PdfPTable pdfPTable) {
		float[] widthsFloat = dealTableWidth1_3_common(widths);
		try {
			pdfPTable.setTotalWidth(widthsFloat);
			pdfPTable.setLockedWidth(true);

			pdfPTable.setWidths(widthsFloat);
			ExplainUtil.addExplain(table, "子标签 td/th 宽度都配置为绝对值,table.setLockedWidth(true),setTotalWidth->" + widthsFloat + ", setWidths->(" + ObjectUtils.defaultIfNull(widthsFloat, "null") + ")");
		} catch (DocumentException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}
	}

	private float[] dealTableWidth1_3_common(List<String> widths) {
		float[] widthsFloat = new float[widths.size()];
		for (int i = 0; i < widths.size(); i++) {
			widthsFloat[i] = EvalUtil.getPrefixFloatValue(widths.get(i));
		}
		return widthsFloat;
	}

	/**
	 * 1.4.子元素 A + B
	 * @param widths
	 * @param pdfPTable
	 */
	private void dealTableWidth1_4(Table table, float percentOrAbsoluteValue, List<String> widths, PdfPTable pdfPTable) {
		float[] widthsFloat = dealTableWidth1_4_common(percentOrAbsoluteValue, widths);
		if (widthsFloat != null) {
			try {
				pdfPTable.setWidths(widthsFloat);
				ExplainUtil.addExplain(table, "子标签 td/th 宽度部分赋值,部分未赋值,setWidths->(" + ObjectUtils.defaultIfNull(widthsFloat, "null") + ")");
			} catch (DocumentException e) {
				logger.error(e.getMessage(), e);
				throw new NanhuprintException(e);
			}
		}
	}

	private float[] dealTableWidth1_4_common(float percentOrAbsoluteValue, List<String> widths) {
		float sum = 0;
		float count0 = 0;
		float[] widthsFloat = new float[widths.size()];
		for (int i = 0; i < widths.size(); i++) {
			widthsFloat[i] = EvalUtil.getPrefixFloatValue(widths.get(i));
			sum += widthsFloat[i];
			if (widthsFloat[i] == 0) {
				count0++;
			}
		}
		if (count0 == 0) {
			return null;
		}
		// 1.4.1.有赋值之和为 Sum1,未赋值单元格数为 n, sum1 < percentOrAbsoluteValue, 则未赋值单元格宽度为; (percentOrAbsoluteValue - sum) / n
		if (sum < percentOrAbsoluteValue) {
			for (int i = 0; i < widthsFloat.length; i++) {
				if (widthsFloat[i] == 0) {
					widthsFloat[i] = (percentOrAbsoluteValue - sum) / count0;
				}
			}
		} else {
			// 1.4.2.有赋值之和为 Sum1,未赋值单元格数为 n, sum1 > percentOrAbsoluteValue, 则未赋值单元格宽度为; 1
			for (int i = 0; i < widthsFloat.length; i++) {
				if (widthsFloat[i] == 0) {
					widthsFloat[i] = 1;
				}
			}
		}
		return widthsFloat;
	}

	/**
	 * A:宽度没赋值的单元格列数
	 * @return
	 */
	private int getColumnACount(List<String> widths) {
		int sum = 0;
		for (String width: widths) {
			if (StringUtils.isEmpty(width)) {
				sum++;
			}
		}
		return sum;
	}

	/**
	 * B:宽度设百分比
	 * @return
	 */
	private int getColumnBCount(List<String> widths) {
		int sum = 0;
		for (String width: widths) {
			if (StringUtils.isNotEmpty(width) && width.endsWith(NanhuprintConstant.PERCENT)) {
				sum++;
			}
		}
		return sum;
	}

	/**
	 * C:宽度设绝对值(像素等)
	 * @return
	 */
	private int getColumnCCount(List<String> widths) {
		int sum = 0;
		for (String width: widths) {
			if (StringUtils.isNotEmpty(width) && !width.endsWith(NanhuprintConstant.PERCENT)) {// 不为空,不以百分比结尾
				sum++;
			}
		}
		return sum;
	}

	/**
	 * 取得列数,
	 * 第一个 thead -> tr -> td|th
	 * 第一个 tbody -> tr -> td|th
	 * 第一个 tbottom -> tr -> td|th
	 * @param table
	 * @return
	 */
	private List<String> getColumnWidths(Table table) {
		if (table.getIfAndForEachAndSet() != null && table.getIfAndForEachAndSet().size() > 0) {
			for (Object obj: table.getIfAndForEachAndSet()) {
				if (obj instanceof Thead) {
					Thead thead = (Thead)obj;
					if (thead.getIfAndForEachAndSet() != null && thead.getIfAndForEachAndSet().size() > 0) {
						for (Object maybeTrObj: thead.getIfAndForEachAndSet()) {
							if (maybeTrObj instanceof Tr) {
								Tr tr = (Tr)maybeTrObj;
								if (tr.getIfAndForEachAndSet() != null && tr.getIfAndForEachAndSet().size() > 0) {
									List<String> result = new ArrayList<>();
									for (Object mayBeThOrTdObj: tr.getIfAndForEachAndSet()) {
										if (mayBeThOrTdObj instanceof Th || mayBeThOrTdObj instanceof Td) {
											result.add(EvalUtil.getCssAttribute(mayBeThOrTdObj, NanhuprintConstant.WIDTH));
										}
									}
									return result;
								}
							}
						}
					}
				}
				if (obj instanceof Tbody) {
					Tbody tbody = (Tbody)obj;
					if (tbody.getIfAndForEachAndSet() != null && tbody.getIfAndForEachAndSet().size() > 0) {
						for (Object maybeTrObj: tbody.getIfAndForEachAndSet()) {
							if (maybeTrObj instanceof Tr) {
								Tr tr = (Tr)maybeTrObj;
								if (tr.getIfAndForEachAndSet() != null && tr.getIfAndForEachAndSet().size() > 0) {
									List<String> result = new ArrayList<>();
									for (Object mayBeThOrTdObj: tr.getIfAndForEachAndSet()) {
										if (mayBeThOrTdObj instanceof Th || mayBeThOrTdObj instanceof Td) {
											result.add(EvalUtil.getCssAttribute(mayBeThOrTdObj, NanhuprintConstant.WIDTH));
										}
									}
									return result;
								}
							}
						}
					}
				}
				if (obj instanceof Tbottom) {
					Tbottom tbottom = (Tbottom)obj;
					if (tbottom.getIfAndForEachAndSet() != null && tbottom.getIfAndForEachAndSet().size() > 0) {
						for (Object maybeTrObj: tbottom.getIfAndForEachAndSet()) {
							if (maybeTrObj instanceof Tr) {
								Tr tr = (Tr)maybeTrObj;
								if (tr.getIfAndForEachAndSet() != null && tr.getIfAndForEachAndSet().size() > 0) {
									List<String> result = new ArrayList<>();
									for (Object mayBeThOrTdObj: tr.getIfAndForEachAndSet()) {
										if (mayBeThOrTdObj instanceof Th || mayBeThOrTdObj instanceof Td) {
											result.add(EvalUtil.getCssAttribute(mayBeThOrTdObj, NanhuprintConstant.WIDTH));
										}
									}
									return result;
								}
							}
						}
					}
				}
			}
		}
//		return 0;
		return new ArrayList<>();
	}

	/**
	 * 供计算表格宽度调用,返回每列百分比值
	 * @return
	 */
	private float[] getColumnWidthsForCalcContentWidth(Table table) {
		List<String> widths = getColumnWidths(table);
		int numColumns = widths.size();
		if (numColumns == 0) {
			throw new NanhuprintException("The number of columns in PdfPTable constructor must be greater than zero. <table>标签至少应该包含 thead,tbody,tbottom 子标签,子标签至少应该有一个 tr,td");
		}

		String tableWidth = EvalUtil.getCssAttribute(table, NanhuprintConstant.WIDTH);

		// 共用绝对值宽度的方法,
		if (StringUtils.isNotEmpty(tableWidth) && !(tableWidth.endsWith(NanhuprintConstant.PERCENT))) {
			return getPdfPTableWithLockWithForCalcContentWidth(table, EvalUtil.getPrefixFloatValue(tableWidth));
		}

		int countA = getColumnACount(widths);
		int countB = getColumnBCount(widths);
		int countC = getColumnCCount(widths);

		// A:宽度没赋值,
		if (StringUtils.isEmpty(tableWidth)) {
			if (numColumns == countA) {// 1.1.子元素 A,
				return dealTableWidth1_1_common(widths);
			} else if (numColumns == countB) {// 1.2.子元素 B
				return dealTableWidth1_2_common(widths);
			} else if (numColumns == countC) {// 1.3.子元素 C
				return dealTableWidth1_3_common(widths);
			} else if (numColumns == (countA + countB)) {// 1.4.子元素 A + B
				return dealTableWidth1_4_common(100, widths);
			} else if (numColumns == (countA + countC)) {// 1.5.子元素 A + C
				return dealTableWidth1_4_common(100, widths);
			} else if (numColumns == (countB + countC)) {// 1.6.子元素 B + C
				return dealTableWidth1_2_common(widths);
			} else if (numColumns == (countA + countB + countC)) {// 1.7.子元素 A + B + C
				return dealTableWidth1_4_common(100, widths);
			}
		} else if (tableWidth.endsWith(NanhuprintConstant.PERCENT)) {// B:宽度设百分比
			if (numColumns == countA) {// 2.2.子元素 A,
				return dealTableWidth1_1_common(widths);
			} else if (numColumns == countB) {// 2.2.子元素 B
				return dealTableWidth1_2_common(widths);
			} else if (numColumns == countC) {// 2.3.子元素 C
				return dealTableWidth1_2_common(widths);// 这里用的是 1_2, 拷贝时不要拷贝错了,不是 1_3
			} else if (numColumns == (countA + countB)) {// 2.4.子元素 A + B
				return dealTableWidth1_4_common(100, widths);
			} else if (numColumns == (countA + countC)) {// 2.5.子元素 A + C
				return dealTableWidth1_4_common(100, widths);
			} else if (numColumns == (countB + countC)) {// 2.6.子元素 B + C
				return dealTableWidth1_2_common(widths);
			} else if (numColumns == (countA + countB + countC)) {// 2.7.子元素 A + B + C
				return dealTableWidth1_4_common(100, widths);
			}
		}


		return null;
	}

	public float[] getPdfPTableWithLockWithForCalcContentWidth(Table table, float width) {
		List<String> widths = getColumnWidths(table);
		int numColumns = widths.size();
		if (numColumns == 0) {
			throw new NanhuprintException("The number of columns in PdfPTable constructor must be greater than zero. <table>标签至少应该包含 thead,tbody,tbottom 子标签,子标签至少应该有一个 tr,td");
		}

		int countA = getColumnACount(widths);
		int countB = getColumnBCount(widths);
		int countC = getColumnCCount(widths);

		if (numColumns == countA) {// 3.3.子元素 A,
			return dealTableWidth1_1_common(widths);
		} else if (numColumns == countB) {// 3.2.子元素 B
			return dealTableWidth1_2_common(widths);
		} else if (numColumns == countC) {// 3.3.子元素 C
			return dealTableWidth1_2_common(widths);
		} else if (numColumns == (countA + countB)) {// 3.4.子元素 A + B
			return dealTableWidth1_4_common(100, widths);
		} else if (numColumns == (countA + countC)) {// 3.5.子元素 A + C
			return dealTableWidth1_4_common(width, widths);
		} else if (numColumns == (countB + countC)) {// 3.6.子元素 B + C
			return dealTableWidth1_2_common(widths);
		} else if (numColumns == (countA + countB + countC)) {// 3.7.子元素 A + B + C
			return dealTableWidth1_4_common(100, widths);
		}

		return null;
	}

}
