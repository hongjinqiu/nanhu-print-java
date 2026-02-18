package com.hongjinqiu.nanhuprint.eval;

import com.lowagie.text.Element;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.model.Style;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Style 的解析类
 */
public class StyleEval extends AbstractEval {
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
		Style obj = (Style) metaObj;
		StringBuilder result = new StringBuilder();
		result.append("<style>");

		EvalUtil.loopEvalDynamicElement(obj.getIfAndForEachAndSet(), env, expressionEvaluator, result);

		result.append("</style>");
		return result.toString();
	}

	/**
	 * pdf 的输出,采用属性赋值的方式,不会输出 css,
	 * 因此, css 的渲染,写入一个全局的 threadLocal 变量中,方便后续的各个元素取值输出,
	 * @param metaObj
	 * @param env
	 * @return
	 */
	@Override
	public List<Element> evalToPdf(Object metaObj, Map<String, Object> env) {
		Style style = (Style)metaObj;
//		EvalUtil.loopEvalToPdf(style.getIfAndForEachAndSet(), env, style);
		if (style.getIfAndForEachAndSet() != null && style.getIfAndForEachAndSet().size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj: style.getIfAndForEachAndSet()) {
				IEval evalImplment = evalFactory.routeEval(obj);
				evalImplment.evalToPdf(obj, env);
//				Element element = evalImplment.evalToPdf(obj, env);
			}
		}
		return new ArrayList<>();
	}
}
