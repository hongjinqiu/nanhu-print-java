package com.hongjinqiu.nanhuprint.eval;

import com.lowagie.text.Element;
import com.hongjinqiu.nanhuprint.NanhuprintExpressionEvaluator;

import java.util.List;
import java.util.Map;

/**
 * 解析的接口
 * @author hongjinqiu 2018.08.03
 */
public interface IEval {
	/**
	 * 解析所有的 if,forEach,set,spring el 等动态标签,生成 xml,
	 * @param metaObj
	 * @param env
	 * @param expressionEvaluator
	 * @return
	 */
	String evalDynamicElement(Object metaObj, Map<String, Object> env, NanhuprintExpressionEvaluator expressionEvaluator);

	/**
	 * 给 html 标签添加 id, parentId,
	 * if, forEach, set 等标签不需要,
	 * @param metaObj
	 * @param parentObj
	 */
	void setIdAndParentId(Object metaObj, Object parentObj);

	/**
	 * 往 ThreadLocal 中放 id:width 的标识
	 * int[][] rowColumnFlag = [
			 [0,0,0],
			 [0,0,0],
			 [0,0,0],
			 [0,0,0],
		 ]
	 表示 4行 3 列,
	 其底下的单元格为:
	 [单元格1(占1列)],[单元格2(占1列)],[单元格3(占1列)],
	 [单元格4(占2行2列)],[单元格4占领],[单元格5(占1列)],
	 [单元格4占领],[单元格4占领],[单元格6(占1列)],
	 [单元格7(占1行2列)],[单元格7占领],[单元格8(占1列)],

	 则当运行到 [单元格5] 时,
	 rowColumnFlag = [
		 [1,1,1],
		 [1,1,0],
		 [1,1,0],
		 [0,0,0],
	 ]
	 此时,便可知道[单元格5]的下标为:第二行,第三列,宽度应该取 absoluteWidths[3]

	 * @param metaObj
	 * @param absoluteWidths 如果 metaObj 是td,则 absoluteWidths 为每一个单元格的宽度,
	 * @param rowColumnFlag 表格的行列标识,表示当前这个 td 占了几行,几列,宽度需要累加几格
	 */
	void setContentWidth(Object metaObj, float[] absoluteWidths, int[][] rowColumnFlag);

	/**
	 * 2.将 xml 元素解析并输出 pdf,
	 * @param metaObj
	 * @param env
	 * @return
	 */
	List<Element> evalToPdf(Object metaObj, Map<String, Object> env);

	/**
	 * 2.将 xml 元素解析并输出 pdf,
	 * @param metaObj
	 * @param env
	 * @return
	 */
//	byte[] evalToPdfByte(Object metaObj, Map<String, Object> env);

	/**
	 * 往 threadLocal 中放 {id: font},方便 pdf 渲染时引用
	 * @param metaObj
	 */
	void setFontToMap(Object metaObj);

	/**
	 * 给 html 标签添加 id -> metaObj 的关联映射,方便查找
	 * if, forEach, set 等标签不需要,
	 * @param metaObj
	 */
	void setIdAndMetaObj(Object metaObj);
}
