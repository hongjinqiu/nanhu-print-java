package com.hongjinqiu.nanhuprint.eval;

import java.awt.Color;
import com.lowagie.text.Chunk;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.explain.ExplainUtil;
import com.hongjinqiu.nanhuprint.eval.format.IFormat;
import com.hongjinqiu.nanhuprint.model.Span;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Span 的解析类
 */
public class SpanEval extends AbstractEval {
	private String childKey = "cssAndParams";

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
		Span span = (Span)metaObj;
		return EvalUtil.commonEvalDynamicElement("span", metaObj, span.getCssAndParams(), env, expressionEvaluator);
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
	 * Span 标签输出成 Chunk 元素,多个连续的 Span 元素,将会被父元素合并到同一个 Paragraph 中,避免 addElement 换行
	 * Span 元素的 paddingLeft, paddingRight 实现为前后补空格,
	 * 注:paddingRight是往右补空格了,但是在单个元素时 iText 渲染不出来,相当于单个元素时 paddingRight 没用
	 * marginTop,marginBottom,marginLeft,marginRight,paddingTop,paddingBottom 没用
	 *
	 * @param metaObj
	 * @param env
	 * @return
	 */
	@Override
	public List<Element> evalToPdf(Object metaObj, Map<String, Object> env) {
		Span span = (Span)metaObj;
		ExplainUtil.addExplain(metaObj, "===================== span(id:" + span.getId() + ") explain begin =====================");
		if (isDisplayNoneOrVisibilityHidden(metaObj, childKey)) {
			ExplainUtil.addExplain(metaObj, "===================== span(id:" + span.getId() + ") explain end =====================");
			ExplainUtil.outputExplain(span.getId());
			return new ArrayList<>();
		}

		List<Element> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append(getFormatText(span, env));
		Font font = NanhuprintThreadLocal.getFontMap().get(span.getId());

		// paddingLeft
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.PADDING_LEFT);
			if (StringUtils.isNotEmpty(attributeValue)) {
				ExplainUtil.addExplain(metaObj, "paddingLeft 有值,左补 " + attributeValue + " 个空格");
				for (int i = 0; i < EvalUtil.getPrefixFloatValue(attributeValue); i++) {
					sb.insert(0, NanhuprintConstant.SPACE);
				}
			}
		}
		// paddingRight
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.PADDING_RIGHT);
			if (StringUtils.isNotEmpty(attributeValue)) {
				ExplainUtil.addExplain(metaObj, "paddingRight 有值,右补 " + attributeValue + " 个空格");
				for (int i = 0; i < EvalUtil.getPrefixFloatValue(attributeValue); i++) {
					sb.append(NanhuprintConstant.SPACE);
				}
			}
		}

		Chunk chunk = new Chunk(sb.toString(), font);
		ExplainUtil.addExplain(metaObj, "使用字体 familyName:" + font.getFamilyname() + ", style:" + font.getStyle() + ", size:" + font.getSize() + ", color:" + font.getColor());

		// backgroundColor
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_COLOR);
			if (StringUtils.isNotEmpty(attributeValue)) {
				Color bgColor = EvalUtil.getBaseColor(attributeValue);
				if (bgColor != null) {
					chunk.setBackground(bgColor);
				}
			}
		}
		EvalUtil.commonCustomContent(metaObj, chunk, env);
		result.add(chunk);
		ExplainUtil.addExplain(metaObj, "===================== span(id:" + span.getId() + ") explain end =====================");
		ExplainUtil.outputExplain(span.getId());
		return result;
	}

	/**
	 * 取得格式化过的值
	 * @param span
	 * @param env
	 * @return
	 */
	private String getFormatText(Span span, Map<String, Object> env) {
		if (StringUtils.isNotEmpty(span.getFormat())) {
			if (env.get(NanhuprintConstant.FORMAT_FUNC) == null) {
				throw new NanhuprintException("<span 标签配置了 format='num',但是传入的 env 中没有对应的格式函数, env.formatFunc.num, 无法进行格式化显示");
			}
			Map<String, Object> formatFunc = (Map<String, Object>)env.get(NanhuprintConstant.FORMAT_FUNC);
			if (span.getFormat().equalsIgnoreCase(NanhuprintConstant.FORMAT_FUNC_VALUE_NUM)) {
				if (formatFunc.get(NanhuprintConstant.FORMAT_FUNC_VALUE_NUM) == null) {
					throw new NanhuprintException("<span 标签配置了 format='num',但是传入的 env 中没有对应的格式函数, env.formatFunc.num, 无法进行格式化显示");
				}
				IFormat format = (IFormat)formatFunc.get(NanhuprintConstant.FORMAT_FUNC_VALUE_NUM);
				return format.format(span.getValue());
			} else if (span.getFormat().equalsIgnoreCase(NanhuprintConstant.FORMAT_FUNC_VALUE_UNIT_PRICE)) {
				if (formatFunc.get(NanhuprintConstant.FORMAT_FUNC_VALUE_UNIT_PRICE) == null) {
					throw new NanhuprintException("<span 标签配置了 format='unitPrice',但是传入的 env 中没有对应的格式函数, env.formatFunc.unitPrice, 无法进行格式化显示");
				}
				IFormat format = (IFormat)formatFunc.get(NanhuprintConstant.FORMAT_FUNC_VALUE_UNIT_PRICE);
				return format.format(span.getValue());
			} else if (span.getFormat().equalsIgnoreCase(NanhuprintConstant.FORMAT_FUNC_VALUE_AMT)) {
				if (formatFunc.get(NanhuprintConstant.FORMAT_FUNC_VALUE_AMT) == null) {
					throw new NanhuprintException("<span 标签配置了 format='amt',但是传入的 env 中没有对应的格式函数, env.formatFunc.amt, 无法进行格式化显示");
				}
				IFormat format = (IFormat)formatFunc.get(NanhuprintConstant.FORMAT_FUNC_VALUE_AMT);
				return format.format(span.getValue());
			}
		}
		return span.getValue();
	}
}
