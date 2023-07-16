package com.hongjinqiu.nanhuprint.event;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 通常用来做背景图
 * @author hongjinqiu
 */
public class NanhuprintCellImageEvent implements PdfPCellEvent {
	private Logger logger = Logger.getLogger(this.getClass());
	private BackgroundImageVO backgroundImageVO;

	public NanhuprintCellImageEvent(BackgroundImageVO backgroundImageVO) {
		this.backgroundImageVO = backgroundImageVO;
	}

	@Override
	public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
		// div position
		float imageWidth = position.getWidth();
		float imageHeight = position.getHeight();

		if (StringUtils.isNotEmpty(backgroundImageVO.getBackgroundSize())) {
			// background-size: contain 或 background-size: 100%，就取整个大小（最大100%）
			if (NanhuprintConstant.SIZE_CONTAIN.equalsIgnoreCase(backgroundImageVO.getBackgroundSize())) {
				imageWidth = position.getWidth();
				imageHeight = position.getHeight();
			} else if (backgroundImageVO.getBackgroundSize().indexOf(NanhuprintConstant.PERCENT) > -1 ){
				// background-size: x%，百分比表示；按比例缩放
				float scaling = EvalUtil.getPrefixFloatValue(backgroundImageVO.getBackgroundSize()) / 100f;
				imageWidth = position.getWidth() * scaling;
				imageHeight = position.getHeight() * scaling;
			}
		}
		// background-size
		backgroundImageVO.getImg().scaleToFit(imageWidth, imageHeight);
		imageWidth = backgroundImageVO.getImg().getScaledWidth();
		imageHeight = backgroundImageVO.getImg().getScaledHeight();
		// background-position-x
		float absoluteX = ImageUtil.processBackgroundPositionX(backgroundImageVO.getBackgroundPositionX(), position, imageWidth);
		// background-position-y
		float absoluteY = ImageUtil.processBackgroundPositionY(backgroundImageVO.getBackgroundPositionY(), position, imageHeight);
		backgroundImageVO.getImg().setAbsolutePosition(absoluteX, absoluteY);
		PdfContentByte canvas = canvases[PdfPTable.BACKGROUNDCANVAS];
		try {
//			canvas.addImage(backgroundImageVO.getImg());
			ImageUtil.setImageOpacity(canvas, backgroundImageVO.getImg(), backgroundImageVO.getBackgroundImageOpacityByPdf());
		} catch (DocumentException e) {
			// do nothing, just log error
			logger.error(e.getMessage(), e);
		}
	}

}
