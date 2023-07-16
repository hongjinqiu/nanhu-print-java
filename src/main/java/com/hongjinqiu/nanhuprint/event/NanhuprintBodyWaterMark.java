package com.hongjinqiu.nanhuprint.event;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 文字水印
 * @author hongjinqiu
 */
public class NanhuprintBodyWaterMark extends PdfPageEventHelper {
	private WaterMarkVO waterMarkVO;

	public NanhuprintBodyWaterMark(WaterMarkVO waterMarkVO) {
		this.waterMarkVO = waterMarkVO;
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		/*
		int pagenumber = writer.getPageNumber();
		if (pagenumber % 2 == 1 && pagenumber != 1)
			return;
		*/
		PdfContentByte canvas;
		if (NanhuprintConstant.NANHUPRINT_WATER_MARK_LAYER_UNDER.equalsIgnoreCase(waterMarkVO.getWaterMarkLayer())) {
			canvas = writer.getDirectContentUnder();
		} else {
			canvas = writer.getDirectContent();
		}

		Rectangle rect = document.getPageSize();
		WaterMarkUtil.applyWaterMark(waterMarkVO, rect, canvas);
	}
}
