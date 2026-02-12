package com.hongjinqiu.nanhuprint.event;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import org.apache.log4j.Logger;

/**
 * body 背景图
 * @author hongjinqiu
 */
public class NanhuprintBodyImageEvent extends PdfPageEventHelper {
	private Logger logger = Logger.getLogger(this.getClass());
	private BackgroundImageVO backgroundImageVO;

	public NanhuprintBodyImageEvent(BackgroundImageVO backgroundImageVO) {
		this.backgroundImageVO = backgroundImageVO;
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		try {
			PdfContentByte canvas = writer.getDirectContentUnder();
			Rectangle rect = document.getPageSize();
			float imageWidth = rect.getWidth();
			float imageHeight = rect.getHeight();
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
			float absoluteX = ImageUtil.processBackgroundPositionX(backgroundImageVO.getBackgroundPositionX(), rect, imageWidth);
			// background-position-y
			float absoluteY = ImageUtil.processBackgroundPositionY(backgroundImageVO.getBackgroundPositionY(), rect, imageHeight);
			backgroundImageVO.getImg().setAbsolutePosition(absoluteX, absoluteY);

			ImageUtil.setImageOpacity(canvas, backgroundImageVO.getImg(), backgroundImageVO.getBackgroundImageOpacityByPdf());
		} catch (DocumentException e) {
			// just record exception do nothing
			logger.error(e.getMessage(), e);
		}
	}
}
