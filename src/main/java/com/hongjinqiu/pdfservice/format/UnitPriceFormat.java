package com.hongjinqiu.pdfservice.format;

import com.hongjinqiu.pdfservice.constant.StringConstant;
import com.hongjinqiu.nanhuprint.eval.format.IFormat;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 单价格式化
 * @author hongjinqiu 2018.08.29
 */
public class UnitPriceFormat implements IFormat, Serializable {
	private static final long serialVersionUID = 1L;
	private int unitPrice;

	public UnitPriceFormat(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String format(Object value) {
		if (value instanceof BigDecimal) {
			return NumFormatUtil.getFormatAmt((BigDecimal) value, unitPrice);
		} else {
			String text = ObjectUtils.toString(value, "");
			if (StringUtils.isNotEmpty(text)) {
				text = text.replace(StringConstant.COMMA, "");
				return NumFormatUtil.getFormatAmt(new BigDecimal(text), unitPrice);
			}
		}
		return "";
	}
}
