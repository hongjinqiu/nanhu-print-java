package com.hongjinqiu.nanhuprint.eval.custom;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来计算大表格分页时,存 thead 高度, tbody 下面每一个 tr 的高度, tloop 的高度, tbottom 的高度,
 */
public class ExtendToFillBodyStruct {
	private float theadHeightFirstPageSum = 0;// thead 中 attribute='firstPage' 高度之和
	private float theadHeightEveryPageSum = 0;// thead 中 attribute='everyPage' 高度之和
	private List<LineChild> tbodyLineChilds = new ArrayList<>();// 存放 Tbody 底下的 th, td 生成的 element,每一行,一个 LineChild
	private float tbodyHeightSum = 0; // 为 tbodyLineChilds 中的高度之和,
	private float tloopHeight = 0; // 为 tloop 的一行高度
	private float tbottomHeightEveryPageSum = 0;// 为 tbottom 中 attribute='everyPage' 的高度之和
	private float tbottomHeightLastPageSum = 0;// 为 tbottom 中 attribute='lastPage' 的高度之和

	public List<LineChild> getTbodyLineChilds() {
		return tbodyLineChilds;
	}

	public void setTbodyLineChilds(List<LineChild> tbodyLineChilds) {
		this.tbodyLineChilds = tbodyLineChilds;
	}

	public float getTloopHeight() {
		return tloopHeight;
	}

	public void setTloopHeight(float tloopHeight) {
		this.tloopHeight = tloopHeight;
	}

	public float getTheadHeightFirstPageSum() {
		return theadHeightFirstPageSum;
	}

	public void setTheadHeightFirstPageSum(float theadHeightFirstPageSum) {
		this.theadHeightFirstPageSum = theadHeightFirstPageSum;
	}

	public float getTheadHeightEveryPageSum() {
		return theadHeightEveryPageSum;
	}

	public void setTheadHeightEveryPageSum(float theadHeightEveryPageSum) {
		this.theadHeightEveryPageSum = theadHeightEveryPageSum;
	}

	public float getTbodyHeightSum() {
		return tbodyHeightSum;
	}

	public void setTbodyHeightSum(float tbodyHeightSum) {
		this.tbodyHeightSum = tbodyHeightSum;
	}

	public float getTbottomHeightEveryPageSum() {
		return tbottomHeightEveryPageSum;
	}

	public void setTbottomHeightEveryPageSum(float tbottomHeightEveryPageSum) {
		this.tbottomHeightEveryPageSum = tbottomHeightEveryPageSum;
	}

	public float getTbottomHeightLastPageSum() {
		return tbottomHeightLastPageSum;
	}

	public void setTbottomHeightLastPageSum(float tbottomHeightLastPageSum) {
		this.tbottomHeightLastPageSum = tbottomHeightLastPageSum;
	}
}
