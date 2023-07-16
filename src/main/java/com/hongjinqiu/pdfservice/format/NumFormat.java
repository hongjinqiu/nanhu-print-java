package com.hongjinqiu.pdfservice.format;

import com.hongjinqiu.pdfservice.constant.StringConstant;
import com.hongjinqiu.nanhuprint.eval.format.IFormat;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 数量格式化
 * @author hongjinqiu 2018.08.29
 */
public class NumFormat implements IFormat, Serializable {
	private static final long serialVersionUID = 1L;
	private int number;

	public NumFormat(int number) {
		this.number = number;
	}

	@Override
	public String format(Object value) {
		if (value instanceof BigDecimal) {
			return NumFormatUtil.getFormatAmt((BigDecimal) value, number);
		} else {
			String text = ObjectUtils.toString(value, "");
			if (StringUtils.isNotEmpty(text)) {
				text = text.replace(StringConstant.COMMA, "");
				return NumFormatUtil.getFormatAmt(new BigDecimal(text), number);
			}
		}
		return "";
	}
}
