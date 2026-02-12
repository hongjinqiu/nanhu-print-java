package com.hongjinqiu.nanhuprint.eval.custom;

import com.lowagie.text.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 存放 Tbody 底下的 th, td 生成的 element,每一行,一个 LineChild
 */
public class LineChild {
	private int index;    // 每一行下标
	private float height;// 每一行高度
	private List<Element> elements = new ArrayList<>();// 存放 tr 生成的一串 element

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}
}
