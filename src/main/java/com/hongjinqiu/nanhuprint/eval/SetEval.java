package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.model.Set;

import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Set 的解析类
 */
public class SetEval extends AbstractEval {

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
		Set obj = (Set)metaObj;

		// 保存不缓存变量名
		NanhuprintThreadLocal.getNoCacheParamNames().add(obj.getVar());

		Object value = expressionEvaluator.eval(obj.getValueJs(), env);
		EvalUtil.loopSetEnvValue(env, obj.getVar(), value);
		return "";
	}

}
