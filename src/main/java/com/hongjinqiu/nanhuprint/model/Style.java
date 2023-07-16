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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;group ref="{https://github.com/hongjinqiu/nanhu-print-java}all-dynamic-element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{https://github.com/hongjinqiu/nanhu-print-java}css" maxOccurs="unbounded" minOccurs="0"/>
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
    "ifAndForEachAndSet"
})
@XmlRootElement(name = "style")
public class Style {

    @XmlElements({
        @XmlElement(name = "if", type = If.class),
        @XmlElement(name = "forEach", type = ForEach.class),
        @XmlElement(name = "set", type = Set.class),
        @XmlElement(name = "macroRef", type = MacroRef.class),
        @XmlElement(name = "css", type = Css.class)
    })
    protected List<Object> ifAndForEachAndSet;

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
     * {@link Css }
     * 
     * 
     */
    public List<Object> getIfAndForEachAndSet() {
        if (ifAndForEachAndSet == null) {
            ifAndForEachAndSet = new ArrayList<Object>();
        }
        return this.ifAndForEachAndSet;
    }

}
