package com.hongjinqiu.nanhuprint.eval.custom;

/**
 * 宽度自适应,
 * iText 中的表格,必须要一开始就定义好宽度,不能实现表格宽度随内容自适应,
 * 这个接口先计算一下内容的宽度,再将这个宽度返回给表格,以实现内容自适应,
 * 当前只支持内容为文本的单元格
 * 配置为:
 <td textAlign="right">
	 <params>
		 <param name="calcWidth" value="com.hongjinqiu.nanhuprint.eval.custom.CalcWidth" />
		 <param name="calcWidthTagId" value="leftIssueBy" />
	 </params>
	 <div id="leftIssueBy" cls="f13 bodyLineHeight" whiteSpace="nowrap">
	 	<span value="ISSUED BY:" />
	 </div>
 </td>
 */
public interface ICalcWidth {
	/**
	 * 取得 calcWidthTagId 对应值的目标的字符串宽度
	 * @param metaObj
	 * @return
	 */
	String calcWidth(Object metaObj);
}
