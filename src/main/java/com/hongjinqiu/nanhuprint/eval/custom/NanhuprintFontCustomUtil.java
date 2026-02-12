package com.hongjinqiu.nanhuprint.eval.custom;

import com.hongjinqiu.nanhuprint.NanhuprintException;
import com.hongjinqiu.nanhuprint.NanhuprintThreadLocal;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 南湖打印自定义字体
 * @author hongjinqiu 2023.06.18
 */
public class NanhuprintFontCustomUtil {
    private static Logger logger = Logger.getLogger(NanhuprintFontCustomUtil.class);

    /**
     * 自定义字体列表
     */
    public static final List<ICustomFont> CUSTOM_FONT_LIST = new CopyOnWriteArrayList<>();

    /**
     * 添加字体
     * @param fontFamilyName
     * @param fontPath
     */
    public static void setFontIfAbsent(String fontFamilyName, String fontPath) {
       setFontIfAbsent(fontFamilyName, fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    }

    /**
     * 添加字体
     * @param fontFamilyName
     * @param fontFilePath
     * @param encoding
     * @param embedded
     */
    public static void setFontIfAbsent(String fontFamilyName, String fontFilePath, String encoding, boolean embedded) {
        CUSTOM_FONT_LIST.add(()->{
            if (NanhuprintThreadLocal.getFontMap().get(fontFamilyName) == null) {
                try {
                    Font font = new Font(BaseFont.createFont(fontFilePath, encoding, embedded));
                    NanhuprintThreadLocal.getFontMap().put(fontFamilyName, font);
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                    throw new NanhuprintException(e.getMessage(), e);
                } catch (DocumentException e) {
                    logger.error(e.getMessage(), e);
                    throw new NanhuprintException(e.getMessage(), e);
                }
            }
        });
    }
}
