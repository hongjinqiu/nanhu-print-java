package com.hongjinqiu.nanhuprint.event;

import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import com.lowagie.text.pdf.PdfPTable;

/**
 * 表格的虚线边框
 * @author hongjinqiu 2018.08.09
 */
public class NanhuprintCellLineDash implements PdfPCellEvent {

	@Override
	public void cellLayout(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentBytes) {
		PdfContentByte cb = pdfContentBytes[PdfPTable.LINECANVAS];
		cb.setLineDash(new float[]{3.0f, 3.0f}, 0);
		cb.stroke();
	}

	/*
	// 这种方式估计可以实现 div 的单个 td 的下划线,不过先不管
	public void cellLayout(PdfPCell pdfPCell, Rectangle position, PdfContentByte[] canvases) {
		PdfContentByte canvas = canvases[PdfPTable.LINECANVAS];
		canvas.setLineDash(3f, 3f);
		canvas.rectangle(position.getLeft(), position.getBottom(),
			position.getWidth(), position.getHeight());
	}
	 */
}
