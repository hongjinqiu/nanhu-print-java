package com.hongjinqiu.nanhuprint;

import com.hongjinqiu.nanhuprint.eval.EvalFactory;
import com.hongjinqiu.nanhuprint.eval.HtmlEval;
import com.hongjinqiu.nanhuprint.eval.IEval;
import com.hongjinqiu.nanhuprint.model.Html;
import com.hongjinqiu.pdfservice.format.AmtFormat;
import com.hongjinqiu.pdfservice.format.NumFormat;
import com.hongjinqiu.pdfservice.format.UnitPriceFormat;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 解释器,将 xml 映射后的 object
 * 1.解释所有的 if,forEach,set 等动态标签,解释所有的spring el 表达式,取得 xml,
 * 2.解释所有的 xml 元素,取得 html
 *
 * @author hongjinqiu add 2018.08.02
 */
public class NanhuprintInterpreter {
	private Logger logger = Logger.getLogger(this.getClass());
	private static Class[] classes = new Class[]{com.hongjinqiu.nanhuprint.model.ObjectFactory.class};
	private static JAXBContext context;

	static {
		try {
			context = JAXBContext.newInstance(classes);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new NanhuprintException(e);
		}
	}

	/**
	 * 1.解释所有的 if,forEach,set 等动态标签,解释所有的spring el 表达式,取得 xml,
	 * @param html
	 * @param env
	 * @return
	 */
	public String runDynamicElement(Html html, Map<String, Object> env) {
		if (env == null) {
			throw new NanhuprintException("env can't be null");
		}
		env = converToHashMapIfNot(env);
		EvalFactory evalFactory = new EvalFactory();
		NanhuprintExpressionEvaluator expressionEvaluator = new NanhuprintExpressionEvaluator();
		IEval evalImplment = evalFactory.routeEval(html);
		String result = evalImplment.evalDynamicElement(html, env, expressionEvaluator);
		return result;
	}

	/**
	 * 1.解释所有的 if,forEach,set 等动态标签,解释所有的spring el 表达式,取得 xml,
	 *
	 * @param metaString
	 * @param env
	 * @return
	 */
	public String unmarshallerAndRunDynamicElement(String metaString, Map<String, Object> env) {
		if (env == null) {
			throw new NanhuprintException("env can't be null");
		}
		env = converToHashMapIfNot(env);
		Html html = unmarshallerToHtml(metaString);
		if (html != null) {
			return runDynamicElement(html, env);
		}
		return null;
	}

	/**
	 * xml 字符串映射转实体
	 * @param metaString
	 * @return
	 */
	private Html unmarshallerToHtml(String metaString) {
		logger.debug("unmarshallerToHtml, xml is:" + metaString);
		Unmarshaller u = null;
		Html html = null;
		InputStream in = null;
		try {
			u = context.createUnmarshaller();
			in = new ByteArrayInputStream(metaString.getBytes("UTF-8"));
			html = (Html) u.unmarshal(in);
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		} catch (UnsupportedEncodingException e2) {
			logger.error(e2.getMessage(), e2);
			throw new NanhuprintException(e2);
		} finally {
			IOUtils.closeQuietly(in);
		}
		return html;
	}

	/**
	 * 2.将 xml 元素解析并输出 pdf,
	 * @param filePath
	 * @param html
	 * @param env
	 * @return
	 */
	public void runToPdf(String filePath, Html html, Map<String, Object> env) {
		env = converToHashMapIfNot(env);
		EvalFactory evalFactory = new EvalFactory();
		IEval evalImplment = evalFactory.routeEval(html);
		((HtmlEval)evalImplment).evalToPdf(filePath, html, env);

		/*
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath);

			Document document = (Document)element;
			// pdf写入对象
			PdfWriter pdfWrite = PdfWriter.getInstance(document, out);
//			pdfWrite.close();
			document.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new NanhuprintException(e);
		} finally {
			IOUtils.closeQuietly(out);
		}*/
	}

	/**
	 * 2.将 xml 元素解析并输出 pdf,
	 * @param html
	 * @param env
	 * @return
	 */
	public byte[] runToPdf(Html html, Map<String, Object> env) {
		env = converToHashMapIfNot(env);
		EvalFactory evalFactory = new EvalFactory();
		IEval evalImplment = evalFactory.routeEval(html);
		return ((HtmlEval)evalImplment).evalToPdfByte(html, env);
	}

	/**
	 * 2. 动态标签解析,并且 js 属性赋值后,输出 pdf 内容,
	 * @param filePath
	 * @param metaString
	 * @param env
	 * @return
	 */
	public void unmarshallerAndRunToPdf(String filePath, String metaString, Map<String, Object> env){
		env = converToHashMapIfNot(env);
		Html html = unmarshallerToHtml(metaString);
		runToPdf(filePath, html, env);
	}

	/**
	 * 2. 动态标签解析,并且 js 属性赋值后,输出 pdf 内容,
	 * @param metaString
	 * @param env
	 * @return
	 */
	public byte[] unmarshallerAndRunToPdf(String metaString, Map<String, Object> env){
		env = converToHashMapIfNot(env);
		Html html = unmarshallerToHtml(metaString);
		return runToPdf(html, env);
	}

	/**
	 * 传入 xml 格式字符串,解析生成 pdf
	 * @param filePath
	 * @param metaString
	 * @param env
	 * @return
	 */
	public void interpreterString(String filePath, String metaString, Map<String, Object> env){
		env = converToHashMapIfNot(env);
		long begin = System.currentTimeMillis();
		setFormatFunc(env);
		String xmlString = unmarshallerAndRunDynamicElement(metaString, env);
		unmarshallerAndRunToPdf(filePath, xmlString, env);
		long end = System.currentTimeMillis();
		System.out.println("time spend of interpreterString(fielPath) is:" + (end - begin));
	}

	/**
	 * 传入 xml 格式字符串,解析生成 pdf
	 * @param metaString
	 * @param env
	 */
	public byte[] interpreterString(String metaString, Map<String, Object> env){
		env = converToHashMapIfNot(env);
		long begin = System.currentTimeMillis();
		setFormatFunc(env);
		String xmlString = unmarshallerAndRunDynamicElement(metaString, env);
		logger.info("xmlString is:" + xmlString);
		byte[] result = unmarshallerAndRunToPdf(xmlString, env);
		long end = System.currentTimeMillis();
		System.out.println("time spend of interpreterString return byte is:" + (end - begin));
		return result;
	}

	/**
	 * 设置格式化字符串
	 * @param env
	 */
	private void setFormatFunc(Map<String, Object> env) {
		Map<String, Object> formatFunc = new HashMap<>();
		{
			String amountPrecision = (String) env.get("amountPrecision");
			Integer amount = StringUtils.isBlank(amountPrecision) ? 2 : Integer.valueOf(amountPrecision);
			formatFunc.put(NanhuprintConstant.FORMAT_FUNC_VALUE_AMT, new AmtFormat(amount));
		}
		{
			String numberPrecision = (String) env.get("numberPrecision");
			Integer number = StringUtils.isBlank(numberPrecision) ? 0 : Integer.valueOf(numberPrecision);
			formatFunc.put(NanhuprintConstant.FORMAT_FUNC_VALUE_NUM, new NumFormat(number));
		}
		{
			String unitPricePrecision = (String) env.get("unitPricePrecision");
			Integer unitPrice = StringUtils.isBlank(unitPricePrecision) ? 2 : Integer.valueOf(unitPricePrecision);
			formatFunc.put(NanhuprintConstant.FORMAT_FUNC_VALUE_UNIT_PRICE, new UnitPriceFormat(unitPrice));
		}
		env.put("formatFunc", formatFunc);
	}

	/**
	 * the env may by JSONObject, convert to HashMap, because will put formatFunc behind
	 * @param env
	 * @return
	 */
	private Map<String, Object> converToHashMapIfNot(Map<String, Object> env) {
		if ((env != null) && (!env.getClass().getSimpleName().endsWith("HashMap"))) {
			Map<String, Object> result = new HashMap<>(env);
			return result;
		}
		return env;
	}

	//public static void main(String[] args) {
//		if (true) {
//			expressionTest();
//			BigDecimal d = new BigDecimal("4433333333.1415926");
//			System.out.println(d);
//			String text = "\"test\"";
//			System.out.println(text);
//			String value = "\"" + ((String) text).replaceAll("\"", "\\\\\"") + "\"";
//			System.out.println("var ddd={value}".replace("{value}", value));
//			return;
//		}
//		testDynamicElement();
//		testPdf();
//		testIText();
//	}
}