package com.hongjinqiu.nanhuprint.eval.custom;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import net.sf.json.JSONObject;

import java.util.Map;

/**
 * 自定义内容的 demo
 * @author hongjinqiu 2023.06.13
 */
public class CustomDemo implements ICustomContent {

	@Override
	public void customContent(Object metaObj, Element element, Map<String, Object> env) {
		if (element instanceof PdfPCell) {
			Font font = NanhuprintThreadLocal.getFontMap().get(EvalUtil.getValueByReflect(metaObj, NanhuprintConstant.ID));
			Paragraph paragraph = new Paragraph("I am customDemo by program:" + JSONObject.fromObject(env), font);
			((PdfPCell) element).setPhrase(paragraph);
		}
	}
}
