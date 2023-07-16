package com.hongjinqiu.nanhuprint.event;

import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 水印的公共实现方法
 */
public class WaterMarkUtil {
	private static Logger logger = Logger.getLogger(WaterMarkUtil.class);

	/**
	 * 文字水印
	 * @param waterMarkVO
	 * @param rect
	 * @param canvas
	 */
	public static void applyWaterMark(WaterMarkVO waterMarkVO, Rectangle rect, PdfContentByte canvas) {
//		canvas.setColorFill(pagenumber < 3 ? BaseColor.BLUE : BaseColor.LIGHT_GRAY);
//		canvas.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
//		canvas.fill();

		if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkText())) {
			applyWaterMarkText(waterMarkVO, rect, canvas);
		}
		if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkImage())) {
			applyWaterMarkImage(waterMarkVO, rect, canvas);
		}
	}

	/**
	 * 文字水印
	 * @param waterMarkVO
	 * @param rect
	 * @param canvas
	 */
	private static void applyWaterMarkText(WaterMarkVO waterMarkVO, Rectangle rect, PdfContentByte canvas) {
		if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkTextFontSize())) {
			waterMarkVO.getFont().setSize(Integer.parseInt(waterMarkVO.getWaterMarkTextFontSize()));
		} else {
			waterMarkVO.getFont().setSize(24);
		}

		canvas.saveState();

		try {
			PdfGState state = new PdfGState();
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkOpacity())) {
				state.setFillOpacity(Float.parseFloat(waterMarkVO.getWaterMarkOpacity()));
			} else {
				state.setFillOpacity(0.2f);
			}
			canvas.setGState(state);

			float width = rect.getRight() - rect.getLeft();
			float height = rect.getTop() - rect.getBottom();
			float x = rect.getLeft() + width / 2;
			float y = rect.getBottom() + height / 2;
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkOffsetX())) {
				x += Float.parseFloat(waterMarkVO.getWaterMarkOffsetX());
			}
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkOffsetY())) {
				y += Float.parseFloat(waterMarkVO.getWaterMarkOffsetY());
			}

			String text = "Duplicate";
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkText())) {
				text = waterMarkVO.getWaterMarkText();
			}
			float rotation = 45;
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkRotation())) {
				rotation = Float.parseFloat(waterMarkVO.getWaterMarkRotation());
			}

			ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(text, waterMarkVO.getFont()), x, y, rotation);
		} finally {
			canvas.restoreState();
		}
	}

	/**
	 * 图片水印
	 * @param waterMarkVO
	 * @param rect
	 * @param canvas
	 */
	private static void applyWaterMarkImage(WaterMarkVO waterMarkVO, Rectangle rect, PdfContentByte canvas) {
		canvas.saveState();
		canvas.beginText();

		PdfGState state = new PdfGState();
		if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkOpacity())) {
			state.setFillOpacity(Float.parseFloat(waterMarkVO.getWaterMarkOpacity()));
//			state.setStrokeOpacity(Float.parseFloat(waterMarkVO.getWaterMarkOpacity()));
		} else {
			state.setFillOpacity(0.2f);
//			state.setStrokeOpacity(0.2f);
		}
		canvas.setGState(state);

		try {
			float width = rect.getRight() - rect.getLeft();
			float height = rect.getTop() - rect.getBottom();
			float x = rect.getLeft();
			float y = rect.getBottom();
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkOffsetX())) {
				x += Float.parseFloat(waterMarkVO.getWaterMarkOffsetX());
			}
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkOffsetY())) {
				y += Float.parseFloat(waterMarkVO.getWaterMarkOffsetY());
			}

			float rotation = 0;
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkRotation())) {
				rotation = Float.parseFloat(waterMarkVO.getWaterMarkRotation());
			}

			float waterMarkImageWidth = width;
			float waterMarkImageHeight = height;
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkImageWidth())) {
				waterMarkImageWidth = Float.parseFloat(waterMarkVO.getWaterMarkImageWidth());
			}
			if (StringUtils.isNotEmpty(waterMarkVO.getWaterMarkImageHeight())) {
				waterMarkImageHeight = Float.parseFloat(waterMarkVO.getWaterMarkImageHeight());
			}

			Double targetLeft = x + ((width - waterMarkImageWidth) / 2.0);
			Double targetlBottom = y + ((height - waterMarkImageHeight) / 2.0);
			Image image = Image.getInstance(waterMarkVO.getWaterMarkImage());
			image.setAbsolutePosition(targetLeft.floatValue(), targetlBottom.floatValue());
			image.setRotationDegrees(rotation);

			image.scaleAbsolute(waterMarkImageWidth, waterMarkImageHeight);
//			image.setAlignment(Image.UNDERLYING);

			// 添加水印图片
			canvas.addImage(image);
			canvas.setGState(state);
			// 结束设置
			canvas.endText();
			canvas.stroke();

//		ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(text, waterMarkVO.getFont()), x, y, rotation);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e.getMessage(), e);
		} finally {
			canvas.restoreState();
		}
	}
}
