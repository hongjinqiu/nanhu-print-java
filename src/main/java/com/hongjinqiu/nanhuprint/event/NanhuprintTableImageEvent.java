package com.hongjinqiu.nanhuprint.event;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPTableEvent;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import org.apache.log4j.Logger;

/**
 * 通常用来做大表格背景图
 * @author hongjinqiu
 */
public class NanhuprintTableImageEvent implements PdfPTableEvent {
	private Logger logger = Logger.getLogger(this.getClass());
	private BackgroundImageVO backgroundImageVO;

	public NanhuprintTableImageEvent(BackgroundImageVO backgroundImageVO) {
		this.backgroundImageVO = backgroundImageVO;
	}

	/**
	 * widths 表示单元格的边沿位置,比如表格有2行4列,第二行有合并单元格,则 widths 长这样
	 * widths:0 = {float[4]@2800}
				 0 = 50.0
				 1 = 215.0
				 2 = 380.0
				 3 = 545.0
			 1 = {float[3]@2801}
				 0 = 50.0
				 1 = 380.0
				 2 = 545.0
	 heigths:每一行的边沿位置,有2行,则长度为3,
	  heights:0 = 812.0
			 1 = 800.0
			 2 = 788.0
	 */
	@Override
	public void tableLayout(PdfPTable table, float[][] widths,
	                        float[] heights, int headerRows, int rowStart,
	                        PdfContentByte[] canvases) {
		try {
			float imageWidth = widths[0][widths[0].length - 1] - widths[0][0];// 最后一个单元格的右边沿 - 最左一个单元格的左边沿
			float imageHeight = heights[0] - heights[heights.length - 1];// 第一行上边沿 - 最后一行下边沿
			// background-size: contain 或 background-size: 100%，就取整个大小（最大100%）
			if (NanhuprintConstant.SIZE_CONTAIN.equalsIgnoreCase(backgroundImageVO.getBackgroundSize())) {
				// do nothing
			} else if (backgroundImageVO.getBackgroundSize().indexOf(NanhuprintConstant.PERCENT) > -1 ){
				float scaling = EvalUtil.getPrefixFloatValue(backgroundImageVO.getBackgroundSize()) / 100f;
				imageWidth = imageWidth * scaling;
				imageHeight = imageHeight * scaling;
			}
			backgroundImageVO.getImg().scaleToFit(imageWidth, imageHeight);
			imageWidth = backgroundImageVO.getImg().getScaledWidth();
			imageHeight = backgroundImageVO.getImg().getScaledHeight();
			PdfContentByte canvas = canvases[PdfPTable.BACKGROUNDCANVAS];

			// [0,0] 是位于左下角
			// background-position-x
			float llx = widths[0][0];
			float urx = widths[0][widths[0].length - 1];
			float lly = heights[heights.length - 1];
			float ury = heights[0];
			Rectangle rectangle = new Rectangle(llx, lly, urx, ury);
			float absoluteX = ImageUtil.processBackgroundPositionX(backgroundImageVO.getBackgroundPositionX(), rectangle, imageWidth);
			// background-position-y
			float absoluteY = ImageUtil.processBackgroundPositionY(backgroundImageVO.getBackgroundPositionY(), rectangle, imageHeight);
			backgroundImageVO.getImg().setAbsolutePosition(absoluteX, absoluteY);

			ImageUtil.setImageOpacity(canvas, backgroundImageVO.getImg(), backgroundImageVO.getBackgroundImageOpacityByPdf());
		} catch (DocumentException e) {
			// just record exception do nothing
			logger.error(e.getMessage(), e);
		}
	}

}
