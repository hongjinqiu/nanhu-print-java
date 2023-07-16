//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2023.07.10 时间 04:41:33 PM CST 
//


package com.hongjinqiu.nanhuprint.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{https://github.com/hongjinqiu/nanhu-print-java}style" minOccurs="0"/>
 *         &lt;element ref="{https://github.com/hongjinqiu/nanhu-print-java}macros" minOccurs="0"/>
 *         &lt;element ref="{https://github.com/hongjinqiu/nanhu-print-java}body" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "style",
    "macros",
    "body"
})
@XmlRootElement(name = "html")
public class Html {

    protected Style style;
    protected Macros macros;
    protected Body body;

    /**
     * 获取style属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Style }
     *     
     */
    public Style getStyle() {
        return style;
    }

    /**
     * 设置style属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Style }
     *     
     */
    public void setStyle(Style value) {
        this.style = value;
    }

    /**
     * 获取macros属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Macros }
     *     
     */
    public Macros getMacros() {
        return macros;
    }

    /**
     * 设置macros属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Macros }
     *     
     */
    public void setMacros(Macros value) {
        this.macros = value;
    }

    /**
     * 获取body属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Body }
     *     
     */
    public Body getBody() {
        return body;
    }

    /**
     * 设置body属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Body }
     *     
     */
    public void setBody(Body value) {
        this.body = value;
    }

}
