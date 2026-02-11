package com.hongjinqiu.nanhuprint.eval;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;
import com.hongjinqiu.nanhuprint.NanhuprintFont;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.custom.ICalcWidth;
import com.hongjinqiu.nanhuprint.eval.custom.ICustomContent;
import com.hongjinqiu.nanhuprint.eval.explain.ExplainUtil;
import com.hongjinqiu.nanhuprint.eval.step.StepEnum;
import com.hongjinqiu.nanhuprint.event.BackgroundImageVO;
import com.hongjinqiu.nanhuprint.event.NanhuprintCellImageEvent;
import com.hongjinqiu.nanhuprint.event.NanhuprintCellLineDash;
import com.hongjinqiu.nanhuprint.event.NanhuprintCellWaterMark;
import com.hongjinqiu.nanhuprint.event.WaterMarkVO;
import com.hongjinqiu.nanhuprint.model.Css;
import com.hongjinqiu.nanhuprint.model.Param;
import com.hongjinqiu.nanhuprint.model.Params;
import com.hongjinqiu.nanhuprint.model.Tr;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公共工具方法类
 *
 * @author hongjinqiu 2018.08.03
 */
public class EvalUtil {
	private static Logger logger = Logger.getLogger(EvalUtil.class);
	private static final String JS_PREFIX = "js:";
	private static final Map<String, String> ESCAPE = new HashMap<String, String>() {
		{
			put("'", "&apos;");
			put("<", "&lt;");
			put(">", "&gt;");
			put("\"", "&quot;");
			put("©", "&copy;");// 版权符
			put("®", "&reg;");    // 注册符
			put("\r", "&#x0D;");    // 回车
			put("\n", "&#x0A;");    // 换行
		}
	};
	private static final String NANHUPRINT_EVAL_ID_PREFIX = "nanhuprint_id_";// 下标前缀,
	private static int NANHUPRINT_EVAL_INDEX = 0;// 下标,递增给各个元素赋 id 之类的,

	/*
	 * 每个标签的子标签循环遍历分发方法
	 * 例如:div -> DivEval
	 * if -> IfEval
	 */
	public static void loopEvalDynamicElement(List<Object> objLi, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator, StringBuilder result) {
		if (objLi != null && objLi.size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj : objLi) {
				IEval evalImplment = evalFactory.routeEval(obj);
				String text = evalImplment.evalDynamicElement(obj, env, expressionEvaluator);
				result.append(text);
			}
		}
	}

	/**
	 * 内容自定义的公共代码
	 *
	 * @param metaObj
	 */
	private static String commonCalcWidth(Object metaObj) {
		String calcWidthClass = getParamValue(getChildLi(metaObj), NanhuprintConstant.CALC_WIDTH);
		if (StringUtils.isNotEmpty(calcWidthClass)) {
			try {
				ICalcWidth calcWidth = (ICalcWidth) Class.forName(calcWidthClass).newInstance();
				return calcWidth.calcWidth(metaObj);
			} catch (InstantiationException e) {
				logger.error("class:" + calcWidthClass + " cause error");
				throw new NanhuprintException(e);
			} catch (IllegalAccessException e) {
				logger.error("class:" + calcWidthClass + " cause error");
				throw new NanhuprintException(e);
			} catch (ClassNotFoundException e) {
				logger.error("class:" + calcWidthClass + " cause error");
				throw new NanhuprintException(e);
			}
		}
		return null;
	}

	/**
	 * xml css属性获取,例如:
	 * fontFamily="Arial"
	 * 返回 Arial
	 * 0.从缓存中读取值,
	 * 1.对应子元素,先 pdf, 再 js,
	 * 2.属性值,
	 * 3.从 css 对应的样式中,按空格分割,从右向左查找, 先 pdf, 再 js,
	 * 如果 attributeName == "WIDTH", 参数中包括 calcWidth,优先进行动态宽度计算取值,
	 * @return
	 */
	public static String getCssAttribute(Object metaObj, String attributeName) {
		String key = getIdValue(metaObj) + "_" + attributeName;
		String value = NanhuprintThreadLocal.getCssAttributeMap().get(key);
		if (value == null) {
			value = getCssAttributeInternal(metaObj, attributeName);
//			if (value != null) {// getCssAttributeInternal 会返回空字符串,不会返回 null,最多返回 ""
			NanhuprintThreadLocal.getCssAttributeMap().put(key, value);
//			}
		}
		return value;
	}

	/**
	 * getCssAttribute的内部包装实现,返回空字符串,不返回 null,
	 */
	private static String getCssAttributeInternal(Object metaObj, String attributeName) {
		if (NanhuprintThreadLocal.getStepEnum().equals(StepEnum.EVAL_TO_PDF)) {
			if (attributeName.equalsIgnoreCase(NanhuprintConstant.WIDTH)) {
				String calcWidth = commonCalcWidth(metaObj);
				if (StringUtils.isNotEmpty(calcWidth)) {
					ExplainUtil.addExplain(metaObj, "width->采用calcWidth参数,动态计算宽度->" + calcWidth);
					return calcWidth;
				}
			}
		}

		String cssElementName = attributeName;
		String value = "";
		// 1.查找对应子 css 元素,取值
		List<Object> childLi = getChildLi(metaObj);
		if (childLi != null && childLi.size() > 0) {
			for (Object childObj : childLi) {
				if (childObj instanceof Css) {
					Css childCss = (Css) childObj;
					value = getCssElementValue(childCss, cssElementName);
					if (StringUtils.isNotEmpty(value)) {
						ExplainUtil.addExplain(metaObj, cssElementName + "->从 css 子标签 " + cssElementName + " 获取属性值->" + value);
					}
					break;
				}
			}
		}
		// 2.没值时,从属性取值,
		if (StringUtils.isEmpty(value)) {
			value = getValueByReflect(metaObj, attributeName);
			if (StringUtils.isNotEmpty(value)) {
				ExplainUtil.addExplain(metaObj, attributeName + "->从属性 " + attributeName + " 中取值->" + value);
			}
		}
		// 3.从 css 对应的样式中,按空格分割,从右向左查找,
		if (StringUtils.isEmpty(value)) {
			String cls = getValueByReflect(metaObj, "cls");

			// 检查是否为 tbody 的第一行或最后一行,如果是,则使用特殊的 CSS 参数
			Map<String, Object> env = NanhuprintThreadLocal.getEnv();
			if (env != null) {
				Boolean isFirstLine = (Boolean) getValueFromNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_FIRST_LINE_OF_TBODY);
				Boolean isLastLine = (Boolean) getValueFromNanhuprintEnv(env, NanhuprintConstant.NANHUPRINT_IS_LAST_LINE_OF_TBODY);

				// 如果是第一行,尝试使用 firstLineOfTbodyCss 参数
				if (isFirstLine != null && isFirstLine) {
					String firstLineOfTbodyCss = getParamValue(childLi, NanhuprintConstant.FIRST_LINE_OF_TBODY_CSS);
					if (StringUtils.isNotEmpty(firstLineOfTbodyCss)) {
						cls = firstLineOfTbodyCss;
					}
				}

				// 如果是最后一行,尝试使用 lastLineofTbodyCss 参数
				if (isLastLine != null && isLastLine) {
					String lastLineOfTbodyCss = getParamValue(childLi, NanhuprintConstant.LAST_LINE_OF_TBODY_CSS);
					if (StringUtils.isNotEmpty(lastLineOfTbodyCss)) {
						cls = lastLineOfTbodyCss;
					}
				}
			}

			if (StringUtils.isNotEmpty(cls)) {
				String[] clsLi = cls.split(" +");// 控空格分隔
				for (int i = clsLi.length - 1; i >= 0; i--) {
					String clsName = clsLi[i];
					if (StringUtils.isNotEmpty(clsName)) {
						Css cssObj = NanhuprintThreadLocal.getCssMap().get(clsName);
						if (cssObj == null) {
							throw new NanhuprintException("css样式:" + clsName + "不存在");
						}
						value = getCssElementValue(cssObj, cssElementName);
						if (StringUtils.isNotEmpty(value)) {
							ExplainUtil.addExplain(metaObj, attributeName + "->从 cls 样式 [" + clsName + "] 中查找子标签 " + cssElementName + " 并取值->" + value);
							break;
						}
					}
				}
			}
		}
		if (StringUtils.isNotEmpty(value)) {
			// 清除末尾的 空格,分号
			if (value.startsWith(" ") || value.endsWith(" ") || value.endsWith(";")) {
				value = value.replaceAll("^\\s+|[\\s;]+$", "");
			}
		}
		return value == null ? "" : value;
	}

	/**
	 * 自身找不到某个属性时,往父级元素查找,
	 * 比如 line-height,可以多级继承,
	 *
	 * @param origMetaObj 最原来的标签,
	 * @param metaObj
	 * @param attributeName
	 * @return
	 */
	public static String getCssAttributeUp(Object origMetaObj, Object metaObj, String attributeName) {
		String value = getCssAttribute(metaObj, attributeName);
		if (StringUtils.isNotEmpty(value)) {
			return value;
		}
		while (StringUtils.isEmpty(value)) {
			String id = getValueByReflect(metaObj, NanhuprintConstant.ID);
			if (StringUtils.isEmpty(id)) {// 通常不会走到这里,加个判断作为保险
				break;
			}
			String parentId = NanhuprintThreadLocal.getKeyIdValueParentIdMap().get(id);
			if (StringUtils.isNotEmpty(parentId)) {
				Object parentObj = NanhuprintThreadLocal.getMetaObjMap().get(parentId);

				// 父标签有可能没有这个属性,例如 td 有 line-height 属性,但是父标签 thead 却没有,如果父标签没有这个属性,直接跳过,避免报错
				if (hasField(parentObj, attributeName)) {
					value = getCssAttribute(parentObj, attributeName);
				}
				metaObj = parentObj;
			} else {
				break;
			}
		}
		if ((origMetaObj != metaObj) && StringUtils.isNotEmpty(value)) {// metaObj 有可能是父标签
			ExplainUtil.addExplain(origMetaObj, "从父标签 " + metaObj.getClass().getName() + " 中查找 " + attributeName + " 值(查找范围:子标签,属性,cls)->" + value);
		}
		return value;
	}

	/**
	 * 反射查找是否有这个字段
	 *
	 * @param obj
	 * @param attributeName
	 * @return
	 */
	public static boolean hasField(Object obj, String attributeName) {
		for (Field field : obj.getClass().getDeclaredFields()) {
			if (field.getName().equalsIgnoreCase(attributeName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * css 元素的取值
	 * <width js="" pdf="" />
	 * 0.css.name 不为空时,从缓存中读取值,
	 * 1.先取 pdf 的值,再取 js 的值
	 *
	 * @param css
	 * @param attributeName
	 * @return
	 */
	private static String getCssElementValue(Css css, String attributeName) {
		if (StringUtils.isEmpty(css.getName())) {
			return getCssElementValueInternal(css, attributeName);
		} else {
			String key = css.getName() + "_css_" + attributeName;
			String value = NanhuprintThreadLocal.getCssAttributeMap().get(key);
			if (value == null) {
				value = getCssElementValueInternal(css, attributeName);
//				if (value != null) {// getCssElementValueInternal 不会返回 null,最多返回 ""
				NanhuprintThreadLocal.getCssAttributeMap().put(key, value);
//				}
			}
			return value;
		}
	}

	/**
	 * getCssElementValue 的内部包装
	 * @param css
	 * @param attributeName
	 * @return
	 */
	private static String getCssElementValueInternal(Css css, String attributeName) {
		if (css != null) {
			if (css.getIfAndForEachAndSet() != null && css.getIfAndForEachAndSet().size() > 0) {
				for (Object obj : css.getIfAndForEachAndSet()) {
					String typeName = obj.getClass().getSimpleName();// If.Width 返回 Width
					typeName = typeName.substring(0, 1).toLowerCase() + typeName.substring(1);// 首字母小写
					if (typeName.equals(attributeName)) {
						String pdf = getValueByReflect(obj, "pdf");
						if (StringUtils.isNotEmpty(pdf)) {
							return pdf == null ? "" : pdf;
						}
						String js = getValueByReflect(obj, "js");
						if (StringUtils.isNotEmpty(js)) {
							return js == null ? "" : js;
						}
						break;
					}
				}
			}
		}
		return "";
	}

	/**
	 * 通过反射取值
	 *
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static String getValueByReflect(Object obj, String fieldName) {
		try {
			Field field = obj.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return (String) field.get(obj);
		} catch (NoSuchFieldException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}
	}

	/**
	 * 每个标签的子标签循环遍历分发方法
	 * 例如:div -> DivEval
	 * Table -> TableEval
	 *
	 * 目前看起来作用有限,
	 * @param objLi
	 * @param env
	 * @param parentPdfObj
	 */
	/*public static void loopEvalToPdf(List<Object> objLi, Map<String, Object> env, Element parentPdfObj) {
		if (objLi != null && objLi.size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj: objLi) {
				// css 元素已经在父元素做过了遍历取值,不需要再解析取值,这里面直接跳过即可,
				if (!evalFactory.isCssElement(obj)) {
					IEval evalImplment = evalFactory.routeEval(obj);
					Element element = evalImplment.evalToPdf(obj, env);

					try {
						if (parentPdfObj instanceof Document) {
							((Document)parentPdfObj).add(element);
						}

					} catch (DocumentException e) {
						throw new NanhuprintException(e);
					}
//					parentObj.add(element);
				}
			}
		}
	}*/

	/**
	 * 一行元素处理,
	 * <param name="" value="" />
	 * <width js="" pdf="" />
	 * 这种元素称为一行元素,
	 *
	 * @param metaObj
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	public static String evalDynamicElementForOneLineElement(Object metaObj, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator) {
		StringBuilder result = new StringBuilder();
		String attribute = getAttributeString(metaObj, env, expressionEvaluator);
		String typeName = metaObj.getClass().getSimpleName();
		// 首字母小写
		typeName = typeName.substring(0, 1).toLowerCase() + typeName.substring(1);
		result.append("<{typeName} {attribute}>".replace("{typeName}", typeName).replace("{attribute}", attribute));
		result.append("</{typeName}>".replace("{typeName}", typeName));
		return result.toString();
	}

	/**
	 * 替换掉转义字符
	 *
	 * @return
	 */
	private static String replaceEscapeCharacter(String value) {
		// 特殊字符转义后,都包含 &, 因此,先对 & 进行特殊处理,
		if (value.indexOf("&") > -1) {
			value = value.replaceAll("&", "&amp;");
		}
		// 特殊字符的替换
		for (String escapeItem : ESCAPE.keySet()) {
			if (value.indexOf(escapeItem) > -1) {
				value = value.replaceAll(escapeItem, ESCAPE.get(escapeItem));
			}
		}
		return value;
	}

	/**
	 * 反射取得对象属性值,拼装字符串属性值,同时进行属性的表达式解析,
	 * 例如:<div width="20px" height="30px">
	 * 返回:width="20px" height="30px"
	 * <div width="js:1+1" height="js:5+7">
	 * 返回:width="2" height="12"
	 *
	 * @param metaObj
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	public static String getAttributeString(Object metaObj, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator) {
		StringBuilder result = new StringBuilder();
		Field[] fields = metaObj.getClass().getDeclaredFields();
		for (Field item : fields) {
			item.setAccessible(true);// 强制可访问
			Object valueObj;
			try {
				valueObj = item.get(metaObj);
			} catch (IllegalAccessException e) {
				logger.error(e.getMessage(), e);
				throw new NanhuprintException(e);
			}
			// 非字符串类型的属性一般为数组子元素,需要在别的地方再遍历读取,
			if (valueObj instanceof String) {
				// js:表达式开头,进行表达式解析,
				String value = (String) valueObj;
				if (value.indexOf(JS_PREFIX) == 0) {
					String valueToLog = value.substring(JS_PREFIX.length());
					if (StringUtils.isEmpty(valueToLog)) {// 空字符串,直接抛异常
						String log = "Error eval expression, attribute value null or empty, tagName:[{tagName}]/[{item}:{expression}], env is:";
						log = log.replace("{tagName}", metaObj.getClass().getName());
						log = log.replace("{item}", item.getName());
						log = log.replace("{expression}", valueToLog);
						logger.error(log);
//						String jsonEnv = UtilString.object2Json(env);
						String jsonEnv = null;
						try {
							jsonEnv = JSONObject.fromObject(env).toString();
						} catch (Exception e) {
							logger.error(e.getMessage(), e);
						}
						logger.error(jsonEnv);
						throw new NanhuprintException(log + jsonEnv);
					}
					Object evalResult = expressionEvaluator.eval(valueToLog, env);
					if (evalResult != null) {
						value = evalResult.toString();
					} else {
						String log = "Error eval expression, 表达式解析返回null, 请修改表达式使其不返回null, tagName:[{tagName}]/[{item}:{expression}], env is:";
						log = log.replace("{tagName}", metaObj.getClass().getName());
						log = log.replace("{item}", item.getName());
						log = log.replace("{expression}", valueToLog);
						logger.error(log);
//						String jsonEnv = UtilString.object2Json(env);// UtilString 的转 json, 经常会出错,使用 JSONObject 比较稳定一些,
						String jsonEnv = null;
						try {
							jsonEnv = JSONObject.fromObject(env).toString();
						} catch (Exception e) {
							logger.error(e.getMessage(), e);
						}
						logger.error(jsonEnv);
						throw new NanhuprintException(log + jsonEnv);
					}
				}

				value = replaceEscapeCharacter(value);

				result.append("{item}=\"{value}\" ".replace("{item}", item.getName()).replace("{value}", value));
			} else if (valueObj instanceof Number) {// number
				result.append("{item}=\"{value}\" ".replace("{item}", item.getName()).replace("{value}", valueObj.toString()));
			} else if (valueObj instanceof Boolean) {// number
				result.append("{item}=\"{value}\" ".replace("{item}", item.getName()).replace("{value}", (Boolean) valueObj ? "true" : "false"));
			}
		}
		return result.toString();
	}

	/**
	 * 给执行环境循环赋值,当 env 的 nanhuprint_outer 有值,并且 nanhuprint_outer 也有对应的 key 时,
	 * 给对应的 nanhuprint_outer 赋值
	 *
	 * @param env
	 * @param key
	 * @param value
	 */
	public static void loopSetEnvValue(Map<String, Object> env, String key, Object value) {
		env.put(key, value);
		Map<String, Object> outerEnv = (Map<String, Object>) env.get(NanhuprintConstant.NANHUPRINT_OUTER);
		while (outerEnv != null) {
			if (outerEnv.get(key) != null) {
				outerEnv.put(key, value);
			}
			outerEnv = (Map<String, Object>) outerEnv.get(NanhuprintConstant.NANHUPRINT_OUTER);
		}
	}

	/**
	 * 每个元素都放一个 nanhuprint_parentId,指向父元素,以方便访问,
	 *
	 * @param parentObj
	 * @param objLi
	 */
	private static void loopSetIdAndParentId(Object parentObj, List<Object> objLi) {
		if (objLi != null && objLi.size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj : objLi) {
				IEval evalImplment = evalFactory.routeEval(obj);
				evalImplment.setIdAndParentId(obj, parentObj);
			}
		}
	}

	/**
	 * 每个元素放置 id:width 映射
	 * @param parentObj
	 * @param absoluteWidths
	 * @param rowColumnFlag
	 * @param objLi
	 */
	public static void loopSetContentWidth(Object parentObj, float[] absoluteWidths, int[][] rowColumnFlag, List<Object> objLi) {
		if (objLi != null && objLi.size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj : objLi) {
				IEval evalImplment = evalFactory.routeEval(obj);
				evalImplment.setContentWidth(obj, absoluteWidths, rowColumnFlag);
			}
		}
	}

	/**
	 * 遍历元素,调用 setIdAndMetaObj
	 *
	 * @param objLi
	 */
	private static void loopSetIdAndMetaObj(List<Object> objLi) {
		if (objLi != null && objLi.size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj : objLi) {
				IEval evalImplment = evalFactory.routeEval(obj);
				evalImplment.setIdAndMetaObj(obj);
			}
		}
	}

	/**
	 * 给每个标签设一个 id 属性,方便用到的时候取值,
	 * 由于标签映射类由 xjc 生成,没有实现公共的接口,因此,用反射来赋值,
	 *
	 * @param metaObj
	 * @param parentId
	 */
	public static void commonSetIdAndParentId(Object metaObj, String parentId) {
		if (NANHUPRINT_EVAL_INDEX == Integer.MAX_VALUE) {
			NANHUPRINT_EVAL_INDEX = 0;
		}
		try {
			Field field = metaObj.getClass().getDeclaredField("id");
			field.setAccessible(true);
			String idValue = (String) field.get(metaObj);
			if (StringUtils.isEmpty(idValue)) {
				idValue = NANHUPRINT_EVAL_ID_PREFIX + (NANHUPRINT_EVAL_INDEX++);
				field.set(metaObj, idValue);
			}
			Map<String, String> keyIdValueParentIdMap = NanhuprintThreadLocal.getKeyIdValueParentIdMap();
			if (keyIdValueParentIdMap.get(idValue) != null) {
				throw new NanhuprintException("id 重复,可能是 xml 中存在重复 id 为:" + idValue);
			}
			keyIdValueParentIdMap.put(idValue, parentId);

			loopSetIdAndParentId(metaObj, getChildLi(metaObj));
		} catch (NoSuchFieldException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}
	}

	/**
	 * 给每个标签设一个 id -> metaObj 的映射,方便用到的时候取值
	 * 由于标签映射类由 xjc 生成,没有实现公共的接口,因此,用反射来赋值,
	 *
	 * @param metaObj
	 */
	public static void commonSetIdAndMetaObj(Object metaObj) {
		try {
			Field field = metaObj.getClass().getDeclaredField("id");
			field.setAccessible(true);
			String idValue = (String) field.get(metaObj);
			NanhuprintThreadLocal.getMetaObjMap().put(idValue, metaObj);

			loopSetIdAndMetaObj(getChildLi(metaObj));
		} catch (NoSuchFieldException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}
	}

	/**
	 * 往 threadLocal 中放 {id: font} 的公共方法
	 *
	 * @param metaObj
	 * @param font
	 */
	public static void commonSetFontToMap(Object metaObj, Font font) {
		String fontFamily = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.FONT_FAMILY);
		if (StringUtils.isNotEmpty(fontFamily)) {
			// 自定义的字体名称, 不用小写
			if (NanhuprintThreadLocal.getFontMap().get(fontFamily) != null) {
				Font oldFont = font;
				font = new Font(NanhuprintThreadLocal.getFontMap().get(fontFamily));
				font.setStyle(oldFont.getStyle());
				font.setSize(oldFont.getSize());
				font.setColor(oldFont.getColor());
			}
			/*
			String originalFontFamily = fontFamily;
			fontFamily = fontFamily.toLowerCase();
			if (fontFamily.indexOf(NanhuprintFont.TIMES_FONT_KEY) > -1) {
				Font oldFont = font;
				font = new Font(NanhuprintThreadLocal.getFontMap().get(NanhuprintFont.TIMES_FONT_KEY));
				font.setStyle(oldFont.getStyle());
				font.setSize(oldFont.getSize());
				font.setColor(oldFont.getColor());
			} else if (fontFamily.indexOf(NanhuprintFont.CALIBRI_FONT_KEY) > -1) {
				Font oldFont = font;
				font = new Font(NanhuprintThreadLocal.getFontMap().get(NanhuprintFont.CALIBRI_FONT_KEY));
				font.setStyle(oldFont.getStyle());
				font.setSize(oldFont.getSize());
				font.setColor(oldFont.getColor());
			} else if (fontFamily.indexOf(NanhuprintFont.CENTURY_FONT_KEY) > -1) {
				Font oldFont = font;
				font = new Font(NanhuprintThreadLocal.getFontMap().get(NanhuprintFont.CENTURY_FONT_KEY));
				font.setStyle(oldFont.getStyle());
				font.setSize(oldFont.getSize());
				font.setColor(oldFont.getColor());
			} else if (NanhuprintThreadLocal.getFontMap().get(originalFontFamily) != null) {
				Font oldFont = font;
				font = new Font(NanhuprintThreadLocal.getFontMap().get(originalFontFamily));
				font.setStyle(oldFont.getStyle());
				font.setSize(oldFont.getSize());
				font.setColor(oldFont.getColor());
			}*/
		}

		String fontStyle = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.FONT_STYLE);
		fontStyle = fontStyle == null ? "" : fontStyle;

		String fontWeight = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.FONT_WEIGHT);
		fontWeight = fontWeight == null ? "" : fontWeight;

		String fontSize = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.FONT_SIZE);
		fontSize = fontSize == null ? "" : fontSize;
		float fontSizeFloat = getPrefixFloatValue(fontSize);

		String color = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.COLOR);
		color = color == null ? "" : color.replace("#", "");

		String textDecoration = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.TEXT_DECORATION);
		textDecoration = ObjectUtils.toString(textDecoration, "");

		boolean isNewFont = StringUtils.isNotEmpty(fontStyle);
		isNewFont = isNewFont || StringUtils.isNotEmpty(fontWeight);
		isNewFont = isNewFont || StringUtils.isNotEmpty(fontSize);
		isNewFont = isNewFont || StringUtils.isNotEmpty(color);
		isNewFont = isNewFont || StringUtils.isNotEmpty(textDecoration);

		if (isNewFont) {
			int fontStyleInt = font.getStyle();
			if (fontStyle.equalsIgnoreCase(NanhuprintConstant.ITALIC)) {
				fontStyleInt = getFontStyle(fontStyleInt, Font.ITALIC);
			}
			if (fontWeight.equalsIgnoreCase(NanhuprintConstant.BOLD)) {
				fontStyleInt = getFontStyle(fontStyleInt, Font.BOLD);
			}
			if (StringUtils.isNotEmpty(textDecoration) && textDecoration.equalsIgnoreCase(NanhuprintConstant.TEXT_DECORATION_VALUE_UNDERLINE)) {
				fontStyleInt = getFontStyle(fontStyleInt, Font.UNDERLINE);
			}

			if (fontSizeFloat == 0) {
				fontSizeFloat = font.getSize();
			}
			font = new Font(font);
			font.setStyle(fontStyleInt);
			font.setSize(fontSizeFloat);

			setColorToFont(font, color);
		}
		String id = EvalUtil.getValueByReflect(metaObj, "id");
		NanhuprintThreadLocal.getFontMap().put(id, font);

		loopSetFontToMap(getChildLi(metaObj));
	}

	/**
	 * 追加字体样式
	 *
	 * @param fontStyle
	 * @param fontStyleAppend
	 * @return
	 */
	private static int getFontStyle(int fontStyle, int fontStyleAppend) {
		if (fontStyle == Font.UNDEFINED) {
			return fontStyleAppend;
		}
		return fontStyle | fontStyleAppend;
	}

	/**
	 * 子元素循环赋值
	 *
	 * @param objLi
	 */
	public static void loopSetFontToMap(List<Object> objLi) {
		if (objLi != null && objLi.size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			for (Object obj : objLi) {
				IEval evalImplment = evalFactory.routeEval(obj);
				evalImplment.setFontToMap(obj);
			}
		}
	}

	/**
	 * 字体的颜色赋值
	 *
	 * @param font
	 * @param color
	 */
	private static void setColorToFont(Font font, String color) {
		BaseColor baseColor = getBaseColor(color);
		if (baseColor != null) {
			font.setColor(baseColor);
		}
	}

	/**
	 * 根据字符串获取颜色
	 *
	 * @param color
	 */
	public static BaseColor getBaseColor(String color) {
		if (StringUtils.isNotEmpty(color)) {
			if (color.toLowerCase().equals("white")) {
				return BaseColor.WHITE;
			}
			if (color.toLowerCase().equals("light_gray")) {
				return BaseColor.LIGHT_GRAY;
			}
			if (color.toLowerCase().equals("gray")) {
				return BaseColor.GRAY;
			}
			if (color.toLowerCase().equals("dark_gray")) {
				return BaseColor.DARK_GRAY;
			}
			if (color.toLowerCase().equals("black")) {
				return BaseColor.BLACK;
			}
			if (color.toLowerCase().equals("red")) {
				return BaseColor.RED;
			}
			if (color.toLowerCase().equals("pink")) {
				return BaseColor.PINK;
			}
			if (color.toLowerCase().equals("orange")) {
				return BaseColor.ORANGE;
			}
			if (color.toLowerCase().equals("yellow")) {
				return BaseColor.YELLOW;
			}
			if (color.toLowerCase().equals("green")) {
				return BaseColor.GREEN;
			}
			if (color.toLowerCase().equals("magenta")) {
				return BaseColor.MAGENTA;
			}
			if (color.toLowerCase().equals("cyan")) {
				return BaseColor.CYAN;
			}
			if (color.toLowerCase().equals("blue")) {
				return BaseColor.BLUE;
			}
			if (color.startsWith("#")) {
				color = color.substring(1);
			}
			if (color.length() == 6) {
				String str2 = color.substring(0, 2);
				String str3 = color.substring(2, 4);
				String str4 = color.substring(4, 6);
				int red = Integer.parseInt(str2, 16);
				int green = Integer.parseInt(str3, 16);
				int blue = Integer.parseInt(str4, 16);
				return new BaseColor(red, green, blue);
			}
		}
		return null;
	}

	/**
	 * 35px -> 35
	 *
	 * @param text
	 * @return
	 */
	public static float getPrefixFloatValue(String text) {
		if (StringUtils.isEmpty(text)) {
			return 0;
		}
		int lastNumber = 0;
		for (; lastNumber < text.length(); lastNumber++) {
			boolean isNumber = '0' <= text.charAt(lastNumber) && text.charAt(lastNumber) <= '9';
			isNumber = isNumber || text.charAt(lastNumber) == '.';
			if (!isNumber) {
				break;
			}
		}
		if (lastNumber > 0) {
			String prefixNumber = text.substring(0, lastNumber);
			return Float.valueOf(prefixNumber);
		}
		return 0;
	}

	/**
	 * 取得 id 值
	 *
	 * @param metaObj
	 * @return
	 */
	public static String getIdValue(Object metaObj) {
		try {
			Field field = metaObj.getClass().getDeclaredField("id");
			field.setAccessible(true);
			return (String) field.get(metaObj);
		} catch (NoSuchFieldException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}
	}

	/**
	 * 取得子元素值
	 *
	 * @param metaObj
	 * @return
	 */
	public static List<Object> getChildLi(Object metaObj) {
		String childKey = new EvalFactory().getChildKey(metaObj);
		if (StringUtils.isEmpty(childKey)) {// 有些标签没有子元素,例如 param
			return new ArrayList<>();
		}
		try {
			Field field = metaObj.getClass().getDeclaredField(childKey);
			field.setAccessible(true);// 强制可访问
			return (List<Object>) (field.get(metaObj));
		} catch (NoSuchFieldException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}
	}

	/**
	 * div,table,tr,td,css 等元素的 xml 输出解析,除了标签不同,其它都相同,
	 *
	 * @param tagName
	 * @param metaObj
	 * @param childLi
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	public static String commonEvalDynamicElement(String tagName, Object metaObj, List<Object> childLi, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator) {
		StringBuilder result = new StringBuilder();
		String attribute = getAttributeString(metaObj, env, expressionEvaluator);
		result.append("<{tagName} {attribute}>".replace("{tagName}", tagName).replace("{attribute}", attribute));
		loopEvalDynamicElement(childLi, env, expressionEvaluator, result);
		result.append("</{tagName}>".replace("{tagName}", tagName));
		return result.toString();
	}

	/**
	 * 设置左右浮动
	 *
	 * @param metaObj
	 * @param pdfPTable
	 */
	public static void setPdfPTableCommonAttribute(Object metaObj, PdfPTable pdfPTable) {
		String floatValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.FLOAT_ALIGN);
		if (StringUtils.isNotEmpty(floatValue) && floatValue.equalsIgnoreCase(NanhuprintConstant.FLOAT_ALIGN_VALUE_LEFT)) {
			pdfPTable.setHorizontalAlignment(Element.ALIGN_LEFT);
		} else if (StringUtils.isNotEmpty(floatValue) && floatValue.equalsIgnoreCase(NanhuprintConstant.FLOAT_ALIGN_VALUE_RIGHT)) {
			pdfPTable.setHorizontalAlignment(Element.ALIGN_RIGHT);
		} else if (StringUtils.isEmpty(floatValue)) {// 默认左对齐
			pdfPTable.setHorizontalAlignment(Element.ALIGN_LEFT);
		}
	}

	/*
	 * 根据 metaObj 的属性,给 PdfPCell 赋值
	 * 注:iText 有一个 bug, 当 borderStyle="dashed" 时,表格中的第一个单元格不起作用,
	* 而当前 div 的输出,用的是只有一个单元格的 table, 即, div 无法实现虚线,
	* 变通的解决方式为:自己配置成 table, 第一个单元格 0, 第二个单元格 100%
	*
	* @param metaObj
	* @return
	 */
	public static PdfPCell getPdfPCell(Object metaObj, Map<String, Object> env) {
		PdfPCell cell = new PdfPCell();
//		cell.setUseAscender(true);// 这一行,使得cell add Paragraph 时,不会底对齐,但是会带来其它的问题,行项字体变得非常挤,因此,还是老老实实的 padding
		/*// height,只支持绝对值,不支持百分比,
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.HEIGHT);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setFixedHeight(EvalUtil.getPrefixFloatValue(attributeValue));
			}
		}
		// minHeight,只支持绝对值,不支持百分比,
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.MIN_HEIGHT);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setMinimumHeight(EvalUtil.getPrefixFloatValue(attributeValue));
			}
		}*/
		// paddingLeft
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.PADDING_LEFT);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setPaddingLeft(EvalUtil.getPrefixFloatValue(attributeValue));
			} else {
				cell.setPaddingLeft(0);
			}
		}
		// paddingTop
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.PADDING_TOP);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setPaddingTop(EvalUtil.getPrefixFloatValue(attributeValue));
			} else {
				cell.setPaddingTop(0);
			}
		}
		// paddingRight
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.PADDING_RIGHT);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setPaddingRight(EvalUtil.getPrefixFloatValue(attributeValue));
			} else {
				cell.setPaddingRight(0);
			}
		}
		// paddingBottom
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.PADDING_BOTTOM);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setPaddingBottom(EvalUtil.getPrefixFloatValue(attributeValue));
			} else {
				cell.setPaddingBottom(0);
			}
		}
		// textAlign,需要往父级查找属性
		setCellTextAlign(metaObj, cell);
		// white-space
		setCellWhiteSpace(metaObj, cell);
		// line-height,需要往父级查找属性
		setCellLineHeight(metaObj, cell);
		// borderTopWidth
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_TOP_WIDTH);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setBorderWidthTop(EvalUtil.getPrefixFloatValue(attributeValue));
			} else {
				cell.setBorderWidthTop(0);
			}
		}
		// borderTopColor
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_TOP_COLOR);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setBorderColorTop(EvalUtil.getBaseColor(attributeValue));
			}
		}
		// borderLeftWidth
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_LEFT_WIDTH);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setBorderWidthLeft(EvalUtil.getPrefixFloatValue(attributeValue));
			} else {
				cell.setBorderWidthLeft(0);
			}
		}
		// borderLeftColor
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_LEFT_COLOR);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setBorderColorLeft(EvalUtil.getBaseColor(attributeValue));
			}
		}
		// borderRightWidth
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_RIGHT_WIDTH);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setBorderWidthRight(EvalUtil.getPrefixFloatValue(attributeValue));
			} else {
				cell.setBorderWidthRight(0);
			}
		}
		// borderRightColor
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_RIGHT_COLOR);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setBorderColorRight(EvalUtil.getBaseColor(attributeValue));
			}
		}
		// borderBottomWidth
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_BOTTOM_WIDTH);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setBorderWidthBottom(EvalUtil.getPrefixFloatValue(attributeValue));
			} else {
				cell.setBorderWidthBottom(0);
			}
		}
		// borderBottomColor
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_BOTTOM_COLOR);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setBorderColorBottom(EvalUtil.getBaseColor(attributeValue));
			}
		}
		// borderStyle,只支持一种,
		{
//			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_STYLE);
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_LEFT_STYLE);
			if (StringUtils.isEmpty(attributeValue)) {
				attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_TOP_STYLE);
			}
			if (StringUtils.isEmpty(attributeValue)) {
				attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_RIGHT_STYLE);
			}
			if (StringUtils.isEmpty(attributeValue)) {
				attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BORDER_BOTTOM_STYLE);
			}
			if (StringUtils.isNotEmpty(attributeValue)) {
				if (attributeValue.equalsIgnoreCase(NanhuprintConstant.BORDER_STYLE_VALUE_DASHED)) {
					cell.setCellEvent(new NanhuprintCellLineDash());
				}
			}
		}
		// verticalAlign
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.VERTICAL_ALIGN);
			if (StringUtils.isNotEmpty(attributeValue)) {
				if (attributeValue.equalsIgnoreCase(NanhuprintConstant.VERTICAL_ALIGN_VALUE_TOP)) {
					cell.setVerticalAlignment(Element.ALIGN_TOP);
				}
				if (attributeValue.equalsIgnoreCase(NanhuprintConstant.VERTICAL_ALIGN_VALUE_MIDDLE)) {
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				}
				if (attributeValue.equalsIgnoreCase(NanhuprintConstant.VERTICAL_ALIGN_VALUE_BOTTOM)) {
					cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
				}
			}
		}
		// backgroundColor
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_COLOR);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setBackgroundColor(EvalUtil.getBaseColor(attributeValue));
			}
		}
		// backgroundImage
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_IMAGE);
			if (StringUtils.isNotEmpty(attributeValue)) {
				// url('http://www.')
				try {
					Pattern pattern = Pattern.compile("url\\(['\"]?(.*?)['\"]?\\)", Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(attributeValue);
					if (matcher.find()) {
						String urlText = matcher.group(1);
//						String backgroundSize = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_SIZE);
//						String backgroundPositionX = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_POSITION_X);
//						String backgroundPositionY = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_POSITION_Y);

						BackgroundImageVO backgroundImageVO = new BackgroundImageVO();
						backgroundImageVO.setImg(Image.getInstance(new URL(urlText)));
						backgroundImageVO.setBackgroundSize(EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_SIZE));
						backgroundImageVO.setBackgroundPositionX(EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_POSITION_X));
						backgroundImageVO.setBackgroundPositionY(EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_POSITION_Y));
						backgroundImageVO.setBackgroundImageOpacityByPdf(EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_IMAGE_OPACITY_BY_PDF));

						NanhuprintCellImageEvent imgEvent = new NanhuprintCellImageEvent(backgroundImageVO);
						cell.setCellEvent(imgEvent);
					}
				} catch (MalformedURLException e) {
					logger.error(e.getMessage(), e);
//					throw new NanhuprintException(e);
				} catch (BadElementException e) {
					logger.error(e.getMessage(), e);
//					throw new NanhuprintException(e);
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
//					throw new NanhuprintException(e);
				}
			}
		}
		// colspan
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.COLSPAN);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setColspan(new Float(EvalUtil.getPrefixFloatValue(attributeValue)).intValue());
			}
		}
		// rowspan
		{
			String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.ROWSPAN);
			if (StringUtils.isNotEmpty(attributeValue)) {
				cell.setRowspan(new Float(EvalUtil.getPrefixFloatValue(attributeValue)).intValue());
			}
		}
		// waterMark
		{
			// 水印
			String waterMark = EvalUtil.getParamValue(getChildLi(metaObj), NanhuprintConstant.NANHUPRINT_WATER_MARK);
			if (StringUtils.isNotEmpty(waterMark) && waterMark.equalsIgnoreCase(NanhuprintConstant.NANHUPRINT_WATER_MARK_VALUE_DEFAULT)) {
				WaterMarkVO waterMarkVO = EvalUtil.getWaterMarkVO(metaObj);
				NanhuprintCellWaterMark nanhuprintCellWaterMark = new NanhuprintCellWaterMark(waterMarkVO);
				cell.setCellEvent(nanhuprintCellWaterMark);
			}
		}
		// 根据 minHeight,height,maxHeight属性值设置高度
		applyHeightMinHeightMaxHeight(metaObj, cell, env);
		{
//		Paragraph paragraph = new Paragraph("test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2");
//		paragraph.setAlignment(Element.ALIGN_CENTER);
//		cell.setPhrase(paragraph);
//		cell.addElement(paragraph);
		}
		{
//			Phrase phrase = new Phrase("test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2test2");
//			cell.setPhrase(phrase);
		}
		return cell;
	}

	/**
	 * cell 有以下两个方法
	 * setFixedHeight,
	 * setMinimumHeight,
	 * 当 setMinimumHeight(50),setFixedHeight(100),单元格内容不足50时, iText 会设置高度为 50,而 html 会设置 100,即 iText 与 html 的渲染存在差异
	 * 因此,用以下的算法来统一这个差异
	 * 1个有值,
	 [minHeight],
	 其需要用 绝对值宽度,以计算出高度,
	 算法:1.先计算一遍子元素高度,innerHeight,
	 2. innerHeight < minHeight => 设置 td 高度为 minHeight,
	 3. innerHeight >= minHeight => 不设 td 高度,让其随内容自由扩展,

	 [height],
	 算法:设置 td 高度为 height,

	 [maxHeight],
	 算法:1.先计算一遍子元素高度,innerHeight,
	 2. innerHeight < maxHeight => 不设 td 高度,让其随内容自由扩展,最终多高就多高,
	 3. innerHeight >= maxHeight => 设置 td 高度为 maxHeight,多余的部分其自动不显示出来,

	 2个有值,
	 [minHeight,height]
	 算法:0.检查 minHeight <= height, 否则报错,给出提示,
	 1.minHeight < height,设置 td 高度为 height,

	 [minHeight,maxHeight]
	 算法:0.检查 minHeight <= maxHeight, 否则报错,
	 1.先计算一遍子元素高度,innerHeight,
	 2. [innerHeight, minHeight, maxHeight]	=>	设置 td 高度为 minHeight
	 3. [minHeight, innerHeight, maxHeight]	=>	设置 td 高度为 innerHeight
	 4. [minHeight, maxHeight, innerHeight]	=>	设置 td 高度为 maxHeight,多余部分自动不显示,

	 [height,maxHeight]
	 算法:0.检查 height <= maxHeight, 否则报错,
	 1.在配置的时候,js就用 console.error,进行提示,
	 2.设置 td 高度为 height,

	 3个有值,
	 [minHeight,height,maxHeight]
	 算法:0. 检查 minHeight <= height <= maxHeight, 否则报错,
	 1.设置 td 高度为 height,
	 * @param cell
	 */
	private static void applyHeightMinHeightMaxHeight(Object metaObj, PdfPCell cell, Map<String, Object> env) {
		// minHeight, height, maxHeight 只支持绝对值,不支持百分比,
		String heightAttributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.HEIGHT);
		String minHeightAttributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.MIN_HEIGHT);
		String maxHeightAttributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.MAX_HEIGHT);
		boolean isHeightEmpty = StringUtils.isEmpty(heightAttributeValue);
		boolean isMinHeightEmpty = StringUtils.isEmpty(minHeightAttributeValue);
		boolean isMaxHeightEmpty = StringUtils.isEmpty(maxHeightAttributeValue);

		if (isHeightEmpty && isMinHeightEmpty && isMaxHeightEmpty) {
			return;
		}

		// [minHeight]
		if ((!isMinHeightEmpty) && isHeightEmpty && isMaxHeightEmpty) {
			cell.setMinimumHeight(EvalUtil.getPrefixFloatValue(minHeightAttributeValue));
			ExplainUtil.addExplain(metaObj, "setMinimumHeight->采用minHeight参数->" + minHeightAttributeValue);
			return;
		}

		// [height]
		if ((!isHeightEmpty) && isMinHeightEmpty && isMaxHeightEmpty) {
			cell.setFixedHeight(EvalUtil.getPrefixFloatValue(heightAttributeValue));
			ExplainUtil.addExplain(metaObj, "setFixedHeight->采用height参数->" + heightAttributeValue);
			return;
		}

		// [maxHeight]
		if ((!isMaxHeightEmpty) && isHeightEmpty && isMinHeightEmpty) {
			float innerHeight = getChildElementsHeight(metaObj, cell, env);
			float maxHeight = EvalUtil.getPrefixFloatValue(maxHeightAttributeValue);
			if (innerHeight < maxHeight) {
				// 不设 td 高度,让其随内容自由扩展,最终多高就多高,
				ExplainUtil.addExplain(metaObj, "[maxHeight], innerHeight < maxHeight,高度不赋值");
			} else {
				cell.setFixedHeight(maxHeight);
				ExplainUtil.addExplain(metaObj, "setFixedHeight->采用maxHeight参数->" + maxHeightAttributeValue);
			}
			return;
		}

		// [minHeight,height]
		if ((!isMinHeightEmpty) && (!isHeightEmpty) && isMaxHeightEmpty) {
			float minHeight = EvalUtil.getPrefixFloatValue(minHeightAttributeValue);
			float height = EvalUtil.getPrefixFloatValue(heightAttributeValue);
			if (minHeight > height) {
				throw new NanhuprintException("元素" + metaObj.getClass().getSimpleName() + "发生 minHeight > height 的配置错误,minHeight值:" + minHeightAttributeValue + ",height值:" + heightAttributeValue);
			} else {
				cell.setFixedHeight(height);
				ExplainUtil.addExplain(metaObj, "setFixedHeight->采用height参数->" + heightAttributeValue);
			}
			return;
		}

		// [minHeight,maxHeight]
		if ((!isMinHeightEmpty) && (!isMaxHeightEmpty) && isHeightEmpty) {
			float minHeight = EvalUtil.getPrefixFloatValue(minHeightAttributeValue);
			float maxHeight = EvalUtil.getPrefixFloatValue(maxHeightAttributeValue);
			if (minHeight > maxHeight) {
				throw new NanhuprintException("元素" + metaObj.getClass().getSimpleName() + "发生 minHeight > maxHeight 的配置错误,minHeight值:" + minHeightAttributeValue + ",maxHeight值:" + maxHeightAttributeValue);
			}
			float innerHeight = getChildElementsHeight(metaObj, cell, env);
			if ((innerHeight <= minHeight) && (minHeight <= maxHeight)) {
				cell.setFixedHeight(minHeight);
				ExplainUtil.addExplain(metaObj, "setFixedHeight->采用minHeight参数->" + minHeightAttributeValue);
			} else if ((minHeight <= innerHeight) && (innerHeight <= maxHeight)) {
				// do nothing
				ExplainUtil.addExplain(metaObj, "[minHeight,maxHeight], (minHeight <= innerHeight) && (innerHeight <= maxHeight),高度不赋值");
			} else if ((minHeight <= maxHeight) && (maxHeight <= innerHeight)) {
				cell.setFixedHeight(maxHeight);
				ExplainUtil.addExplain(metaObj, "setFixedHeight->采用maxHeight参数->" + maxHeightAttributeValue);
			}
			return;
		}

		// [height,maxHeight]
		if ((!isHeightEmpty) && (!isMaxHeightEmpty) && isMinHeightEmpty) {
			float maxHeight = EvalUtil.getPrefixFloatValue(maxHeightAttributeValue);
			float height = EvalUtil.getPrefixFloatValue(heightAttributeValue);
			if (height > maxHeight) {
				throw new NanhuprintException("元素" + metaObj.getClass().getSimpleName() + "发生 height > maxHeight 的配置错误,height值:" + heightAttributeValue + ",maxHeight值:" + maxHeightAttributeValue);
			}
			cell.setFixedHeight(height);
			ExplainUtil.addExplain(metaObj, "setFixedHeight->采用height参数->" + heightAttributeValue);
			return;
		}

		// [minHeight,height,maxHeight]
		if ((!isMinHeightEmpty) && (!isHeightEmpty) && (!isMaxHeightEmpty)) {
			float minHeight = EvalUtil.getPrefixFloatValue(minHeightAttributeValue);
			float maxHeight = EvalUtil.getPrefixFloatValue(maxHeightAttributeValue);
			float height = EvalUtil.getPrefixFloatValue(heightAttributeValue);

			if (!((minHeight <= height) && (height <= maxHeight))) {
				throw new NanhuprintException("元素" + metaObj.getClass().getSimpleName() + "发生 !(minHeight <= height <= maxHeight) 的配置错误,minHeight值:" + minHeightAttributeValue + ",height值:" + heightAttributeValue + ",maxHeight值:" + maxHeightAttributeValue);
			}
			cell.setFixedHeight(height);
			ExplainUtil.addExplain(metaObj, "setFixedHeight->采用height参数->" + heightAttributeValue);
			return;
		}
	}

	/**
	 * new 一个 cell 出来,将子元素加进去,然后计算高度
	 */
	private static float getChildElementsHeight(Object metaObj, PdfPCell outerCell, Map<String, Object> env) {
		float width = NanhuprintThreadLocal.getContentWidthMap().get(getValueByReflect(metaObj, NanhuprintConstant.ID));
		PdfPTable pdfPTable = new PdfPTable(1);
		EvalUtil.setPdfPTableCommonAttribute(metaObj, pdfPTable);
		pdfPTable.setTotalWidth(width);
		pdfPTable.setLockedWidth(true);

		PdfPCell cell = new PdfPCell();
		cell.setPaddingTop(outerCell.getPaddingTop());
		cell.setPaddingRight(outerCell.getPaddingRight());
		cell.setPaddingBottom(outerCell.getPaddingBottom());
		cell.setPaddingLeft(outerCell.getPaddingLeft());
		// textAlign,需要往父级查找属性
		cell.setHorizontalAlignment(outerCell.getHorizontalAlignment());
		// white-space
		cell.setNoWrap(outerCell.isNoWrap());
		// line-height,需要往父级查找属性
		cell.setLeading(outerCell.getLeading(), outerCell.getMultipliedLeading());
		// borderWidth
		cell.setBorderWidthTop(outerCell.getBorderWidthTop());
		cell.setBorderWidthRight(outerCell.getBorderWidthRight());
		cell.setBorderWidthBottom(outerCell.getBorderWidthBottom());
		cell.setBorderWidthLeft(outerCell.getBorderWidthLeft());
		// verticalAlign
		cell.setVerticalAlignment(outerCell.getVerticalAlignment());

		EvalUtil.addCellSubElements(metaObj, cell, getChildLi(metaObj), env);
		EvalUtil.commonCustomContent(metaObj, cell, env);
		pdfPTable.addCell(cell);
		return pdfPTable.getTotalHeight();
	}

	/**
	 * 取得水印值对象
	 * @param metaObj
	 * @return
	 */
	public static WaterMarkVO getWaterMarkVO(Object metaObj) {
		Font font = NanhuprintThreadLocal.getFontMap().get(EvalUtil.getIdValue(metaObj));
		WaterMarkVO waterMarkVO = new WaterMarkVO();
		waterMarkVO.setFont(new Font(font));
		List<Object> childLi = getChildLi(metaObj);
		waterMarkVO.setWaterMarkText(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_TEXT));
		waterMarkVO.setWaterMarkOpacity(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_OPACITY));
		waterMarkVO.setWaterMarkTextFontSize(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_TEXT_FONT_SIZE));
		waterMarkVO.setWaterMarkOffsetX(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_OFFSET_X));
		waterMarkVO.setWaterMarkOffsetY(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_OFFSET_Y));
		waterMarkVO.setWaterMarkRotation(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_ROTATION));

		waterMarkVO.setWaterMarkImage(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_IMAGE));
		waterMarkVO.setWaterMarkImageWidth(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_IMAGE_WIDTH));
		waterMarkVO.setWaterMarkImageHeight(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_IMAGE_HEIGHT));
		waterMarkVO.setWaterMarkLayer(EvalUtil.getParamValue(childLi, NanhuprintConstant.NANHUPRINT_WATER_MARK_LAYER));

		return waterMarkVO;
	}

	/**
	 * <tr height="xxx">
	 * <th></th>
	 * </tr>
	 * 如果 th 没设高度,而 tr 设置了高度,给 th 设置这个高度
	 *
	 * @param metaObj
	 * @param cell
	 */
	public static void applyTrAttributeToTdTh(Object metaObj, PdfPCell cell) {
		String id = getValueByReflect(metaObj, NanhuprintConstant.ID);
		String parentId = NanhuprintThreadLocal.getKeyIdValueParentIdMap().get(id);
		Object parentObj = NanhuprintThreadLocal.getMetaObjMap().get(parentId);
		if (!(parentObj instanceof Tr)) {
			throw new NanhuprintException("配置错误:输出 pdf 的过程中,发现 (th/td) 的父元素不是 tr, (th/td).id is:" + id);
		}
		if (!cell.hasFixedHeight()) {
			String parentHeight = EvalUtil.getCssAttribute(parentObj, NanhuprintConstant.HEIGHT);
			if (StringUtils.isNotEmpty(parentHeight)) {
				ExplainUtil.addExplain(metaObj, "从父标签 tr 中读取 height 并赋给 cell->" + parentHeight);
				cell.setFixedHeight(EvalUtil.getPrefixFloatValue(parentHeight));
			}
		}
		// 背景颜色,如果 Th/td 没值,读取一下 tr
		String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.BACKGROUND_COLOR);
		if (StringUtils.isEmpty(attributeValue)) {
			String parentValue = EvalUtil.getCssAttribute(parentObj, NanhuprintConstant.BACKGROUND_COLOR);
			if (StringUtils.isNotEmpty(parentValue)) {
				ExplainUtil.addExplain(metaObj, "从父标签 tr 中读取 BACKGROUND_COLOR 并赋给 cell->" + parentValue);
				cell.setBackgroundColor(EvalUtil.getBaseColor(parentValue));
			}
		}
	}

	/**
	 * 将相临的 chunk 元素合并到 Paragraph 中,避免 addElement 的时候,每个 chunk 独占一行
	 * 用两个下标 begin, end 来标识相临的 chunk 元素,合并相临的 chunk 元素
	 * 例如:
	 * div, chunk, div, chunk, chunk, div, chunk
	 * 合并后变成:
	 * div, Paragraph, div, Paragraph, div, Paragraph
	 */
	private static List<Element> mergeNearChunkToParagraph(List<Element> elements) {
		int begin = -1;
		int end = -1;
		List<Element> result = new ArrayList<>();
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i) instanceof Chunk) {
				if ((i - 1) > -1 && !(elements.get(i - 1) instanceof Chunk)) {// 只有在边界时,begin 下标才会移动
					begin = i;
				} else if (i == 0) {
					begin = i;
				}
				end = i;
				if (end == elements.size() - 1) {
					result.add(mergeChunkToParagraph(elements, begin, end));
				}
			} else {
				if (i == end + 1) {
					if (begin > -1) {
						result.add(mergeChunkToParagraph(elements, begin, end));
					}
				}
				result.add(elements.get(i));
			}
		}

		return result;
	}

	/**
	 * 合并相临的 Chunk 成 Paragraph
	 *
	 * @return
	 */
	private static Paragraph mergeChunkToParagraph(List<Element> elements, int begin, int end) {
		Paragraph paragraph = new Paragraph();
		paragraph.addAll(elements.subList(begin, end + 1));
		return paragraph;
	}

	/**
	 * div, 和 th, td 都是解析成 PdfPCell,其添加子元素的逻辑相同,都是要合并子元素中的 chunk 成 Paragraph
	 *
	 * @param metaObj
	 * @param cell
	 * @param childLi
	 * @param env
	 */
	public static void addCellSubElements(Object metaObj, PdfPCell cell, List<Object> childLi, Map<String, Object> env) {
		if (childLi != null && childLi.size() > 0) {
			EvalFactory evalFactory = new EvalFactory();
			List<Element> allChildElements = new ArrayList<>();
			for (Object obj : childLi) {
				IEval evalImplment = evalFactory.routeEval(obj);
				List<Element> elements = evalImplment.evalToPdf(obj, env);
				if (elements != null && elements.size() > 0) {
					allChildElements.addAll(elements);
				}
			}
			// 合并相临的 chunk 成 Paragraph
			List<Element> elementsAfterMerge = EvalUtil.mergeNearChunkToParagraph(allChildElements);
			// 如果直接 addElement,则添加 Paragraph 后,文字的对齐会是基线对齐,因此只有一个 Paragraph 元素时,直接 setPhrase,
			// 如果是多个元素,则生成一个 PdfPCell来包围 Paragraph,继续 setPhrase
			if (elementsAfterMerge.size() == 1 && (elementsAfterMerge.get(0) instanceof Paragraph)) {
				cell.setPhrase((Paragraph) elementsAfterMerge.get(0));
				scaleToFitContent(metaObj, cell);
			} else {
				for (Element element : elementsAfterMerge) {
					if (element instanceof Paragraph) {
						PdfPTable pdfPTable = new PdfPTable(1);
						pdfPTable.setWidthPercentage(100);
						try {
							pdfPTable.setWidths(new float[]{1});
						} catch (DocumentException e) {
							logger.error(e.getMessage(), e);
							throw new NanhuprintException(e);
						}
						PdfPCell pdfPCell = new PdfPCell();
						pdfPCell.setBorderWidth(Rectangle.NO_BORDER);

						// textAlign,需要往父级查找属性
						setCellTextAlign(metaObj, pdfPCell);
						// white-space
						setCellWhiteSpace(metaObj, pdfPCell);
						// line-height,需要往父级查找属性
						setCellLineHeight(metaObj, pdfPCell);

						pdfPCell.setPhrase((Paragraph)element);
						scaleToFitContent(metaObj, cell);

						pdfPTable.addCell(pdfPCell);
						cell.addElement(pdfPTable);
					} else {
						cell.addElement(element);
					}
				}
			}
		}
	}

	/**
	 * 字体逐渐减小以适应表格宽度
	 * @param metaObj
	 * @param cell
	 */
	private static void scaleToFitContent(Object metaObj, PdfPCell cell) {
		String scaleToFitContentByPdf = getValueByReflect(metaObj, NanhuprintConstant.SCALE_TO_FIT_CONTENT_BY_PDF);
		if (StringUtils.isNotEmpty(scaleToFitContentByPdf) && scaleToFitContentByPdf.equalsIgnoreCase(NanhuprintConstant.SCALE_TO_FIT_CONTENT_BY_PDF_VALUE_TRUE)) {
			float width = NanhuprintThreadLocal.getContentWidthMap().get(getValueByReflect(metaObj, NanhuprintConstant.ID));
			if (width > 0) {
				String cellText = cell.getPhrase().getContent();
//				Font font = cell.getPhrase().getFont();// 当文本内容为 6.00% 时,多了一个 % 号,此时,这行代码的返回值,会丢掉 fontStyle,变成不加粗,因此,直接 getChunk,
				Font font = cell.getPhrase().getChunks().get(0).getFont();
				float fontSize = font.getSize();
				if (fontSize == Font.UNDEFINED) {
					fontSize = 20;
				}
				float textWidth = font.getCalculatedBaseFont(true).getWidthPoint(cellText, font.getCalculatedSize());
				boolean needToReset = textWidth > width;
				while(textWidth > width){
//					fontSize--;
					fontSize -= 0.5;// 值越小,越准确
					font = new Font(font);
					font.setSize(fontSize);
					textWidth = font.getCalculatedBaseFont(true).getWidthPoint(cellText, font.getCalculatedSize());

					if (fontSize <= 1) {
						break;
					}
				}
				if (needToReset) {
					ExplainUtil.addExplain(metaObj, "表格宽度为:" + width + ",字体过长,发生了字体赋值减小,减小后字体大小为->" + fontSize);
					cell.setPhrase(new Phrase(cellText, font));
				}
			}
		}
	}

	/**
	 * 设置行高
	 * @param metaObj
	 * @param cell
	 */
	private static void setCellLineHeight(Object metaObj, PdfPCell cell) {
		String attributeValue = EvalUtil.getCssAttributeUp(metaObj, metaObj, NanhuprintConstant.LINE_HEIGHT);
		if (StringUtils.isNotEmpty(attributeValue)) {
            cell.setLeading(EvalUtil.getPrefixFloatValue(attributeValue), 0);
        }
	}

	/**
	 * 设置是否换行
	 * @param metaObj
	 * @param cell
	 */
	private static void setCellWhiteSpace(Object metaObj, PdfPCell cell) {
		String attributeValue = EvalUtil.getCssAttribute(metaObj, NanhuprintConstant.WHITE_SPACE);
		if (StringUtils.isNotEmpty(attributeValue) && attributeValue.equalsIgnoreCase(NanhuprintConstant.WHITE_SPACE_VALUE_NOWRAP)) {
            cell.setNoWrap(true);
        }
	}

	/**
	 * 文字对齐方式
	 * @param metaObj
	 * @param cell
	 */
	private static void setCellTextAlign(Object metaObj, PdfPCell cell) {
		String attributeValue = EvalUtil.getCssAttributeUp(metaObj, metaObj, NanhuprintConstant.TEXT_ALIGN);
		if (StringUtils.isNotEmpty(attributeValue)) {
            if (attributeValue.equalsIgnoreCase(NanhuprintConstant.TEXT_ALIGN_VALUE_LEFT)) {
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            }
            if (attributeValue.equalsIgnoreCase(NanhuprintConstant.TEXT_ALIGN_VALUE_RIGHT)) {
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            }
            if (attributeValue.equalsIgnoreCase(NanhuprintConstant.TEXT_ALIGN_VALUE_CENTER)) {
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            }
        }
	}

	/**
	 * 设置对齐方式
	 *
	 * @param metaObj
	 * @param element
	 */
	public static void setParagraphAlignment(Object metaObj, Paragraph element) {
		String attributeValue = EvalUtil.getCssAttributeUp(metaObj, metaObj, NanhuprintConstant.TEXT_ALIGN);
		if (StringUtils.isNotEmpty(attributeValue)) {
			if (attributeValue.equalsIgnoreCase(NanhuprintConstant.TEXT_ALIGN_VALUE_LEFT)) {
				element.setAlignment(Element.ALIGN_LEFT);
			}
			if (attributeValue.equalsIgnoreCase(NanhuprintConstant.TEXT_ALIGN_VALUE_RIGHT)) {
				element.setAlignment(Element.ALIGN_RIGHT);
			}
			if (attributeValue.equalsIgnoreCase(NanhuprintConstant.TEXT_ALIGN_VALUE_CENTER)) {
				element.setAlignment(Element.ALIGN_CENTER);
			}
		}
	}

	/**
	 * 取得参数值
	 *
	 * @param list
	 * @param key
	 * @return
	 */
	public static String getParamValue(List<Object> list, String key) {
		if (list != null && list.size() > 0) {
			for (Object item : list) {
				if (item instanceof Params) {
					Params params = (Params) item;
					if (params.getParam() != null && params.getParam().size() > 0) {
						for (Param param : params.getParam()) {
							if (StringUtils.isNotEmpty(param.getName()) && param.getName().equalsIgnoreCase(key)) {
								return param.getValue();
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * env 会存一个 nanhuprint_result 的 map, 用来存放程序变量
	 *
	 * @param env
	 * @param key
	 * @param value
	 * @return
	 */
	public static void setValueToNanhuprintEnv(Map<String, Object> env, String key, Object value) {
		Map<String, Object> nanhuprintResultEnv = (Map<String, Object>) env.get(NanhuprintConstant.NANHUPRINT_RESULT_KEY);
		if (nanhuprintResultEnv == null) {
			nanhuprintResultEnv = new HashMap<>();
			// put  一次, 避免传入 JSONObject 会报异常
			nanhuprintResultEnv.put(key, value);
			env.put(NanhuprintConstant.NANHUPRINT_RESULT_KEY, nanhuprintResultEnv);
		} else {
			nanhuprintResultEnv.put(key, value);
		}
	}

	/**
	 * 从 nanhuprint_result 环境变量中取值
	 *
	 * @param env
	 * @param key
	 */
	public static Object getValueFromNanhuprintEnv(Map<String, Object> env, String key) {
		Map<String, Object> nanhuprintResultEnv = (Map<String, Object>) env.get(NanhuprintConstant.NANHUPRINT_RESULT_KEY);
		if (nanhuprintResultEnv == null) {
			return null;
		}
		return nanhuprintResultEnv.get(key);
	}

	/**
	 * 内容自定义的公共代码
	 *
	 * @param metaObj
	 * @param element
	 * @param env
	 */
	public static void commonCustomContent(Object metaObj, Element element, Map<String, Object> env) {
		String customContentText = getParamValue(getChildLi(metaObj), NanhuprintConstant.NANHUPRINT_CUSTOM_CONTENT);
		if (StringUtils.isNotEmpty(customContentText)) {
			ExplainUtil.addExplain(metaObj, "定义了参数 customContent,调用 " + customContentText + " 进行内容自定义");
			try {
				ICustomContent customContent = (ICustomContent) Class.forName(customContentText).newInstance();
				customContent.customContent(metaObj, element, env);
			} catch (InstantiationException e) {
				logger.error("class:" + customContentText + " cause error");
				throw new NanhuprintException(e);
			} catch (IllegalAccessException e) {
				logger.error("class:" + customContentText + " cause error");
				throw new NanhuprintException(e);
			} catch (ClassNotFoundException e) {
				logger.error("class:" + customContentText + " cause error");
				throw new NanhuprintException(e);
			}
		}
	}

	/**
	 * 生成独立的执行环境时,把 formatFunc 给传进去,
	 * @param env
	 * @return
	 */
	public static Map<String, Object> getNestEnv(Map<String, Object> env) {
		Map<String, Object> nestEnv = new HashMap<>();
		if (env.get(NanhuprintConstant.FORMAT_FUNC) != null) {
			nestEnv.put(NanhuprintConstant.FORMAT_FUNC, env.get(NanhuprintConstant.FORMAT_FUNC));
		}
		return nestEnv;
	}

	/**
	 * map -> json
	 * @param env
	 * @return
	 */
	public static String getJsonString(Map<String, Object> env) {
		return JSONObject.fromObject(env, getJsonConfig()).toString();
	}

	/**
	 * 日期的特殊处理 config
	 * @return
	 */
	public static JsonConfig getJsonConfig() {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
			new JsonValueProcessor() {
				public Object processObjectValue(String key, Object value,
												 JsonConfig jsonConfig) {
					return value == null ? "" : ((Date) value).getTime();
				}

				public Object processArrayValue(Object value,
												JsonConfig jsonConfig) {
					return null;
				}
			});
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class,
			new JsonValueProcessor() {
				public Object processObjectValue(String key, Object value,
												 JsonConfig jsonConfig) {
					return value == null ? "" : ((Date) value).getTime();
				}

				public Object processArrayValue(Object value,
												JsonConfig jsonConfig) {
					return null;
				}
			});
		return jsonConfig;
	}
}
