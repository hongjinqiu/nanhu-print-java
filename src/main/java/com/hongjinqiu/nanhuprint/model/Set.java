//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2023.07.10 时间 04:41:33 PM CST 
//


package com.hongjinqiu.nanhuprint.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;attribute name="var" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="valueJs" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "set")
public class Set {

    @XmlAttribute(name = "var")
    @XmlSchemaType(name = "anySimpleType")
    protected String var;
    @XmlAttribute(name = "valueJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String valueJs;

    /**
     * 获取var属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVar() {
        return var;
    }

    /**
     * 设置var属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVar(String value) {
        this.var = value;
    }

    /**
     * 获取valueJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueJs() {
        return valueJs;
    }

    /**
     * 设置valueJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueJs(String value) {
        this.valueJs = value;
    }

}
