package com.hongjinqiu.nanhuprint.eval;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.model.Tr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Tr 的解析类
 */
public class TrEval extends AbstractEval {
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
		Tr tr = (Tr) metaObj;
		return EvalUtil.commonEvalDynamicElement("tr", metaObj, tr.getIfAndForEachAndSet(), env, expressionEvaluator);
	}

	/**
	 * id 与 parentId 映射关系赋值
	 *
	 * @param metaObj
	 * @param parentObj
	 */
	@Override
	public void setIdAndParentId(Object metaObj, Object parentObj) {
		String parentId = EvalUtil.getIdValue(parentObj);
		EvalUtil.commonSetIdAndParentId(metaObj, parentId);
	}

	/**
	 * 设置id,宽度映射,只往下分发,
	 * @param metaObj
	 */
	@Override
	public void setContentWidth(Object metaObj, float[] absoluteWidths, int[][] rowColumnFlag) {
		Tr tr = (Tr)metaObj;
		float total = 0;
		for (float width: absoluteWidths) {
			total += width;
		}
		NanhuprintThreadLocal.getContentWidthMap().put(tr.getId(), total);
		EvalUtil.loopSetContentWidth(metaObj, absoluteWidths, rowColumnFlag, tr.getIfAndForEachAndSet());// 把 table 的 absoluteWidths, rowColumnFlag 往下传
	}

	/**
	 * id 与 metaObj 的映射
	 *
	 * @param metaObj
	 */
	@Override
	public void setIdAndMetaObj(Object metaObj) {
		EvalUtil.commonSetIdAndMetaObj(metaObj);
	}

	/**
	 * 将字体设到 threadLocal 的 map 里面,
	 * fontStyle:
	 * html:normal|italic
	 * fontWeight:
	 * html:normal|bold
	 * pdf中的值为:NORMAL|BOLD|ITALIC|BOLDITALIC
	 * fontSize
	 * fontFamily
	 */
	@Override
	public void setFontToMap(Object metaObj) {
		String id = EvalUtil.getValueByReflect(metaObj, "id");
		String parentId = NanhuprintThreadLocal.getKeyIdValueParentIdMap().get(id);
		Font parentFont = NanhuprintThreadLocal.getFontMap().get(parentId);
		Font thisFont = parentFont;

		EvalUtil.commonSetFontToMap(metaObj, thisFont);
	}

	/**
	 * 将 xml 元素解析并输出 pdf
	 * Tr 标签并不输出 pdf 元素,其只是往下分发元素而已
	 *
	 * @param metaObj
	 * @param env
	 * @return
	 */
	@Override
	public List<Element> evalToPdf(Object metaObj, Map<String, Object> env) {
		if (isDisplayNoneOrVisibilityHidden(metaObj, childKey)) {
			return new ArrayList<>();
		}

		Tr element = (Tr) metaObj;
		List<Element> result = new ArrayList<>();
		if (element.getIfAndForEachAndSet() != null && element.getIfAndForEachAndSet().size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj : element.getIfAndForEachAndSet()) {
				IEval evalImplment = evalFactory.routeEval(obj);
				List<Element> elements = evalImplment.evalToPdf(obj, env);
				result.addAll(elements);
			}
		}
		return result;
	}
}
