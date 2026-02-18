package com.hongjinqiu.nanhuprint.eval;

import com.lowagie.text.Element;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public abstract class AbstractEval implements IEval {
	protected Logger logger = Logger.getLogger(this.getClass());

	public abstract String getChildKey();

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
		throw new NanhuprintException("not allow to run here, class name is:" + this.getClass().getName());
	}

	/**
	 * 父类的空实现
	 * 给 html 标签添加 id, parentId,
	 *
	 * @param metaObj
	 * @param parentObj
	 */
	@Override
	public void setIdAndParentId(Object metaObj, Object parentObj) {
		// do nothing
	}

	/**
	 * 父类的空实现
	 * @param metaObj
	 */
	@Override
	public void setContentWidth(Object metaObj, float[] absoluteWidths, int[][] rowColumnFlag) {
		// do nothing
	}

	/**
	 * 父类的空实现
	 * 将 xml 元素解析并输出 pdf,
	 *
	 * @param metaObj
	 * @param env
	 * @return
	 */
	@Override
	public List<Element> evalToPdf(Object metaObj, Map<String, Object> env) {
		throw new NanhuprintException("not allow to run here, class name is:" + this.getClass().getName());
	}

	/*@Override
	public byte[] evalToPdfByte(Object metaObj, Map<String, Object> env) {
		throw new NanhuprintException("not allow to run here, class name is:" + this.getClass().getName());
	}*/

	/**
	 * 往 threadLocal 中放 {id: font},方便 pdf 渲染时引用
	 *
	 * @param metaObj
	 */
	@Override
	public void setFontToMap(Object metaObj) {
		// do nothing
	}

	/**
	 * display:none,visibility: hidden;	// 直接不输出
	 * @param metaObj
	 * @param childKey
	 * @return
	 */
	protected boolean isDisplayNoneOrVisibilityHidden(Object metaObj, String childKey) {
		if (EvalUtil.hasField(metaObj, NanhuprintConstant.DISPLAY)) {
			String display = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.DISPLAY);
			if (StringUtils.isNotEmpty(display) && display.equalsIgnoreCase(NanhuprintConstant.DISPLAY_VALUE_NONE)) {
				return true;
			}
		}
		if (EvalUtil.hasField(metaObj, NanhuprintConstant.VISIBILITY)) {
			String visibility = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.VISIBILITY);
			if (StringUtils.isNotEmpty(visibility) && visibility.equalsIgnoreCase(NanhuprintConstant.VISIBILITY_VALUE_HIDDEN)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 父类的空实现
	 * 给 html 标签添加 id -> metaObj 的关联映射,方便查找
	 * if, forEach, set 等标签不需要,
	 * @param metaObj
	 */
	@Override
	public void setIdAndMetaObj(Object metaObj) {
		// do nothing
	}
}
