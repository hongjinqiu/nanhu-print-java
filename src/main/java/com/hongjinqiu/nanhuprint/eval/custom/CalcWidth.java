package com.hongjinqiu.nanhuprint.eval.custom;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.EvalFactory;
import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import com.hongjinqiu.nanhuprint.eval.IEval;
import com.hongjinqiu.nanhuprint.model.Div;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * 计算动态宽度实现
 */
public class CalcWidth implements ICalcWidth {

	/**
	 * 取得 calcWidthTagId 对应值的目标的字符串宽度,
	 * 0.目标必须是 div,
	 * 1.取得这个 div 对应的字体,
	 * 2.返回这个字体计算出来的文本的宽度 + borderLeftWidth + paddingLeft + paddingRight + borderRightWidth
	 * @param metaObj 当前的需要计算动态宽度的标签,例如 td,
	 * @return
	 */
	@Override
	public String calcWidth(Object metaObj) {
		String tagId = EvalUtil.getParamValue(EvalUtil.getChildLi(metaObj), NanhuprintConstant.CALC_WIDTH_TAG_ID);
		if (StringUtils.isEmpty(tagId)) {
			throw new NanhuprintException("目标标签名称为空,可能配置了参数:calcWidth,未配置参数:calcWidthTagId");
		}
		Object targetMetaObj = NanhuprintThreadLocal.getMetaObjMap().get(tagId);
		if (targetMetaObj == null) {
			throw new NanhuprintException("未找到id为:" + tagId + "的标签");
		}
		if (!(targetMetaObj instanceof Div)) {
			throw new NanhuprintException("id为:" + tagId + "的标签,不是 div 标签");
		}
		// div 是解析成单个单元格的 table,直接取第一个 cell,
		EvalFactory evalFactory = new EvalFactory();
		IEval eval = evalFactory.routeEval(targetMetaObj);
		List<Element> elementList = eval.evalToPdf(targetMetaObj, new HashMap<String, Object>());
		PdfPTable pdfPTable = (PdfPTable)elementList.get(0);
		PdfPCell cell = pdfPTable.getRow(0).getCells()[0];
		Phrase phrase = cell.getPhrase();
		if (phrase == null) {
			throw new NanhuprintException("id为:" + tagId + "的标签,其内容为空,可能没有 span 元素,或者是包含了非 span 的子元素");
		}
		Font font = NanhuprintThreadLocal.getFontMap().get(tagId);
		float textWidth = font.getCalculatedBaseFont(true).getWidthPoint(phrase.getContent(), font.getCalculatedSize());
		textWidth += EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(targetMetaObj, NanhuprintConstant.BORDER_LEFT_WIDTH));
		textWidth += EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(targetMetaObj, NanhuprintConstant.PADDING_LEFT));
		textWidth += EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(targetMetaObj, NanhuprintConstant.PADDING_RIGHT));
		textWidth += EvalUtil.getPrefixFloatValue(EvalUtil.getCssAttribute(targetMetaObj, NanhuprintConstant.BORDER_RIGHT_WIDTH));
		return String.valueOf(textWidth);
	}
}
