package com.hongjinqiu.pdfservice;


import com.hongjinqiu.nanhuprint.NanhuprintFont;
import com.hongjinqiu.nanhuprint.NanhuprintInterpreter;
import org.apache.log4j.Logger;

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
        return nanhuprintInterpreter.interpreterString(metaString, env);
    }
}
