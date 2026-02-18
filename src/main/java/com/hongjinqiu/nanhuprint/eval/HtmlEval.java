package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.eval.custom.ICustomFont;
import com.hongjinqiu.nanhuprint.eval.custom.NanhuprintFontCustomUtil;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintFont;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.step.StepEnum;
import com.hongjinqiu.nanhuprint.model.Html;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.hongjinqiu.nanhuprint.model.Html 的解析类
 */
public class HtmlEval extends AbstractEval {
	private String xmlns = "https://github.com/hongjinqiu/nanhu-print-java";

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
		NanhuprintThreadLocal.setStepEnum(StepEnum.EVAL_DYNAMIC_ELEMENT);
		if (env == null) {
			env = new HashMap<>();
		}
		Html html = (Html)metaObj;

		StringBuilder result = new StringBuilder();
		result.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		result.append("<html xmlns=\"{xmlns}\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">".replace("{xmlns}", xmlns));

		// 宏变量清值
		NanhuprintThreadLocal.clearMacroMap();

		// style,body 的解析
		EvalFactory evalFactory = new EvalFactory();
		if (html.getStyle() != null) {
			IEval evalImplment = evalFactory.routeEval(html.getStyle());
			String text = evalImplment.evalDynamicElement(html.getStyle(), env, expressionEvaluator);
			result.append(text);
		}

		if (html.getMacros() != null) {
			IEval evalImplment = evalFactory.routeEval(html.getMacros());
			String text = evalImplment.evalDynamicElement(html.getMacros(), env, expressionEvaluator);
			result.append(text);
		}

		if (html.getBody() != null) {
			IEval evalImplment = evalFactory.routeEval(html.getBody());
			String text = evalImplment.evalDynamicElement(html.getBody(), env, expressionEvaluator);
			result.append(text);
		}

		result.append("</html>");
		return result.toString();
	}

	/**
	 * 设置 id,nanhuprint_parentId
	 * html 元素, 没有 id, parentId 属性,只往下分发,
	 */
	@Override
	public void setIdAndParentId(Object metaObj, Object parentObj) {
		Html html = (Html)metaObj;

		if (html.getBody() != null) {
			EvalFactory evalFactory = new EvalFactory();
			IEval evalImplment = evalFactory.routeEval(html.getBody());
			evalImplment.setIdAndParentId(html.getBody(), html);
		}
	}

	/**
	 * 设置 id, width
	 * 只往下分发, html 没宽度, body 才有内容宽度
	 * @param metaObj
	 */
	@Override
	public void setContentWidth(Object metaObj, float[] absoluteWidths, int[][] rowColumnFlag) {
		Html html = (Html)metaObj;

		if (html.getBody() != null) {
			EvalFactory evalFactory = new EvalFactory();
			IEval evalImplment = evalFactory.routeEval(html.getBody());
			evalImplment.setContentWidth(html.getBody(), null, null);
		}
	}

	/**
	 * 设置 id -> metaObj 映射,
	 * html 元素, 不放置映射, 只是往下分发调用,
	 */
	@Override
	public void setIdAndMetaObj(Object metaObj) {
		Html html = (Html)metaObj;

		if (html.getBody() != null) {
			EvalFactory evalFactory = new EvalFactory();
			IEval evalImplment = evalFactory.routeEval(html.getBody());
			evalImplment.setIdAndMetaObj(html.getBody());
		}
	}

	/**
	 * 将 xml 元素解析并输出 pdf,
	 * @param metaObj
	 * @param env
	 * @return
	 */
	public List<Element> evalToPdf(String filePath, Object metaObj, Map<String, Object> env) {
		if (env == null) {
			env = new HashMap<>();
		}
		NanhuprintFont.init();// 加载字体
		NanhuprintThreadLocal.clearAll();// 清值
		// 添加自定义字体
		if (CollectionUtils.isNotEmpty(NanhuprintFontCustomUtil.CUSTOM_FONT_LIST)) {
			for (ICustomFont customFont: NanhuprintFontCustomUtil.CUSTOM_FONT_LIST) {
				customFont.customFont();
			}
		}
		NanhuprintThreadLocal.setStepEnum(StepEnum.EVAL_TO_PDF);
		try {
			this.setIdAndParentId(metaObj, null);// 给元素赋 id 和 parentId
			this.setIdAndMetaObj(metaObj);// 元素 id -> metaObj 映射

			{
//				outputIdParentId(metaObj);
			}
			{
//				outputIdMetaObj();
			}

			Html html = (Html)metaObj;

			// css 元素的解析,
			EvalFactory evalFactory = new EvalFactory();
			if (html.getStyle() != null) {
				IEval evalImplment = evalFactory.routeEval(html.getStyle());
				evalImplment.evalToPdf(html.getStyle(), env);
			}

			setFontToMap(metaObj);// 字体赋值,需要放到 css 的解析之后,
			{
//				outputFont();
			}

			this.setContentWidth(metaObj, null, null);// 元素 id -> width 的映射
			{
//				outputContentWidth();
			}

			// body 的解析
			if (html.getBody() != null) {
				IEval evalImplment = evalFactory.routeEval(html.getBody());
				return ((BodyEval)evalImplment).evalToPdf(filePath, html.getBody(), env);
			}

			return new ArrayList<>();
		} finally {
			NanhuprintThreadLocal.clearAll();// 清值
		}
	}

	/**
	 * 将 xml 元素解析并输出 pdf,
	 * @param metaObj
	 * @param env
	 * @return
	 */
	public byte[] evalToPdfByte(Object metaObj, Map<String, Object> env) {
		if (env == null) {
			env = new HashMap<>();
		}
		NanhuprintFont.init();// 加载字体
		NanhuprintThreadLocal.clearAll();// 清值
		// 添加自定义字体
		if (CollectionUtils.isNotEmpty(NanhuprintFontCustomUtil.CUSTOM_FONT_LIST)) {
			for (ICustomFont customFont: NanhuprintFontCustomUtil.CUSTOM_FONT_LIST) {
				customFont.customFont();
			}
		}
		NanhuprintThreadLocal.setStepEnum(StepEnum.EVAL_TO_PDF);
		try {
			this.setIdAndParentId(metaObj, null);// 给元素赋 id 和 parentId
			this.setIdAndMetaObj(metaObj);// 元素 id -> metaObj 映射

			Html html = (Html)metaObj;

			// css 元素的解析,
			EvalFactory evalFactory = new EvalFactory();
			if (html.getStyle() != null) {
				IEval evalImplment = evalFactory.routeEval(html.getStyle());
				evalImplment.evalToPdf(html.getStyle(), env);
			}

			setFontToMap(metaObj);// 字体赋值,需要放到 css 的解析之后,
			this.setContentWidth(metaObj, null, null);// 元素 id -> width 的映射

			// body 的解析
			if (html.getBody() != null) {
				ByteArrayOutputStream out = null;
				try {
					out = new ByteArrayOutputStream();
					IEval evalImplment = evalFactory.routeEval(html.getBody());
					((BodyEval)evalImplment).evalToPdf(out, html.getBody(), env);
				} finally {
					IOUtils.closeQuietly(out);
				}

				return out.toByteArray();
			}

			throw new NanhuprintException("no byte array to return");
		} finally {
			NanhuprintThreadLocal.clearAll();// 清值
		}
	}

	// 测试用,可删除
	private void outputIdParentId(Object metaObj) {
		Map<String, String> map = NanhuprintThreadLocal.getKeyIdValueParentIdMap();
//			System.out.println(map);
		System.out.println(JSONObject.fromObject(map));
		System.out.println(JSONObject.fromObject(metaObj));
	}

	// 测试用,可删除
	private void outputIdMetaObj() {
		Map<String, Object> map = NanhuprintThreadLocal.getMetaObjMap();
		for (Map.Entry<String, Object> entry: map.entrySet()) {
			try {
				Field field = entry.getValue().getClass().getDeclaredField("id");
				field.setAccessible(true);
				String idValue = (String)field.get(entry.getValue());
				System.out.println(entry.getKey() + " -> [" + idValue + "]" + entry.getValue().getClass().getName());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				logger.error("not such field, class is:" + entry.getValue().getClass().getName());
				e.printStackTrace();
			}

		}
	}

	// 测试用,可删除
	private void outputFont() {
		Map<String, Font> map = NanhuprintThreadLocal.getFontMap();
		for (Map.Entry<String, Font> entry: map.entrySet()) {
			net.sf.json.JSONObject idObj = new net.sf.json.JSONObject();

			net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
			obj.put("family", entry.getValue().getFamilyname());
			obj.put("style", entry.getValue().getStyle());
			obj.put("size", entry.getValue().getSize());
			obj.put("color", entry.getValue().getColor());

			idObj.put(entry.getKey(), obj);
			System.out.println(idObj.toString() + ",");
		}
	}

	// 测试用,可删除
	private void outputContentWidth() {
		System.out.println("----------------- output width begin");
		Map<String, Float> map = NanhuprintThreadLocal.getContentWidthMap();
		System.out.println(JSONObject.fromObject(map));
		System.out.println("----------------- output width end");
	}

	/**
	 * 将字体存入全局变量中
	 */
	@Override
	public void setFontToMap(Object metaObj) {
//		NanhuprintThreadLocal.getFontMap().put(NanhuprintFont.ARIAL_FONT_KEY, NanhuprintFont.ARIAL_FONT);
//		NanhuprintThreadLocal.getFontMap().put(NanhuprintFont.TIMES_FONT_KEY, NanhuprintFont.TIMES_FONT);
//		NanhuprintThreadLocal.getFontMap().put(NanhuprintFont.CALIBRI_FONT_KEY, NanhuprintFont.CALIBRI_FONT);
//		NanhuprintThreadLocal.getFontMap().put(NanhuprintFont.CENTURY_FONT_KEY, NanhuprintFont.CENTURY_FONT);

		Html html = (Html)metaObj;
		if (html.getBody() != null) {
			EvalFactory evalFactory = new EvalFactory();
			IEval evalImplment = evalFactory.routeEval(html.getBody());
			evalImplment.setFontToMap(html.getBody());
		}
	}
}
