package com.hongjinqiu.nanhuprint;

import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采用 js 作为表达式解析语法
 *
 * @author hongjinqiu 2018.08.03
 */
public class NanhuprintExpressionEvaluator {
	private Logger logger = Logger.getLogger(this.getClass());
	private static final ScriptEngineManager manager = new ScriptEngineManager();
	private static final ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");

	/**
	 * 表达式解析,js 语法,
	 * 这种直接的方式,在解析 map 时,不能采用点语法,因此,修改成拼字符串的方式,
	 * {
	 Map<String, Object> obj = new HashMap<>();
	 obj.put("name", "testMacro");
	 obj.put("age", 23);
	 env.put("obj", obj);
	 }
	 此时 obj.name 会报错, 要用 obj.get("name") 比较麻烦,因此,采用下面的拼字符串的方式,变相支持点语法
	 * @param expression
	 * @param env
	 * @return
	 */
	/*
	public Object eval(String expression, Map<String, Object> env) {
		ScriptEngine engine = getJavaScriptEngine();
		Bindings bindings = new SimpleBindings();
		bindings.putAll(env);
		try {
			return engine.eval(expression, bindings);
		} catch (ScriptException e) {
			throw new NanhuprintException(e);
		}
	}
*/

	/**
	 * 表达式解析,js 语法,采用拼字符串的方式,变相支持点语法
	 * 字符串最后一般长这样
	 * function tmpF(){var testString="\"testString\"";var macroObj={"age":23,"name":"\"testMacro\"","loopLi":[{"age":1,"name":"loop1"},{"age":2,"name":"\"loop2"}]};return [5,6,7];}tmpF()
	 *
	 * @param expression
	 * @param env
	 * @return
	 */
	public Object eval(String expression, Map<String, Object> env) {
		if (expression != null && expression.equals("")) {
			return "";
		}
		JsonConfig jsonConfig = getJsonConfig();
		ScriptEngine engine = getJavaScriptEngine();
		StringBuilder functionString = new StringBuilder();
		functionString.append("function tmpF(){");
		for (String key : env.keySet()) {
			if (key != null && key.equals(NanhuprintConstant.NANHUPRINT_OUTER)) {// 外部环境变量不需要拼到 functionString 中
				continue;
			}
			String value;
			Object valueObj = env.get(key);
			if (valueObj == null) {
				value = "null";
			} else {
				if (valueObj instanceof List) {
					// 在转 java.sql.Date 时会报错,因此用一个 JsonConfig 来转值,
//					Caused by: java.lang.IllegalArgumentException: null,at java.sql.Date.getHours(Date.java:182)
//					value = JSONArray.fromObject(valueObj).toString();
					// 从缓存中获取值,以减小 fromObject 的性能消耗
					if (NanhuprintThreadLocal.getNoCacheParamNames().contains(key)) {
						value = JSONArray.fromObject(valueObj, jsonConfig).toString();
					} else {
						value = NanhuprintThreadLocal.getCacheObjectJsonString().get(valueObj);
						if (value == null) {
							value = JSONArray.fromObject(valueObj, jsonConfig).toString();
							NanhuprintThreadLocal.getCacheObjectJsonString().put(valueObj, value);
						}
					}
				} else {
					if (valueObj instanceof Boolean) {
						value = ((Boolean) valueObj) ? "true" : "false";
					} else if (valueObj instanceof Number) {
						value = valueObj.toString();
					} else if (valueObj instanceof String) {
						value = "\"" + ((String) valueObj).replaceAll("\"", "\\\\\"") + "\"";
					} else {
						// 从缓存中获取值,以减小 fromObject 的性能消耗
						if (NanhuprintThreadLocal.getNoCacheParamNames().contains(key)) {
							value = JSONObject.fromObject(valueObj, jsonConfig).toString();
						} else {
							value = NanhuprintThreadLocal.getCacheObjectJsonString().get(valueObj);
							if (value == null) {
								value = JSONObject.fromObject(valueObj, jsonConfig).toString();
								NanhuprintThreadLocal.getCacheObjectJsonString().put(valueObj, value);
							}
						}
					}
				}
			}
			if (key != null) {// key 有可能为空,比如 forEach 标签 varStatus 放空,此时,会设 null 进来,
				functionString.append("var {key}={value};".replace("{key}", key).replace("{value}", value));
			}
		}
		functionString.append("return " + expression + ";");
		functionString.append("}tmpF()");
		logger.debug(functionString);
		try {
			ScriptContext scriptContext = new SimpleScriptContext();
			Object result = engine.eval(functionString.toString(), scriptContext);
			return convert(result);
		} catch (ScriptException e) {
			logger.error("eval function is:" + functionString);
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		}
	}

	/**
	 * 将 ScriptObjectMirror 转为 java object
	 * 1.scriptObjectMirror -> []
	 * 2.scriptObjectMirror -> {}
	 * @param evalObj
	 * @return
	 */
	private Object convert(Object evalObj) {
		if (evalObj == null) {
			return evalObj;
		}
		if (evalObj instanceof ScriptObjectMirror) {
			ScriptObjectMirror scriptObjectMirror = (ScriptObjectMirror)evalObj;
			if (scriptObjectMirror.isArray()) {
				List<Object> result = new ArrayList<>();
				for (int i = 0; i < scriptObjectMirror.size(); i++) {
					result.add(convert(scriptObjectMirror.getSlot(i)));
				}
				return result;
			} else {
				Map<String, Object> result = new HashMap<>();
				for (Map.Entry<String, Object> entry: scriptObjectMirror.entrySet()) {
					result.put(entry.getKey(), convert(entry.getValue()));
				}
				return result;
			}
		} else {
			return evalObj;
		}
	}

	/**
	 * 日期的特殊处理 config
	 *
	 * @return
	 */
	private JsonConfig getJsonConfig() {
		return EvalUtil.getJsonConfig();
	}


	/**
	 * 取得 js 脚本解析引擎
	 *
	 * @return
	 */
	private ScriptEngine getJavaScriptEngine() {
//		ScriptEngineManager manager = new ScriptEngineManager();// 用static 私有变量,来性能优化
//		return manager.getEngineByName("JavaScript");
		return scriptEngine;
	}

}
