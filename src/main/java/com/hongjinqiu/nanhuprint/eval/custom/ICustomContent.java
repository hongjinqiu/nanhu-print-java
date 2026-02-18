package com.hongjinqiu.nanhuprint.eval.custom;

import com.lowagie.text.Element;

import java.util.Map;

/**
 * 自定义内容接口
 */
public interface ICustomContent {
	void customContent(Object metaObj, Element element, Map<String, Object> env);
}
