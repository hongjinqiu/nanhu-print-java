package com.hongjinqiu.nanhuprint;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

import java.io.IOException;

/**
 * 默认加载4种常用字体
 */
public class NanhuprintFont {
	/*
	public static final Font ARIAL_FONT;
	public static final Font TIMES_FONT;
	public static final Font CALIBRI_FONT;
	public static final Font CENTURY_FONT;

	public static final String ARIAL_FONT_KEY = "arial";
	public static final String TIMES_FONT_KEY = "times";
	public static final String CALIBRI_FONT_KEY = "calibri";
	public static final String CENTURY_FONT_KEY = "century";
	*/

	static {
		/*
		try {
			ARIAL_FONT = new Font(BaseFont.createFont("fonts/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED));
			TIMES_FONT = new Font(BaseFont.createFont("fonts/times.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED));
			CALIBRI_FONT = new Font(BaseFont.createFont("fonts/calibri.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED));
			CENTURY_FONT = new Font(BaseFont.createFont("fonts/CENTURY.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED));
		} catch (DocumentException e) {
			throw new NanhuprintException(e);
		} catch (IOException e) {
			throw new NanhuprintException(e);
		}
		*/
	}

	public static void init(){}
}
