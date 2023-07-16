package com.hongjinqiu.nanhuprint.eval;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.explain.ExplainUtil;
import com.hongjinqiu.nanhuprint.model.Div;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Div 的解析类
 */
public class DivEval extends AbstractEval {
	private String childKey = "ifAndForEachAndSet";

	@Override
	public String getChildKey() {
		return childKey;
	}

	/**
	 * 解析所有的 if,forEach,set,spring el 等动态标签,生成 xml,
	 * @param metaObj
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	@Override
	public String evalDynamicElement(Object metaObj, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator) {
		Div div = (Div)metaObj;
		return EvalUtil.commonEvalDynamicElement("div", metaObj, div.getIfAndForEachAndSet(), env, expressionEvaluator);
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
	 * 设置id,宽度映射, div 是解析成 table 单个 td,
	 * 往子元素传宽度时,要扣除 边框, paddingLeft, paddingRight
	 * @param metaObj
	 */
	@Override
	public void setContentWidth(Object metaObj, float[] absoluteWidths, int[][] rowColumnFlag) {
		Div div = (Div)metaObj;

		float divContentWidth = absoluteWidths[0];
		String width = EvalUtil.getCssAttribute(div, NanhuprintConstant.WIDTH);
		if (StringUtils.isEmpty(width)) {
			// do nothing
		} else {
			if (width.endsWith(NanhuprintConstant.PERCENT)) {
				float percent = EvalUtil.getPrefixFloatValue(width);
				if (percent > 0) {
					divContentWidth = divContentWidth * (percent / 100);
				}
			} else {
				divContentWidth = EvalUtil.getPrefixFloatValue(width);
			}
		}

		divContentWidth = divContentWidth - EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(div, NanhuprintConstant.BORDER_LEFT_WIDTH));
		divContentWidth = divContentWidth - EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(div, NanhuprintConstant.PADDING_LEFT));
		divContentWidth = divContentWidth - EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(div, NanhuprintConstant.PADDING_RIGHT));
		divContentWidth = divContentWidth - EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(div, NanhuprintConstant.BORDER_RIGHT_WIDTH));

		float[] divAbsoluteWidths = new float[]{divContentWidth};
		int[][] bodyRowColumnFlag = new int[][]{
			new int[]{0}
		};
		NanhuprintThreadLocal.getContentWidthMap().put(div.getId(), divContentWidth);
		EvalUtil.loopSetContentWidth(metaObj, divAbsoluteWidths, bodyRowColumnFlag, div.getIfAndForEachAndSet());
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
	 * 将 xml 元素解析并输出 pdf,
	 * div 元素输出为 只有一个 td 的 table,
	 *
	 * @param metaObj
	 * @param env
	 * @return
	 */
	@Override
	public List<Element> evalToPdf(Object metaObj, Map<String, Object> env) {
		Div div = (Div)metaObj;
		ExplainUtil.addExplain(metaObj, "===================== div(id:" + div.getId() + ") explain begin =====================");
		// display:none,visibility: hidden;	// 直接不输出
		if (isDisplayNoneOrVisibilityHidden(metaObj, childKey)) {
			ExplainUtil.addExplain(metaObj, "===================== div(id:" + div.getId() + ") explain end =====================");
			ExplainUtil.outputExplain(div.getId());
			return new ArrayList<>();
		}

		List<Element> result = new ArrayList<>();
		PdfPTable pdfPTable = getPdfPTable(div);
		PdfPCell cell = EvalUtil.getPdfPCell(div, env);
		EvalUtil.addCellSubElements(metaObj, cell, div.getIfAndForEachAndSet(), env);
		EvalUtil.commonCustomContent(metaObj, cell, env);
		pdfPTable.addCell(cell);
		result.add(pdfPTable);
		ExplainUtil.addExplain(metaObj, "===================== div(id:" + div.getId() + ") explain end =====================");
		ExplainUtil.outputExplain(div.getId());
		return result;
	}

	/**
	 * 1.没设宽度,设为 100%
	 * 2.设为宽度
	 * 2.1.百分比宽度	widthPercentage
	 * 2.2.像素宽度,	lockWidth(true);setTotalWidth
	 *
	 * @param div
	 */
	private PdfPTable getPdfPTable(Div div) {
		PdfPTable pdfPTable = new PdfPTable(1);
		ExplainUtil.addExplain(div, "表格列数->" + 1);
		String width = EvalUtil.getCssAttribute(div, NanhuprintConstant.WIDTH);
		if (StringUtils.isEmpty(width)) {
			pdfPTable.setWidthPercentage(100);
			ExplainUtil.addExplain(div, "div table 宽度没设值,程序赋值为百分比 -> 100");
		} else {
			if (width.endsWith(NanhuprintConstant.PERCENT)) {
				float widthFloat = EvalUtil.getPrefixFloatValue(width);
				pdfPTable.setWidthPercentage(widthFloat);
				ExplainUtil.addExplain(div, "div table 宽度设了百分比,setWidthPercentage->" + widthFloat);
			} else {
				float widthFloat = EvalUtil.getPrefixFloatValue(width);
				pdfPTable.setTotalWidth(widthFloat);
				pdfPTable.setLockedWidth(true);
				ExplainUtil.addExplain(div, "div table 宽度配置为绝对值,table.setLockedWidth(true),setTotalWidth->" + widthFloat);
			}
		}

		EvalUtil.setPdfPTableCommonAttribute(div, pdfPTable);

		try {
			pdfPTable.setWidths(new float[]{1});
			ExplainUtil.addExplain(div, "div table setWidths->new float[]{1}");
		} catch (DocumentException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}

		return pdfPTable;
	}
}
