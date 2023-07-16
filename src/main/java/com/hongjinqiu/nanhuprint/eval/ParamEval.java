package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;

import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Param 的解析类
 */
public class ParamEval extends AbstractEval {

	@Override
	public String getChildKey() {
		return null;
	}

	/**
	 * 解析所有的 if,forEach,set,spring el 等动态标签,生成 xml,
	 * @param metaObj
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	@Override
	public String evalDynamicElement(Object metaObj, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator) {
		return EvalUtil.evalDynamicElementForOneLineElement(metaObj, env, expressionEvaluator);
	}

}
