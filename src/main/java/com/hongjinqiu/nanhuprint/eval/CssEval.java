package com.hongjinqiu.nanhuprint.eval;

import com.lowagie.text.Element;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.model.Css;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Css 的解析类
 */
public class CssEval extends AbstractEval {

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
		Css css = (Css)metaObj;
		StringBuilder result = new StringBuilder();
		String attribute = EvalUtil.getAttributeString(metaObj, env, expressionEvaluator);
		result.append("<css {attribute}>".replace("{attribute}", attribute));
		EvalUtil.loopEvalDynamicElement(css.getIfAndForEachAndSet(), env, expressionEvaluator, result);
		result.append("</css>");
		return result.toString();
	}

	/**
	 * 只是往公共的 cssMap 里面赋值,
	 * @param metaObj
	 * @param env
	 * @return
	 */
	@Override
	public List<Element> evalToPdf(Object metaObj, Map<String, Object> env) {
		Css css = (Css)metaObj;
		NanhuprintThreadLocal.getCssMap().put(css.getName(), css);
		return new ArrayList<>();
	}
}
