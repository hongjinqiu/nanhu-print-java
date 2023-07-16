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
 *         &lt;group ref="{https://github.com/hongjinqiu/nanhu-print-java}all-body-element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{https://github.com/hongjinqiu/nanhu-print-java}all-dynamic-element" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="paramJs" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "widthAndHeightAndPaddingLeft"
})
@XmlRootElement(name = "macro")
public class Macro {

    @XmlElements({
        @XmlElement(name = "width", type = Macro.Width.class),
        @XmlElement(name = "height", type = Macro.Height.class),
        @XmlElement(name = "paddingLeft", type = Macro.PaddingLeft.class),
        @XmlElement(name = "paddingTop", type = Macro.PaddingTop.class),
        @XmlElement(name = "paddingRight", type = Macro.PaddingRight.class),
        @XmlElement(name = "paddingBottom", type = Macro.PaddingBottom.class),
        @XmlElement(name = "marginLeftByJs", type = Macro.MarginLeftByJs.class),
        @XmlElement(name = "marginTopByJs", type = Macro.MarginTopByJs.class),
        @XmlElement(name = "marginRightByJs", type = Macro.MarginRightByJs.class),
        @XmlElement(name = "marginBottomByJs", type = Macro.MarginBottomByJs.class),
        @XmlElement(name = "fontFamily", type = Macro.FontFamily.class),
        @XmlElement(name = "fontStyle", type = Macro.FontStyle.class),
        @XmlElement(name = "fontWeight", type = Macro.FontWeight.class),
        @XmlElement(name = "textDecoration", type = Macro.TextDecoration.class),
        @XmlElement(name = "borderCollapse", type = Macro.BorderCollapse.class),
        @XmlElement(name = "borderSpacing", type = Macro.BorderSpacing.class),
        @XmlElement(name = "tableLayout", type = Macro.TableLayout.class),
        @XmlElement(name = "textAlign", type = Macro.TextAlign.class),
        @XmlElement(name = "whiteSpace", type = Macro.WhiteSpace.class),
        @XmlElement(name = "wordWrap", type = Macro.WordWrap.class),
        @XmlElement(name = "display", type = Macro.Display.class),
        @XmlElement(name = "visibility", type = Macro.Visibility.class),
        @XmlElement(name = "clear", type = Macro.Clear.class),
        @XmlElement(name = "zoom", type = Macro.Zoom.class),
        @XmlElement(name = "floatAlign", type = Macro.FloatAlign.class),
        @XmlElement(name = "fontSize", type = Macro.FontSize.class),
        @XmlElement(name = "webkitBoxSizing", type = Macro.WebkitBoxSizing.class),
        @XmlElement(name = "mozBoxSizing", type = Macro.MozBoxSizing.class),
        @XmlElement(name = "boxSizing", type = Macro.BoxSizing.class),
        @XmlElement(name = "minHeight", type = Macro.MinHeight.class),
        @XmlElement(name = "position", type = Macro.Position.class),
        @XmlElement(name = "lineHeight", type = Macro.LineHeight.class),
        @XmlElement(name = "color", type = Macro.Color.class),
        @XmlElement(name = "borderTopWidth", type = Macro.BorderTopWidth.class),
        @XmlElement(name = "borderTopStyle", type = Macro.BorderTopStyle.class),
        @XmlElement(name = "borderTopColor", type = Macro.BorderTopColor.class),
        @XmlElement(name = "borderLeftWidth", type = Macro.BorderLeftWidth.class),
        @XmlElement(name = "borderLeftStyle", type = Macro.BorderLeftStyle.class),
        @XmlElement(name = "borderLeftColor", type = Macro.BorderLeftColor.class),
        @XmlElement(name = "borderRightWidth", type = Macro.BorderRightWidth.class),
        @XmlElement(name = "borderRightStyle", type = Macro.BorderRightStyle.class),
        @XmlElement(name = "borderRightColor", type = Macro.BorderRightColor.class),
        @XmlElement(name = "borderBottomWidth", type = Macro.BorderBottomWidth.class),
        @XmlElement(name = "borderBottomStyle", type = Macro.BorderBottomStyle.class),
        @XmlElement(name = "borderBottomColor", type = Macro.BorderBottomColor.class),
        @XmlElement(name = "maxWidth", type = Macro.MaxWidth.class),
        @XmlElement(name = "left", type = Macro.Left.class),
        @XmlElement(name = "top", type = Macro.Top.class),
        @XmlElement(name = "right", type = Macro.Right.class),
        @XmlElement(name = "bottom", type = Macro.Bottom.class),
        @XmlElement(name = "verticalAlign", type = Macro.VerticalAlign.class),
        @XmlElement(name = "overflowX", type = Macro.OverflowX.class),
        @XmlElement(name = "overflowY", type = Macro.OverflowY.class),
        @XmlElement(name = "maxHeight", type = Macro.MaxHeight.class),
        @XmlElement(name = "backgroundColor", type = Macro.BackgroundColor.class),
        @XmlElement(name = "backgroundImage", type = Macro.BackgroundImage.class),
        @XmlElement(name = "backgroundImageOpacityByPdf", type = Macro.BackgroundImageOpacityByPdf.class),
        @XmlElement(name = "backgroundSize", type = Macro.BackgroundSize.class),
        @XmlElement(name = "backgroundPositionX", type = Macro.BackgroundPositionX.class),
        @XmlElement(name = "backgroundPositionY", type = Macro.BackgroundPositionY.class),
        @XmlElement(name = "transformByJs", type = Macro.TransformByJs.class),
        @XmlElement(name = "opacityByJs", type = Macro.OpacityByJs.class),
        @XmlElement(name = "zIndexByJs", type = Macro.ZIndexByJs.class),
        @XmlElement(name = "backgroundRepeatByJs", type = Macro.BackgroundRepeatByJs.class),
        @XmlElement(name = "table", type = Table.class),
        @XmlElement(name = "thead", type = Thead.class),
        @XmlElement(name = "tr", type = Tr.class),
        @XmlElement(name = "tbody", type = Tbody.class),
        @XmlElement(name = "tloop", type = Tloop.class),
        @XmlElement(name = "tbottom", type = Tbottom.class),
        @XmlElement(name = "th", type = Th.class),
        @XmlElement(name = "td", type = Td.class),
        @XmlElement(name = "div", type = Div.class),
        @XmlElement(name = "span", type = Span.class),
        @XmlElement(name = "css", type = Css.class),
        @XmlElement(name = "if", type = If.class),
        @XmlElement(name = "forEach", type = ForEach.class),
        @XmlElement(name = "set", type = Set.class),
        @XmlElement(name = "macroRef", type = MacroRef.class)
    })
    protected List<Object> widthAndHeightAndPaddingLeft;
    @XmlAttribute(name = "name")
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "paramJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String paramJs;

    /**
     * Gets the value of the widthAndHeightAndPaddingLeft property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the widthAndHeightAndPaddingLeft property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWidthAndHeightAndPaddingLeft().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Macro.Width }
     * {@link Macro.Height }
     * {@link Macro.PaddingLeft }
     * {@link Macro.PaddingTop }
     * {@link Macro.PaddingRight }
     * {@link Macro.PaddingBottom }
     * {@link Macro.MarginLeftByJs }
     * {@link Macro.MarginTopByJs }
     * {@link Macro.MarginRightByJs }
     * {@link Macro.MarginBottomByJs }
     * {@link Macro.FontFamily }
     * {@link Macro.FontStyle }
     * {@link Macro.FontWeight }
     * {@link Macro.TextDecoration }
     * {@link Macro.BorderCollapse }
     * {@link Macro.BorderSpacing }
     * {@link Macro.TableLayout }
     * {@link Macro.TextAlign }
     * {@link Macro.WhiteSpace }
     * {@link Macro.WordWrap }
     * {@link Macro.Display }
     * {@link Macro.Visibility }
     * {@link Macro.Clear }
     * {@link Macro.Zoom }
     * {@link Macro.FloatAlign }
     * {@link Macro.FontSize }
     * {@link Macro.WebkitBoxSizing }
     * {@link Macro.MozBoxSizing }
     * {@link Macro.BoxSizing }
     * {@link Macro.MinHeight }
     * {@link Macro.Position }
     * {@link Macro.LineHeight }
     * {@link Macro.Color }
     * {@link Macro.BorderTopWidth }
     * {@link Macro.BorderTopStyle }
     * {@link Macro.BorderTopColor }
     * {@link Macro.BorderLeftWidth }
     * {@link Macro.BorderLeftStyle }
     * {@link Macro.BorderLeftColor }
     * {@link Macro.BorderRightWidth }
     * {@link Macro.BorderRightStyle }
     * {@link Macro.BorderRightColor }
     * {@link Macro.BorderBottomWidth }
     * {@link Macro.BorderBottomStyle }
     * {@link Macro.BorderBottomColor }
     * {@link Macro.MaxWidth }
     * {@link Macro.Left }
     * {@link Macro.Top }
     * {@link Macro.Right }
     * {@link Macro.Bottom }
     * {@link Macro.VerticalAlign }
     * {@link Macro.OverflowX }
     * {@link Macro.OverflowY }
     * {@link Macro.MaxHeight }
     * {@link Macro.BackgroundColor }
     * {@link Macro.BackgroundImage }
     * {@link Macro.BackgroundImageOpacityByPdf }
     * {@link Macro.BackgroundSize }
     * {@link Macro.BackgroundPositionX }
     * {@link Macro.BackgroundPositionY }
     * {@link Macro.TransformByJs }
     * {@link Macro.OpacityByJs }
     * {@link Macro.ZIndexByJs }
     * {@link Macro.BackgroundRepeatByJs }
     * {@link Table }
     * {@link Thead }
     * {@link Tr }
     * {@link Tbody }
     * {@link Tloop }
     * {@link Tbottom }
     * {@link Th }
     * {@link Td }
     * {@link Div }
     * {@link Span }
     * {@link Css }
     * {@link If }
     * {@link ForEach }
     * {@link Set }
     * {@link MacroRef }
     * 
     * 
     */
    public List<Object> getWidthAndHeightAndPaddingLeft() {
        if (widthAndHeightAndPaddingLeft == null) {
            widthAndHeightAndPaddingLeft = new ArrayList<Object>();
        }
        return this.widthAndHeightAndPaddingLeft;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取paramJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParamJs() {
        return paramJs;
    }

    /**
     * 设置paramJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParamJs(String value) {
        this.paramJs = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BackgroundColor {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BackgroundImage {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BackgroundImageOpacityByPdf {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}backgroundPositionXType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}backgroundPositionXType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BackgroundPositionX {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}backgroundPositionYType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}backgroundPositionYType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BackgroundPositionY {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BackgroundRepeatByJs {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}backgroundSizeType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}backgroundSizeType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BackgroundSize {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderBottomColor {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}borderStyleType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}borderStyleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderBottomStyle {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderBottomWidth {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderCollapse {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderLeftColor {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}borderStyleType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}borderStyleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderLeftStyle {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderLeftWidth {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderRightColor {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}borderStyleType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}borderStyleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderRightStyle {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderRightWidth {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderSpacing {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderTopColor {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}borderStyleType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}borderStyleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderTopStyle {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BorderTopWidth {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Bottom {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BoxSizing {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Clear {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}colorType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Color {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}displayType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}displayType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Display {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}floatAlignType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}floatAlignType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FloatAlign {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}fontFamilyType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}fontFamilyType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FontFamily {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FontSize {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}fontStyleType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}fontStyleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FontStyle {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}fontWeightType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}fontWeightType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FontWeight {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Height {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Left {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class LineHeight {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MarginBottomByJs {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MarginLeftByJs {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MarginRightByJs {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MarginTopByJs {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MaxHeight {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MaxWidth {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MinHeight {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MozBoxSizing {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OpacityByJs {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OverflowX {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OverflowY {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PaddingBottom {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PaddingLeft {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PaddingRight {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PaddingTop {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Position {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Right {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}tableLayoutType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}tableLayoutType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TableLayout {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}textAlignType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}textAlignType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TextAlign {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}textDecorationType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}textDecorationType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TextDecoration {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Top {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TransformByJs {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}verticalAlignType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}verticalAlignType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VerticalAlign {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}visibilityType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}visibilityType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Visibility {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class WebkitBoxSizing {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="js" type="{https://github.com/hongjinqiu/nanhu-print-java}whiteSpaceType" />
     *       &lt;attribute name="pdf" type="{https://github.com/hongjinqiu/nanhu-print-java}whiteSpaceType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class WhiteSpace {

        @XmlAttribute(name = "js")
        protected String js;
        @XmlAttribute(name = "pdf")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Width {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class WordWrap {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ZIndexByJs {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute2"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Zoom {

        @XmlAttribute(name = "js")
        @XmlSchemaType(name = "anySimpleType")
        protected String js;
        @XmlAttribute(name = "pdf")
        @XmlSchemaType(name = "anySimpleType")
        protected String pdf;

        /**
         * 获取js属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJs() {
            return js;
        }

        /**
         * 设置js属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJs(String value) {
            this.js = value;
        }

        /**
         * 获取pdf属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPdf() {
            return pdf;
        }

        /**
         * 设置pdf属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPdf(String value) {
            this.pdf = value;
        }

    }

}
