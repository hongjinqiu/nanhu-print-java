package com.hongjinqiu.nanhuprint.eval.custom;

import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 大表格分页时,每页的页号显示不一样,例如:
 * 第一页:1 of 2
 * 第二页:2 of 2
 */
public class CustomPageNumber implements ICustomContent {
	private String currentPageNumberFormat = "{currentPageNumber}";
	private String totalPageNumberFormat = "{totalPageNumber}";

	@Override
	public void customContent(Object metaObj, Element element, Map<String, Object> env) {
		if (element instanceof PdfPCell) {
			Integer currentPageNumber = (Integer)EvalUtil.getValueFromNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_CURRENT_PAGE_NUMBER);
			Integer totalPageNumber = (Integer)EvalUtil.getValueFromNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_TOTAL_PAGE_NUMBER);
			String currentPageText = "";
			String totalPageText = "";
			if (currentPageNumber != null) {
				currentPageText = String.valueOf(currentPageNumber);
			}
			if (totalPageNumber != null) {
				totalPageText = String.valueOf(totalPageNumber);
			}
			if (((PdfPCell) element).getCompositeElements() != null) {// 使用 setPhrase,没有 addElement 时,getCompositeElements() 返回空
				((PdfPCell) element).getCompositeElements().clear();
			}
			String customContentText = EvalUtil.getParamValue(EvalUtil.getChildLi(metaObj), NanhuprintConstant.NANHUPRINT_CUSTOM_CONTENT_FORMAT);
			if (StringUtils.isEmpty(customContentText)) {
				customContentText = currentPageText + " of " + totalPageText;
			} else {
				customContentText = customContentText.replace(currentPageNumberFormat, currentPageText);
				customContentText = customContentText.replace(totalPageNumberFormat, totalPageText);
			}
			Font font = NanhuprintThreadLocal.getFontMap().get(EvalUtil.getValueByReflect(metaObj, NanhuprintConstant.ID));
			Paragraph paragraph = new Paragraph(customContentText, font);
			((PdfPCell) element).setPhrase(paragraph);
//				EvalUtil.setParagraphAlignment(metaObj, paragraph);
//				((PdfPCell) element).addElement(paragraph);
		}
	}
}
