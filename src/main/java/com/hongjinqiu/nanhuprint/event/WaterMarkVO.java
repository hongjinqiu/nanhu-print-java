package com.hongjinqiu.nanhuprint.event;

import com.lowagie.text.Font;

/**
 * 水印参数
 *
 * @author hongjinqiu
 */
public class WaterMarkVO {
	private Font font;
	private String waterMarkText;// 水印文本
	private String waterMarkOpacity;// 水印文本透明度
	private String waterMarkTextFontSize;// 水印文本字体大小
	private String waterMarkOffsetX;// x 轴偏移
	private String waterMarkOffsetY;// y 轴偏移
	private String waterMarkRotation;// 水印旋转

	// 图片水印相关参数
	private String waterMarkImage;// 图片位置
	private String waterMarkImageWidth;// 水印图片宽度
	private String waterMarkImageHeight;// 水印图片高度
	private String waterMarkLayer;// 水印在 pdf 内容上层，还是在下层, default, under

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public String getWaterMarkText() {
		return waterMarkText;
	}

	public void setWaterMarkText(String waterMarkText) {
		this.waterMarkText = waterMarkText;
	}

	public String getWaterMarkOpacity() {
		return waterMarkOpacity;
	}

	public void setWaterMarkOpacity(String waterMarkOpacity) {
		this.waterMarkOpacity = waterMarkOpacity;
	}

	public String getWaterMarkTextFontSize() {
		return waterMarkTextFontSize;
	}

	public void setWaterMarkTextFontSize(String waterMarkTextFontSize) {
		this.waterMarkTextFontSize = waterMarkTextFontSize;
	}

	public String getWaterMarkRotation() {
		return waterMarkRotation;
	}

	public void setWaterMarkRotation(String waterMarkRotation) {
		this.waterMarkRotation = waterMarkRotation;
	}

	public String getWaterMarkImage() {
		return waterMarkImage;
	}

	public void setWaterMarkImage(String waterMarkImage) {
		this.waterMarkImage = waterMarkImage;
	}

	public String getWaterMarkImageWidth() {
		return waterMarkImageWidth;
	}

	public void setWaterMarkImageWidth(String waterMarkImageWidth) {
		this.waterMarkImageWidth = waterMarkImageWidth;
	}

	public String getWaterMarkImageHeight() {
		return waterMarkImageHeight;
	}

	public void setWaterMarkImageHeight(String waterMarkImageHeight) {
		this.waterMarkImageHeight = waterMarkImageHeight;
	}

	public String getWaterMarkOffsetX() {
		return waterMarkOffsetX;
	}

	public void setWaterMarkOffsetX(String waterMarkOffsetX) {
		this.waterMarkOffsetX = waterMarkOffsetX;
	}

	public String getWaterMarkOffsetY() {
		return waterMarkOffsetY;
	}

	public void setWaterMarkOffsetY(String waterMarkOffsetY) {
		this.waterMarkOffsetY = waterMarkOffsetY;
	}

	public String getWaterMarkLayer() {
		return waterMarkLayer;
	}

	public void setWaterMarkLayer(String waterMarkLayer) {
		this.waterMarkLayer = waterMarkLayer;
	}
}
