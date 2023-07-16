package com.hongjinqiu.pdfservice.format;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * BigDecimal计算工具类
 *
 * @author xiezm
 */
public class BigDecimalUtils {

    /**
     * 数值BigDecimal 100
     */
    public static final BigDecimal HUNDRED = new BigDecimal(100);

    public BigDecimalUtils() {
        super();
    }

    /**
     * 多个相加
     *
     * @param bigDecimals
     * @return
     */
    public static BigDecimal add(BigDecimal... bigDecimals) {
        BigDecimal result = null;
        for (BigDecimal data : bigDecimals) {
            //第一次进入
            if (result == null) {
                result = data;
            } else {
                result = BigDecimalUtils.add(result, data);
            }
        }
        return result;
    }

    /**
     * number1加number2
     *
     * @param number1
     * @param number2
     * @return
     */
    public static BigDecimal add(BigDecimal number1, BigDecimal number2) {
        number1 = (number1 == null) ? new BigDecimal(0) : number1;
        number2 = (number2 == null) ? new BigDecimal(0) : number2;
        return number1.add(number2);
    }

    /**
     * number1加number2
     *
     * @param number1
     * @param number2
     * @return
     */
    public static BigDecimal add(Object number1, Object number2) {
        return BigDecimalUtils.add((BigDecimal) number1, (BigDecimal) number2);
    }

    /**
     * number1减number2
     *
     * @param number1
     * @param number2
     * @return
     */
    public static BigDecimal sub(BigDecimal number1, BigDecimal number2) {
        number1 = (number1 == null) ? new BigDecimal(0) : number1;
        number2 = (number2 == null) ? new BigDecimal(0) : number2;
        return number1.subtract(number2);
    }

    /**
     * number1减number2
     *
     * @param number1
     * @param number2
     * @return
     */
    public static BigDecimal sub(Object number1, Object number2) {
        return BigDecimalUtils.sub((BigDecimal) number1, (BigDecimal) number2);
    }

    /**
     * number1乘number2
     *
     * @param number1
     * @param number2
     * @return
     */
    public static BigDecimal multiply(BigDecimal number1, BigDecimal number2) {
        return BigDecimalUtils.multiply(number1, number2, true);
    }

    /**
     * number1乘number2
     *
     * @param number1
     * @param number2
     * @param nullIsZero 是否允许number1,number2如果是null就赋值为0
     * @return
     */
    public static BigDecimal multiply(Object number1, Object number2, boolean nullIsZero) {
        BigDecimal bigDecimal1;
        BigDecimal bigDecimal2;
        if (nullIsZero) {
            bigDecimal1 = (number1 == null) ? new BigDecimal(0) : (BigDecimal) number1;
            bigDecimal2 = (number2 == null) ? new BigDecimal(0) : (BigDecimal) number2;
        } else {
            if (null == number1) {
                return null;
            }
            if (null == number2) {
                return null;
            }
            bigDecimal1 = (BigDecimal) number1;
            bigDecimal2 = (BigDecimal) number2;
        }
        return bigDecimal1.multiply(bigDecimal2);
    }

    /**
     * number1除number2(忽略小数位)
     *
     * @param number1
     * @param number2
     * @param power   小数位
     * @return
     */
    public static BigDecimal div(Object number1, Object number2, Integer power) {
        return BigDecimalUtils.div(number1, number2, power, true);
    }

    /**
     * number1除number2(保留小数位)
     *
     * @param number1
     * @param number2
     * @param power      小数位
     * @param nullIsZero 是否允许number1,number2如果是null就赋值为0
     * @return
     */
    public static BigDecimal div(Object number1, Object number2, Integer power, boolean nullIsZero) {
        BigDecimal bigDecimal1;
        BigDecimal bigDecimal2;
        if (nullIsZero) {
            bigDecimal1 = (number1 == null) ? new BigDecimal(0) : (BigDecimal) number1;
            bigDecimal2 = (number2 == null) ? new BigDecimal(0) : (BigDecimal) number2;
        } else {
            if (null == number1) {
                return null;
            }
            if (null == number2) {
                return null;
            }
            bigDecimal1 = (BigDecimal) number1;
            bigDecimal2 = (BigDecimal) number2;
        }
        if (bigDecimal1.compareTo(BigDecimal.ZERO) == 0)
            return BigDecimal.ZERO;
        //被除数不能为0
        if (bigDecimal2.compareTo(BigDecimal.ZERO) == 0)
            return null;
        if (power == null)
            power = 8;
        return bigDecimal1.divide(bigDecimal2, power, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * number1除number2(忽略小数位)
     *
     * @param number1
     * @param number2
     * @return
     */
    public static BigDecimal div(Object number1, Object number2) {
        return BigDecimalUtils.div(number1, number2, true);
    }

    /**
     * number1除number2(忽略小数位)
     *
     * @param number1
     * @param number2
     * @param nullIsZero 是否允许number1,number2如果是null就赋值为0
     * @return
     */
    public static BigDecimal div(Object number1, Object number2, boolean nullIsZero) {
        BigDecimal bigDecimal1;
        BigDecimal bigDecimal2;
        if (nullIsZero) {
            bigDecimal1 = (number1 == null) ? new BigDecimal(0) : (BigDecimal) number1;
            bigDecimal2 = (number2 == null) ? new BigDecimal(0) : (BigDecimal) number2;
        } else {
            if (null == number1) {
                return null;
            }
            if (null == number2) {
                return null;
            }
            bigDecimal1 = (BigDecimal) number1;
            bigDecimal2 = (BigDecimal) number2;
        }
        if (bigDecimal1.compareTo(BigDecimal.ZERO) == 0)
            return BigDecimal.ZERO;
        //被除数不能为0
        if (bigDecimal2.compareTo(BigDecimal.ZERO) == 0)
            return null;
        return bigDecimal1.divide(bigDecimal2);
    }

    /**
     * 绝对值
     *
     * @param number 数值
     * @return
     */
    public static BigDecimal abs(BigDecimal number) {
        return number == null ? BigDecimal.ZERO : number.abs();
    }

    /**
     * 保留 指定小数位 且向上进位的四舍五入
     *
     * @param number    数值
     * @param precision 精度位数
     * @return
     */
    public static BigDecimal round(BigDecimal number, int precision) {
        if (null == number) {
            return null;
        } else {
            return number.setScale(precision, BigDecimal.ROUND_HALF_UP);
        }
    }

    /**
     * 将数据按照给定的保留位数和舍入模式转成字符串
     *
     * @param amt:待格式化的数据
     * @param amount：保留小数位数
     * @param mode：舍入模式（默认四舍五入）
     * @return
     */
    public static String roundFormat(BigDecimal amt, Integer amount, RoundingMode mode) {
        int len = amount == null ? 2 : amount;
        //小数位数
        String str = "";
        while (len != 0) {
            str += "0";
            len--;
        }
        DecimalFormat df = new DecimalFormat("#,##0." + str);
        //舍入模式
        if (null == mode) {
            mode = RoundingMode.HALF_UP;
        }
        df.setRoundingMode(mode);
        if (amt == null) amt = BigDecimal.ZERO;
        return df.format(amt);
    }

}
