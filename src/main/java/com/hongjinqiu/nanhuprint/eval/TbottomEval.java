package com.hongjinqiu.nanhuprint.eval;

import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.model.Tbody;
import com.hongjinqiu.nanhuprint.model.Tbottom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Tbottom 的解析类
 */
public class TbottomEval extends AbstractEval {
	private String childKey = "ifAndForEachAndSet";

	@Override
	public String getChildKey() {
		return childKey;
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
		Tbottom tbottom = (Tbottom)metaObj;
		return EvalUtil.commonEvalDynamicElement("tbottom", metaObj, tbottom.getIfAndForEachAndSet(), env, expressionEvaluator);
	}

	/**
	 * id 与 parentId 映射关系赋值
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
		Tbottom tbottom = (Tbottom)metaObj;
		float total = 0;
		for (float width: absoluteWidths) {
			total += width;
		}
		NanhuprintThreadLocal.getContentWidthMap().put(tbottom.getId(), total);
		EvalUtil.loopSetContentWidth(metaObj, absoluteWidths, rowColumnFlag, tbottom.getIfAndForEachAndSet());// 把 table 的 absoluteWidths, rowColumnFlag 往下传
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

		// tbottom 没有 css 元素属性,放 parentFont 直接往下分发即可,
//		EvalUtil.commonSetFontToMap(metaObj, thisFont);
		Tbottom element = (Tbottom)metaObj;
		NanhuprintThreadLocal.getFontMap().put(id, thisFont);
		EvalUtil.loopSetFontToMap(element.getIfAndForEachAndSet());
	}

	/**
	 * 将 xml 元素解析并输出 pdf
	 * Tbottom 标签并不输出 pdf 元素,其只是往下分发元素而已
	 * @param metaObj
	 * @param env
	 * @return
	 */
	@Override
	public List<Element> evalToPdf(Object metaObj, Map<String, Object> env) {
		Tbottom element = (Tbottom)metaObj;
		List<Element> result = new ArrayList<>();
		if (element.getIfAndForEachAndSet() != null && element.getIfAndForEachAndSet().size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj: element.getIfAndForEachAndSet()) {
				IEval evalImplment = evalFactory.routeEval(obj);
				List<Element> elements = evalImplment.evalToPdf(obj, env);
				result.addAll(elements);
			}
		}
		return result;
	}
}
