package com.hongjinqiu.nanhuprint.eval;

import com.itextpdf.text.Element;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.model.Macros;
import com.hongjinqiu.nanhuprint.model.Style;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Macros 的解析类
 */
public class MacrosEval extends AbstractEval {
	private String childKey = "ifAndForEachAndSet";

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
		Macros obj = (Macros) metaObj;
		StringBuilder result = new StringBuilder();

		EvalUtil.loopEvalDynamicElement(obj.getIfAndForEachAndSet(), env, expressionEvaluator, result);

		return result.toString();
	}
}
