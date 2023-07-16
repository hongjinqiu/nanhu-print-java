package com.hongjinqiu.pdfservice.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 报表等对数据的格式化工具类
 */
public class NumFormatUtil {

	/**
	 * 获取百分比（没有参数设置 程序固定2位小数）
	 * @param amt
	 * @return
	 */
	public static String getPercent(BigDecimal amt) {
		BigDecimal tmpAmt = amt;
		DecimalFormat df2 = new DecimalFormat("#,##0.00");
		if(tmpAmt == null) {
			tmpAmt = BigDecimal.ZERO;
		}
		tmpAmt = BigDecimalUtils.multiply(tmpAmt, new BigDecimal("100"));
		return df2.format(tmpAmt) + "%";
	}

	/**
	 * 根据参数设置数据数据格式（单价和数量）
	 * @param amt
	 * @param amount 保留小数位数
	 * @return
	 */
	public static String getFormatAmt(BigDecimal amt, Integer amount) {
		DecimalFormat decimalFormat;
		int length = amount == null ? 2 : amount;
		if (length == 0) {
			decimalFormat = new DecimalFormat("#,###");
		}else {
			//小数位数
			StringBuilder sb = new StringBuilder();
			while (length!=0){
				sb.append("0");
				length--;
			}
			String str = sb.toString();
			decimalFormat = new DecimalFormat("#,##0."+str);
		}
		BigDecimal tmpAmt = amt;
		if(null == tmpAmt ) {
			tmpAmt = BigDecimal.ZERO;
		}
		return decimalFormat.format(tmpAmt);
	}


}
