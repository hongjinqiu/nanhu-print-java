package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.model.Macro;
import com.hongjinqiu.nanhuprint.model.MacroRef;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.MacroRef 的解析类
 */
public class MacroRefEval extends AbstractEval {
	private String childKey = "widthAndHeightAndMarginLeft";

	@Override
	public String getChildKey() {
		return childKey;
	}

	/**
	 * 解析所有的 if,forEach,set,spring el 等动态标签,生成 xml,
	 * 根据 name 从 nanhuprintEval_macro 中查找对应的 macro,
	 * 根据 MacroRef.paramJs, 从 env 中找出对象,传递给 Macro.paramJs
	 *
	 * @param metaObj
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	@Override
	public String evalDynamicElement(Object metaObj, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator) {
		MacroRef obj = (MacroRef) metaObj;
		StringBuilder result = new StringBuilder();

		// 保存不缓存变量名
		if (StringUtils.isNotEmpty(obj.getParamJs())) {
			NanhuprintThreadLocal.getNoCacheParamNames().add(obj.getParamJs());
		}

		Macro macroObj = NanhuprintThreadLocal.getMacroMap().get(obj.getName());
		if (macroObj != null) {
			Map<String, Object> nestEnv;
			if (StringUtils.isNotEmpty(macroObj.getParamJs())) {
				if (StringUtils.isEmpty(obj.getParamJs())) {
					throw new NanhuprintException("<macroRef name=\"" + obj.getName() + "\" 缺少 paramJs 属性值");
				}
				// 生成一个独立的 nestEnv, 用 nanhuprint_outer 来指向 env
				Object inputParam = expressionEvaluator.eval(obj.getParamJs(), env);// 从 env 中找出 MacroRef.paramJs
				nestEnv = EvalUtil.getNestEnv(env);
				nestEnv.put(macroObj.getParamJs(), inputParam);
				nestEnv.put(NanhuprintConstant.NANHUPRINT_OUTER, env);
			} else {
				nestEnv = env;
			}

			EvalUtil.loopEvalDynamicElement(macroObj.getWidthAndHeightAndPaddingLeft(), nestEnv, expressionEvaluator, result);
		}

		return result.toString();
	}
}
