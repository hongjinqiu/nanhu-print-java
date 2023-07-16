package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.model.ForEach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.ForEach 的解析类
 */
public class ForEachEval extends AbstractEval {

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
		ForEach obj = (ForEach)metaObj;
		StringBuilder result = new StringBuilder();

		// 保存不缓存变量名
		NanhuprintThreadLocal.getNoCacheParamNames().add(obj.getVar());
		NanhuprintThreadLocal.getNoCacheParamNames().add(obj.getVarStatus());

		// 生成一个独立的 nestEnv, 用 nanhuprint_outer 来指向 env
		Map<String, Object> nestEnv = new HashMap<>();
		nestEnv.putAll(env);
		nestEnv.put(NanhuprintConstant.NANHUPRINT_OUTER, env);
		List<Object> items = (List<Object>)expressionEvaluator.eval(obj.getItemsJs(), nestEnv);
		for (int i = 0; i < items.size(); i++) {
			EvalUtil.loopSetEnvValue(nestEnv, obj.getVar(), items.get(i));
			EvalUtil.loopSetEnvValue(nestEnv, obj.getVarStatus(), i);
			EvalUtil.loopEvalDynamicElement(obj.getWidthAndHeightAndPaddingLeft(), nestEnv, expressionEvaluator, result);
		}

		return result.toString();
	}

}
