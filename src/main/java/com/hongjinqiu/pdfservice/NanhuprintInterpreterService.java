package com.hongjinqiu.pdfservice;


import com.hongjinqiu.pdfservice.format.AmtFormat;
import com.hongjinqiu.pdfservice.format.NumFormat;
import com.hongjinqiu.pdfservice.format.UnitPriceFormat;
import com.hongjinqiu.nanhuprint.NanhuprintConstant;
import com.hongjinqiu.nanhuprint.NanhuprintFont;
import com.hongjinqiu.nanhuprint.NanhuprintInterpreter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class NanhuprintInterpreterService {
    private Logger logger = Logger.getLogger(getClass());

    static {
        // 初始化系统资源,字体加载等等
        new NanhuprintFont();
        new NanhuprintInterpreter();
    }

    /**
     * 解析 xml 生成 pdf
     *
     * @param metaString xml字符串
     * @param env
     * @return 字节流
     */
    public byte[] interpreterString(String metaString, Map<String, Object> env) {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        // 放格式化函数
        Map<String, Object> formatFunc = new HashMap<>();
        {
            String amountPrecision = (String) env.get("amountPrecision");
            Integer amount = StringUtils.isBlank(amountPrecision) ? null : Integer.valueOf(amountPrecision);
            formatFunc.put(NanhuprintConstant.FORMAT_FUNC_VALUE_AMT, new AmtFormat(amount));
        }
        {
            String numberPrecision = (String) env.get("numberPrecision");
            Integer number = StringUtils.isBlank(numberPrecision) ? null : Integer.valueOf(numberPrecision);
            formatFunc.put(NanhuprintConstant.FORMAT_FUNC_VALUE_NUM, new NumFormat(number));
        }
        {
            String unitPricePrecision = (String) env.get("unitPricePrecision");
            Integer unitPrice = StringUtils.isBlank(unitPricePrecision) ? null : Integer.valueOf(unitPricePrecision);
            formatFunc.put(NanhuprintConstant.FORMAT_FUNC_VALUE_UNIT_PRICE, new UnitPriceFormat(unitPrice));
        }
        env.put("formatFunc", formatFunc);
        return nanhuprintInterpreter.interpreterString(metaString, env);
    }
}
