package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.model.If;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.If 的解析类
 */
public class IfEval extends AbstractEval {

	@Override
	public String getChildKey() {
		return null;
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
		StringBuilder result = new StringBuilder();
		If obj = (If) metaObj;

		boolean evalResult;
		Object evalObj = expressionEvaluator.eval(obj.getTestJs(), env);
		if (evalObj == null) {
			evalResult = false;
		} else if (evalObj instanceof Boolean) {
			evalResult = (Boolean) evalObj;
		} else if (evalObj instanceof String) {
			evalResult = StringUtils.isNotEmpty((String) evalObj);
		} else if (evalObj instanceof Number) {
			evalResult = ((Number) evalObj).intValue() != 0;
		} else {
			throw new NanhuprintException("expression of if not return [boolean/string/number] result: expression is:" + obj.getTestJs() + ", env is:" + EvalUtil.getJsonString(env));
		}
		if (evalResult) {
			EvalUtil.loopEvalDynamicElement(obj.getWidthAndHeightAndPaddingLeft(), env, expressionEvaluator, result);
		}

		return result.toString();
	}
}
