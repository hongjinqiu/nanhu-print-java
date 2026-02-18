package com.hongjinqiu.nanhuprint.event;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 背景图的公用方法
 */
public class ImageUtil {
	/**
	 * background-position-x:center/left/right/percent
	 */
	public static float processBackgroundPositionX(String backgroundPositionX, Rectangle position, float imageWidth) {
		// background-position-x
		float offset = (position.getRight() - position.getLeft() - imageWidth) / 2;
		float absoluteX = position.getLeft();// 默认左对齐
		if (StringUtils.isNotEmpty(backgroundPositionX)) {
			// background-position-x: center; （居中）
			if (NanhuprintConstant.IMAGE_ALIGN_VALUE_CENTER.equalsIgnoreCase(backgroundPositionX)) {
				absoluteX = position.getLeft() + offset;
			} else if (NanhuprintConstant.IMAGE_ALIGN_VALUE_LEFT.equalsIgnoreCase(backgroundPositionX)) {
				// background-position-x: left;（左对齐）
				absoluteX = position.getLeft();
			} else if (NanhuprintConstant.IMAGE_ALIGN_VALUE_RIGHT.equalsIgnoreCase(backgroundPositionX)) {
				// background-position-x: right;（右对齐）
				absoluteX = position.getLeft() + offset * 2;
			} else if (backgroundPositionX.indexOf(NanhuprintConstant.PERCENT) > -1) {
				// background-position-x: x%;
				float scaling = EvalUtil.getPrefixFloatValue(backgroundPositionX) / 100f;
				absoluteX = position.getLeft() + position.getWidth() * scaling;
			}
		}
		return absoluteX;
	}

	/**
	 * background-position-y:center/top/bottom/percent
	 *
	 * @param position
	 * @param imageHeight
	 * @return
	 */
	public static float processBackgroundPositionY(String backgroundPositionY, Rectangle position, float imageHeight) {
		float offset = (position.getTop() - position.getBottom() - imageHeight) / 2;
		float absoluteY = position.getBottom() + offset * 2;// 默认顶对齐
		if (StringUtils.isNotEmpty(backgroundPositionY)) {
			// background-position-y: center; （居中）
			if (NanhuprintConstant.IMAGE_ALIGN_VALUE_CENTER.equalsIgnoreCase(backgroundPositionY)) {
				absoluteY = position.getBottom() + offset;
			} else if (NanhuprintConstant.IMAGE_ALIGN_VALUE_TOP.equalsIgnoreCase(backgroundPositionY)) {
				// background-position-y: top;（顶部对齐）
				absoluteY = position.getBottom() + offset * 2;// 默认顶对齐
			} else if (NanhuprintConstant.IMAGE_ALIGN_VALUE_BOTTOM.equalsIgnoreCase(backgroundPositionY)) {
				// background-position-y: bottom;（底部对齐）
				absoluteY = position.getBottom();
			} else if (backgroundPositionY.indexOf(NanhuprintConstant.PERCENT) > -1) {
				// background-position-y: x%;
				float scaling = EvalUtil.getPrefixFloatValue(backgroundPositionY) / 100f;
				absoluteY = position.getBottom() + (position.getHeight() * scaling);
			}
		}
		return absoluteY;
	}

	/**
	 * 设置图像透明度
	 */
	public static void setImageOpacity(PdfContentByte canvas, Image img, String opacity) throws DocumentException {
		if (StringUtils.isNotEmpty(opacity)) {
			canvas.saveState();
			PdfGState state = new PdfGState();
			state.setFillOpacity(EvalUtil.getPrefixFloatValue(opacity));
			canvas.setGState(state);
			canvas.addImage(img);
			canvas.restoreState();
		} else {
			canvas.addImage(img);
		}
	}
}
