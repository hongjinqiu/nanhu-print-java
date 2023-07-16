package com.hongjinqiu.nanhuprint.event;

import com.itextpdf.text.Image;

/**
 * 背景图参数类
 * @author hongjinqiu
 */
public class BackgroundImageVO {
	private Image img;
	private String backgroundSize;
	private String backgroundPositionX;
	private String backgroundPositionY;
	private String backgroundImageOpacityByPdf;

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public String getBackgroundSize() {
		return backgroundSize;
	}

	public void setBackgroundSize(String backgroundSize) {
		this.backgroundSize = backgroundSize;
	}

	public String getBackgroundPositionX() {
		return backgroundPositionX;
	}

	public void setBackgroundPositionX(String backgroundPositionX) {
		this.backgroundPositionX = backgroundPositionX;
	}

	public String getBackgroundPositionY() {
		return backgroundPositionY;
	}

	public void setBackgroundPositionY(String backgroundPositionY) {
		this.backgroundPositionY = backgroundPositionY;
	}

	public String getBackgroundImageOpacityByPdf() {
		return backgroundImageOpacityByPdf;
	}

	public void setBackgroundImageOpacityByPdf(String backgroundImageOpacityByPdf) {
		this.backgroundImageOpacityByPdf = backgroundImageOpacityByPdf;
	}
}
