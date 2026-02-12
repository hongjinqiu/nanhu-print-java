package com.hongjinqiu.nanhuprint.event;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.lowagie.text.Document;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

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
