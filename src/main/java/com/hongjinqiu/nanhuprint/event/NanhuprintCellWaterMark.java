package com.hongjinqiu.nanhuprint.event;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import com.lowagie.text.pdf.PdfPTable;

/**
 * cell的文字水印
 */
public class NanhuprintCellWaterMark implements PdfPCellEvent {
	private WaterMarkVO waterMarkVO;

	public NanhuprintCellWaterMark(WaterMarkVO waterMarkVO) {
		this.waterMarkVO = waterMarkVO;
	}

	@Override
	public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
		PdfContentByte canvas;
		if (NanhuprintConstant.NANHUPRINT_WATER_MARK_LAYER_UNDER.equalsIgnoreCase(waterMarkVO.getWaterMarkLayer())) {
			canvas = canvases[PdfPTable.BACKGROUNDCANVAS];
		} else {
//			canvas = canvases[PdfPTable.BASECANVAS];
			// 用 TEXTCANVAS 才能覆盖在文字上方
			canvas = canvases[PdfPTable.TEXTCANVAS];
		}

		Rectangle rect = position;
		WaterMarkUtil.applyWaterMark(waterMarkVO, rect, canvas);
	}
}
