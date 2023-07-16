//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2023.07.10 时间 04:41:33 PM CST 
//


package com.hongjinqiu.nanhuprint.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;group ref="{https://github.com/hongjinqiu/nanhu-print-java}all-dynamic-element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{https://github.com/hongjinqiu/nanhu-print-java}params" minOccurs="0"/>
 *         &lt;element ref="{https://github.com/hongjinqiu/nanhu-print-java}tr" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="countJs" type="{http://www.w3.org/2001/XMLSchema}int" default="1" />
 *       &lt;attribute name="mode">
 *         &lt;simpleType>
 *           &lt;union>
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                 &lt;enumeration value="one"/>
 *                 &lt;enumeration value="two"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                 &lt;pattern value="js:.+"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/union>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ifAndForEachAndSet"
})
@XmlRootElement(name = "tloop")
public class Tloop {

    @XmlElements({
        @XmlElement(name = "if", type = If.class),
        @XmlElement(name = "forEach", type = ForEach.class),
        @XmlElement(name = "set", type = Set.class),
        @XmlElement(name = "macroRef", type = MacroRef.class),
        @XmlElement(name = "params", type = Params.class),
        @XmlElement(name = "tr", type = Tr.class)
    })
    protected List<Object> ifAndForEachAndSet;
    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "countJs")
    protected Integer countJs;
    @XmlAttribute(name = "mode")
    protected String mode;

    /**
     * Gets the value of the ifAndForEachAndSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ifAndForEachAndSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIfAndForEachAndSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link If }
     * {@link ForEach }
     * {@link Set }
     * {@link MacroRef }
     * {@link Params }
     * {@link Tr }
     * 
     * 
     */
    public List<Object> getIfAndForEachAndSet() {
        if (ifAndForEachAndSet == null) {
            ifAndForEachAndSet = new ArrayList<Object>();
        }
        return this.ifAndForEachAndSet;
    }

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * 获取countJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getCountJs() {
        if (countJs == null) {
            return  1;
        } else {
            return countJs;
        }
    }

    /**
     * 设置countJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCountJs(Integer value) {
        this.countJs = value;
    }

    /**
     * 获取mode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMode() {
        return mode;
    }

    /**
     * 设置mode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMode(String value) {
        this.mode = value;
    }

}
