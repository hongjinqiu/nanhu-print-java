package com.hongjinqiu.nanhuprint;

import com.itextpdf.text.Font;
import com.hongjinqiu.nanhuprint.eval.step.StepEnum;
import com.hongjinqiu.nanhuprint.model.Css;
import com.hongjinqiu.nanhuprint.model.Macro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用 ThreadLocal 来存储全局变量方便程序访问,例如 每个元素的 id,parentId 映射,
 */
public class NanhuprintThreadLocal {
	// id, parentId 值映射 map,
	private static ThreadLocal<Map<String, String>> keyIdValueParentIdMap = new ThreadLocal<>();
	// 解析成 pdf 的过程中,临时保存的 css 元素映射
	private static ThreadLocal<Map<String, Css>> cssMap = new ThreadLocal<>();
	// 第一阶段,动态元素的解析过程中,临时保存的 macro 元素映射
	private static ThreadLocal<Map<String, Macro>> macroMap = new ThreadLocal<>();
	// 解析成 pdf 的过程中,字体的映射
	private static ThreadLocal<Map<String, Font>> fontMap = new ThreadLocal<>();
	// 解析成 pdf 的过程中,提供 id->metaObj 的映射
	private static ThreadLocal<Map<String, Object>> metaObjMap = new ThreadLocal<>();
	// 解析成 pdf 的过程中,提供 id->width 的映射,供内容过短时缩小字体调用,
	private static ThreadLocal<Map<String, Float>> contentWidthMap = new ThreadLocal<>();
	// 记录当前处于哪个阶段
	private static ThreadLocal<StepEnum> stepEnumThreadLocal = new ThreadLocal<>();
	// 记录 explain 信息
	private static ThreadLocal<Map<String, List<String>>> explainMap = new ThreadLocal<>();

	// ================================= 用于性能优化的缓存变量 begin =================================
	// 不缓存的变量名,存 set(var),forEach(var,varStatus),macroRef(paramJs), 以减少 JSONObject.fromObject 的性能消耗
	private static ThreadLocal<List<String>> noCacheParamNames = new ThreadLocal<>();
	// 缓存,对象转 json string 串,以减少 JSONObject.fromObject 的性能消耗
	private static ThreadLocal<Map<Object, String>> cacheObjectJsonString = new ThreadLocal<>();
	// 缓存,缓存标签的属性值,属性值通常会计算两次(ExtendToFillBodyEval 会计算两遍,addThead 会计算多次),比较耗时,
	private static ThreadLocal<Map<String, String>> cssAttributeMap = new ThreadLocal<>();
	// ================================= 用于性能优化的缓存变量 end =================================

	// 存储当前执行环境变量
	private static ThreadLocal<Map<String, Object>> env = new ThreadLocal<>();

	/**
	 * 清值
	 */
	public static void clearAll() {
		clearKeyIdValueParentIdMap();
		clearMacroMap();
		clearCssMap();
		clearFontMap();
		clearMetaObjMap();
		clearContentWidthMap();
		clearStepEnum();
		clearExplainMap();
		clearNoCacheParamNames();
		clearCacheObjectJsonString();
		clearCssAttributeMap();
		clearEnv();
	}

	/**
	 * 从 threadLocal 中获取 id, parentId 的映射 map
	 * @return
	 */
	public static Map<String, String> getKeyIdValueParentIdMap() {
		Map<String, String> map = keyIdValueParentIdMap.get();
		if (map == null) {
			map = new HashMap<>();
			keyIdValueParentIdMap.set(map);
		}
		return map;
	}

	/**
	 * 清值
	 * @return
	 */
	public static void clearKeyIdValueParentIdMap() {
		keyIdValueParentIdMap.set(null);
	}

	/**
	 * 从 threadLocal 中获取 id, contentWidth 的映射 map
	 * @return
	 */
	public static Map<String, Float> getContentWidthMap() {
		Map<String, Float> map = contentWidthMap.get();
		if (map == null) {
			map = new HashMap<>();
			contentWidthMap.set(map);
		}
		return map;
	}

	/**
	 * 清值
	 * @return
	 */
	public static void clearContentWidthMap() {
		contentWidthMap.set(null);
	}

	/**
	 * 赋值
	 */
	public static void setStepEnum(StepEnum stepEnum) {
		stepEnumThreadLocal.set(stepEnum);
	}

	/**
	 * 取值
	 * @return
	 */
	public static StepEnum getStepEnum() {
		return stepEnumThreadLocal.get();
	}

	/**
	 * 清值
	 */
	public static void clearStepEnum() {
		stepEnumThreadLocal.set(null);
	}

	/**
	 * 从 threadLocal 中获取 explain 信息
	 * @return
	 */
	public static Map<String, List<String>> getExplainMap() {
		Map<String, List<String>> map = explainMap.get();
		if (map == null) {
			map = new HashMap<>();
			explainMap.set(map);
		}
		return map;
	}

	/**
	 * 取得某个 tag 的 explain list
	 * @param tagId
	 * @return
	 */
	public static List<String> getExplainList(String tagId) {
		Map<String, List<String>> map = getExplainMap();
		if (map.get(tagId) == null) {
			map.put(tagId, new ArrayList<String>());
		}
		return map.get(tagId);
	}

	/**
	 * 清值
	 */
	public static void clearExplainMap() {
		explainMap.set(null);
	}

	/**
	 * 从 threadLocal 中获取 css 的元素映射
	 * @return
	 */
	public static Map<String, Css> getCssMap() {
		Map<String, Css> map = cssMap.get();
		if (map == null) {
			map = new HashMap<>();
			cssMap.set(map);
		}
		return map;
	}

	/**
	 * 清值
	 */
	public static void clearCssMap() {
		cssMap.set(null);
	}

	/**
	 * 从 threadLocal 中获取 macro 的元素映射
	 * @return
	 */
	public static Map<String, Macro> getMacroMap() {
		Map<String, Macro> map = macroMap.get();
		if (map == null) {
			map = new HashMap<>();
			macroMap.set(map);
		}
		return map;
	}

	/**
	 * 清值
	 */
	public static void clearMacroMap() {
		macroMap.set(null);
	}

	/**
	 * 从 threadLocal 中获取 font 的元素映射
	 * @return
	 */
	public static Map<String, Font> getFontMap() {
		Map<String, Font> map = fontMap.get();
		if (map == null) {
			map = new HashMap<>();
			fontMap.set(map);
		}
		return map;
	}

	/**
	 * 清值
	 */
	public static void clearFontMap() {
		fontMap.set(null);
	}

	/**
	 * 从 threadLocal 中获取 metaObj 的元素映射
	 * @return
	 */
	public static Map<String, Object> getMetaObjMap() {
		Map<String, Object> map = metaObjMap.get();
		if (map == null) {
			map = new HashMap<>();
			metaObjMap.set(map);
		}
		return map;
	}

	/**
	 * 清值
	 */
	public static void clearMetaObjMap() {
		metaObjMap.set(null);
	}

	/**
	 * 从 threadLocal 中获取 noCacheParamNames
	 * @return
	 */
	public static List<String> getNoCacheParamNames() {
		List<String> list = noCacheParamNames.get();
		if (list == null) {
			list = new ArrayList<>();
			noCacheParamNames.set(list);
		}
		return list;
	}

	/**
	 * 清值
	 */
	public static void clearNoCacheParamNames() {
		noCacheParamNames.set(null);
	}

	/**
	 * 从 threadLocal 中获取 cacheObjectJsonString
	 * @return
	 */
	public static Map<Object, String> getCacheObjectJsonString() {
		Map<Object, String> map = cacheObjectJsonString.get();
		if (map == null) {
			map = new HashMap<>();
			cacheObjectJsonString.set(map);
		}
		return map;
	}

	/**
	 * 清值
	 */
	public static void clearCacheObjectJsonString() {
		cacheObjectJsonString.set(null);
	}

	/**
	 * 从 threadLocal 中获取 cssAttributeMap
	 * @return
	 */
	public static Map<String, String> getCssAttributeMap() {
		Map<String, String> map = cssAttributeMap.get();
		if (map == null) {
			map = new HashMap<>();
			cssAttributeMap.set(map);
		}
		return map;
	}

	/**
	 * 清值
	 */
	public static void clearCssAttributeMap() {
		cssAttributeMap.set(null);
	}

	/**
	 * 从 threadLocal 中获取 env
	 * @return
	 */
	public static Map<String, Object> getEnv() {
		return env.get();
	}

	/**
	 * 设置 env
	 */
	public static void setEnv(Map<String, Object> envMap) {
		env.set(envMap);
	}

	/**
	 * 清值
	 */
	public static void clearEnv() {
		env.set(null);
	}
}
