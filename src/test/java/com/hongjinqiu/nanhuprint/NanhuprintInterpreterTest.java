package com.hongjinqiu.nanhuprint;

import com.hongjinqiu.nanhuprint.eval.custom.NanhuprintFontCustomUtil;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

public class NanhuprintInterpreterTest {

    @Test
    public void testInterpreterString() throws Exception {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\testInterpreterString.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("testInterpreterString.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("demo.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }

    @Test
    public void testPageNum() throws Exception {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\pageNum.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("pageNum/pageNum.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("pageNum/pageNum.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }

    /**
     * 单页的测试实现
     * @throws Exception
     */
    @Test
    public void testOnePage() throws Exception {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\testOnePage.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("onePage/onePage.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("onePage/onePage.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }

    /**
     * 两页的测试实现
     * twoPage, thead(firstPage, everyPage), tbody, tloop, tbottom(everyPage, lastPage)
     * @throws Exception
     */
    @Test
    public void testTwoPage1() throws Exception {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\testTwoPage1.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("twoPage/twoPage1.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("twoPage/twoPage1.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }

    /**
     * 两页的测试实现
     * twoPage, thead(firstPage), tbody, tloop, tbottom(lastPage)
     * @throws Exception
     */
    @Test
    public void testTwoPage2() throws Exception {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\testTwoPage2.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("twoPage/twoPage2.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("twoPage/twoPage2.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }

    /**
     * 两页的测试实现
     * twoPage, thead(everyPage), tbody, tloop, tbottom(everyPage)
     * @throws Exception
     */
    @Test
    public void testTwoPage3() throws Exception {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\testTwoPage3.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("threePage/threePage3.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("threePage/threePage3.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }

    @Test
    public void testNormal() throws Exception {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\normal.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("normal/normal.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("normal/normal.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }

    @Test
    public void testWaterMark() throws Exception {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\waterMark.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("waterMark/waterMark.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("waterMark/waterMark.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }

    /**
     * 字体自定义测试
     * @throws Exception
     */
    @Test
    public void testFontCustom() throws Exception {
        NanhuprintFontCustomUtil.setFontIfAbsent("arial", "e:\\tmp\\fonts\\ARIALUNI.TTF");
        NanhuprintFontCustomUtil.setFontIfAbsent("times", "e:\\tmp\\fonts\\times.ttf");
        NanhuprintFontCustomUtil.setFontIfAbsent("calibri", "e:\\tmp\\fonts\\calibri.ttf");
        NanhuprintFontCustomUtil.setFontIfAbsent("century", "e:\\tmp\\fonts\\CENTURY.TTF");

        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\fontCustom.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("fontCustom/fontCustom.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("fontCustom/fontCustom.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }

    /**
     * 交替颜色填充
     * @throws Exception
     */
    @Test
    public void testTwoMode() throws Exception {
        NanhuprintInterpreter nanhuprintInterpreter = new NanhuprintInterpreter();
        String filePath = "E:\\hongjinqiu\\tmp\\twoMode.pdf";
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("twoMode/twoMode.json");
             InputStream xmlIn = this.getClass().getClassLoader().getResourceAsStream("twoMode/twoMode.xml")
        ) {
            ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();
            IOUtils.copyLarge(xmlIn, xmlOut);
            String metaString = xmlOut.toString("utf8");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copyLarge(in, out);
            String envJson = out.toString("utf8");

            Map<String, Object> env = JSONObject.fromObject(envJson);
            nanhuprintInterpreter.interpreterString(filePath, metaString, env);
        }
    }
}
