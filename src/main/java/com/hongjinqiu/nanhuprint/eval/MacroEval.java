package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.model.Macro;
import com.hongjinqiu.nanhuprint.model.Style;

import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Macro 的解析类
 */
public class MacroEval extends AbstractEval {
	private String childKey = "widthAndHeightAndMarginLeft";

	@Override
	public String getChildKey() {
		return childKey;
	}

	/**
	 * 解析所有的 if,forEach,set,spring el 等动态标签,生成 xml,
	 *
	 * @param metaObj
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	@Override
	public String evalDynamicElement(Object metaObj, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator) {
		Macro obj = (Macro) metaObj;
		StringBuilder result = new StringBuilder();

		NanhuprintThreadLocal.getMacroMap().put(obj.getName(), obj);

		return result.toString();
	}
}
