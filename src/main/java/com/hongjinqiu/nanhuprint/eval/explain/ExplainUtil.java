package com.hongjinqiu.nanhuprint.eval.explain;

import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.hongjinqiu.nanhuprint.eval.EvalUtil;
import com.hongjinqiu.nanhuprint.model.Body;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 记录解析过程中的说明性文字,
 * 格式类似于:
 * ===================== div(id:) explain begin =====================
 tagName:div,渲染成只包括一个单元格的 PdfPTable,
 id->属性->leftIssueBy
 cls->属性->f13 bodyLineHeight
 borderLeftWidth->样式bodyLineHeight->xxxxx,
 ===================== div(id:) explain end =====================
 @author hongjinqiu 2018.08.24
 */
public class ExplainUtil {
	/**
	 * 添加 explain 信息
	 * @param metaObj
	 * @param message
	 */
	public static void addExplain(Object metaObj, String message) {
		if (EvalUtil.hasField(metaObj, NanhuprintConstant.EXPLAIN)) {
			String explain = EvalUtil.getValueByReflect(metaObj, NanhuprintConstant.EXPLAIN);
			if (StringUtils.isNotEmpty(explain) && explain.equalsIgnoreCase(NanhuprintConstant.EXPLAIN_VALUE_TRUE)) {
				String tagId = EvalUtil.getValueByReflect(metaObj, NanhuprintConstant.ID);
				List<String> explainList = NanhuprintThreadLocal.getExplainList(tagId);
				explainList.add(message);
			}
		}
	}

	/**
	 * 输出对应的 explain 内容
	 * @param tagId
	 */
	public static void outputExplain(String tagId) {
		List<String> list = NanhuprintThreadLocal.getExplainList(tagId);
		if (list.size() > 0) {
			System.out.println(StringUtils.join(list.toArray(), "\n"));
		}
	}
}
