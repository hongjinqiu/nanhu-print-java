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
 *         &lt;element ref="{https://github.com/hongjinqiu/nanhu-print-java}css" minOccurs="0"/>
 *         &lt;group ref="{https://github.com/hongjinqiu/nanhu-print-java}nest-element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{https://github.com/hongjinqiu/nanhu-print-java}params" minOccurs="0"/>
 *         &lt;element ref="{https://github.com/hongjinqiu/nanhu-print-java}span" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{https://github.com/hongjinqiu/nanhu-print-java}css-attribute"/>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="pageSizePdf">
 *         &lt;simpleType>
 *           &lt;union>
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                 &lt;enumeration value="A0"/>
 *                 &lt;enumeration value="A1"/>
 *                 &lt;enumeration value="A2"/>
 *                 &lt;enumeration value="A3"/>
 *                 &lt;enumeration value="A4"/>
 *                 &lt;enumeration value="A5"/>
 *                 &lt;enumeration value="A6"/>
 *                 &lt;enumeration value="A7"/>
 *                 &lt;enumeration value="A8"/>
 *                 &lt;enumeration value="A9"/>
 *                 &lt;enumeration value="A10"/>
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
 *       &lt;attribute name="explain" type="{https://github.com/hongjinqiu/nanhu-print-java}trueOrFalse" />
 *       &lt;attribute name="rotate" type="{https://github.com/hongjinqiu/nanhu-print-java}trueOrFalse" />
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
@XmlRootElement(name = "body")
public class Body {

    @XmlElements({
        @XmlElement(name = "if", type = If.class),
        @XmlElement(name = "forEach", type = ForEach.class),
        @XmlElement(name = "set", type = Set.class),
        @XmlElement(name = "macroRef", type = MacroRef.class),
        @XmlElement(name = "css", type = Css.class),
        @XmlElement(name = "table", type = Table.class),
        @XmlElement(name = "div", type = Div.class),
        @XmlElement(name = "params", type = Params.class),
        @XmlElement(name = "span", type = Span.class)
    })
    protected List<Object> ifAndForEachAndSet;
    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "pageSizePdf")
    protected String pageSizePdf;
    @XmlAttribute(name = "explain")
    protected String explain;
    @XmlAttribute(name = "rotate")
    protected String rotate;
    @XmlAttribute(name = "cls")
    @XmlSchemaType(name = "anySimpleType")
    protected String cls;
    @XmlAttribute(name = "width")
    @XmlSchemaType(name = "anySimpleType")
    protected String width;
    @XmlAttribute(name = "height")
    @XmlSchemaType(name = "anySimpleType")
    protected String height;
    @XmlAttribute(name = "paddingLeft")
    @XmlSchemaType(name = "anySimpleType")
    protected String paddingLeft;
    @XmlAttribute(name = "paddingTop")
    @XmlSchemaType(name = "anySimpleType")
    protected String paddingTop;
    @XmlAttribute(name = "paddingRight")
    @XmlSchemaType(name = "anySimpleType")
    protected String paddingRight;
    @XmlAttribute(name = "paddingBottom")
    @XmlSchemaType(name = "anySimpleType")
    protected String paddingBottom;
    @XmlAttribute(name = "marginLeftByJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String marginLeftByJs;
    @XmlAttribute(name = "marginTopByJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String marginTopByJs;
    @XmlAttribute(name = "marginRightByJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String marginRightByJs;
    @XmlAttribute(name = "marginBottomByJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String marginBottomByJs;
    @XmlAttribute(name = "fontFamily")
    protected String fontFamily;
    @XmlAttribute(name = "fontStyle")
    protected String fontStyle;
    @XmlAttribute(name = "fontWeight")
    protected String fontWeight;
    @XmlAttribute(name = "textDecoration")
    protected String textDecoration;
    @XmlAttribute(name = "borderCollapse")
    @XmlSchemaType(name = "anySimpleType")
    protected String borderCollapse;
    @XmlAttribute(name = "borderSpacing")
    @XmlSchemaType(name = "anySimpleType")
    protected String borderSpacing;
    @XmlAttribute(name = "tableLayout")
    protected String tableLayout;
    @XmlAttribute(name = "textAlign")
    protected String textAlign;
    @XmlAttribute(name = "whiteSpace")
    protected String whiteSpace;
    @XmlAttribute(name = "wordWrap")
    @XmlSchemaType(name = "anySimpleType")
    protected String wordWrap;
    @XmlAttribute(name = "display")
    protected String display;
    @XmlAttribute(name = "visibility")
    protected String visibility;
    @XmlAttribute(name = "clear")
    @XmlSchemaType(name = "anySimpleType")
    protected String clear;
    @XmlAttribute(name = "zoom")
    @XmlSchemaType(name = "anySimpleType")
    protected String zoom;
    @XmlAttribute(name = "floatAlign")
    @XmlSchemaType(name = "anySimpleType")
    protected String floatAlign;
    @XmlAttribute(name = "fontSize")
    @XmlSchemaType(name = "anySimpleType")
    protected String fontSize;
    @XmlAttribute(name = "webkitBoxSizing")
    @XmlSchemaType(name = "anySimpleType")
    protected String webkitBoxSizing;
    @XmlAttribute(name = "mozBoxSizing")
    @XmlSchemaType(name = "anySimpleType")
    protected String mozBoxSizing;
    @XmlAttribute(name = "boxSizing")
    @XmlSchemaType(name = "anySimpleType")
    protected String boxSizing;
    @XmlAttribute(name = "minHeight")
    @XmlSchemaType(name = "anySimpleType")
    protected String minHeight;
    @XmlAttribute(name = "position")
    @XmlSchemaType(name = "anySimpleType")
    protected String position;
    @XmlAttribute(name = "lineHeight")
    @XmlSchemaType(name = "anySimpleType")
    protected String lineHeight;
    @XmlAttribute(name = "color")
    protected String color;
    @XmlAttribute(name = "borderTopWidth")
    @XmlSchemaType(name = "anySimpleType")
    protected String borderTopWidth;
    @XmlAttribute(name = "borderTopStyle")
    protected String borderTopStyle;
    @XmlAttribute(name = "borderTopColor")
    protected String borderTopColor;
    @XmlAttribute(name = "borderLeftWidth")
    @XmlSchemaType(name = "anySimpleType")
    protected String borderLeftWidth;
    @XmlAttribute(name = "borderLeftStyle")
    protected String borderLeftStyle;
    @XmlAttribute(name = "borderLeftColor")
    protected String borderLeftColor;
    @XmlAttribute(name = "borderRightWidth")
    @XmlSchemaType(name = "anySimpleType")
    protected String borderRightWidth;
    @XmlAttribute(name = "borderRightStyle")
    protected String borderRightStyle;
    @XmlAttribute(name = "borderRightColor")
    protected String borderRightColor;
    @XmlAttribute(name = "borderBottomWidth")
    @XmlSchemaType(name = "anySimpleType")
    protected String borderBottomWidth;
    @XmlAttribute(name = "borderBottomStyle")
    protected String borderBottomStyle;
    @XmlAttribute(name = "borderBottomColor")
    protected String borderBottomColor;
    @XmlAttribute(name = "maxWidth")
    @XmlSchemaType(name = "anySimpleType")
    protected String maxWidth;
    @XmlAttribute(name = "left")
    @XmlSchemaType(name = "anySimpleType")
    protected String left;
    @XmlAttribute(name = "top")
    @XmlSchemaType(name = "anySimpleType")
    protected String top;
    @XmlAttribute(name = "right")
    @XmlSchemaType(name = "anySimpleType")
    protected String right;
    @XmlAttribute(name = "bottom")
    @XmlSchemaType(name = "anySimpleType")
    protected String bottom;
    @XmlAttribute(name = "verticalAlign")
    protected String verticalAlign;
    @XmlAttribute(name = "overflowX")
    @XmlSchemaType(name = "anySimpleType")
    protected String overflowX;
    @XmlAttribute(name = "overflowY")
    @XmlSchemaType(name = "anySimpleType")
    protected String overflowY;
    @XmlAttribute(name = "maxHeight")
    @XmlSchemaType(name = "anySimpleType")
    protected String maxHeight;
    @XmlAttribute(name = "backgroundColor")
    protected String backgroundColor;
    @XmlAttribute(name = "backgroundImage")
    @XmlSchemaType(name = "anySimpleType")
    protected String backgroundImage;
    @XmlAttribute(name = "backgroundImageOpacityByPdf")
    @XmlSchemaType(name = "anySimpleType")
    protected String backgroundImageOpacityByPdf;
    @XmlAttribute(name = "backgroundSize")
    protected String backgroundSize;
    @XmlAttribute(name = "backgroundPositionX")
    protected String backgroundPositionX;
    @XmlAttribute(name = "backgroundPositionY")
    protected String backgroundPositionY;
    @XmlAttribute(name = "transformByJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String transformByJs;
    @XmlAttribute(name = "opacityByJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String opacityByJs;
    @XmlAttribute(name = "zIndexByJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String zIndexByJs;
    @XmlAttribute(name = "backgroundRepeatByJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String backgroundRepeatByJs;
    @XmlAttribute(name = "cellspacing")
    @XmlSchemaType(name = "anySimpleType")
    protected String cellspacing;
    @XmlAttribute(name = "cellpadding")
    @XmlSchemaType(name = "anySimpleType")
    protected String cellpadding;
    @XmlAttribute(name = "colspan")
    @XmlSchemaType(name = "anySimpleType")
    protected String colspan;
    @XmlAttribute(name = "rowspan")
    @XmlSchemaType(name = "anySimpleType")
    protected String rowspan;

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
     * {@link Table }
     * {@link Div }
     * {@link Params }
     * {@link Span }
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
     * 获取pageSizePdf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageSizePdf() {
        return pageSizePdf;
    }

    /**
     * 设置pageSizePdf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageSizePdf(String value) {
        this.pageSizePdf = value;
    }

    /**
     * 获取explain属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExplain() {
        return explain;
    }

    /**
     * 设置explain属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExplain(String value) {
        this.explain = value;
    }

    /**
     * 获取rotate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRotate() {
        return rotate;
    }

    /**
     * 设置rotate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRotate(String value) {
        this.rotate = value;
    }

    /**
     * 获取cls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCls() {
        return cls;
    }

    /**
     * 设置cls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCls(String value) {
        this.cls = value;
    }

    /**
     * 获取width属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidth() {
        return width;
    }

    /**
     * 设置width属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * 获取height属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeight() {
        return height;
    }

    /**
     * 设置height属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeight(String value) {
        this.height = value;
    }

    /**
     * 获取paddingLeft属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaddingLeft() {
        return paddingLeft;
    }

    /**
     * 设置paddingLeft属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaddingLeft(String value) {
        this.paddingLeft = value;
    }

    /**
     * 获取paddingTop属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaddingTop() {
        return paddingTop;
    }

    /**
     * 设置paddingTop属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaddingTop(String value) {
        this.paddingTop = value;
    }

    /**
     * 获取paddingRight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaddingRight() {
        return paddingRight;
    }

    /**
     * 设置paddingRight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaddingRight(String value) {
        this.paddingRight = value;
    }

    /**
     * 获取paddingBottom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaddingBottom() {
        return paddingBottom;
    }

    /**
     * 设置paddingBottom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaddingBottom(String value) {
        this.paddingBottom = value;
    }

    /**
     * 获取marginLeftByJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarginLeftByJs() {
        return marginLeftByJs;
    }

    /**
     * 设置marginLeftByJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarginLeftByJs(String value) {
        this.marginLeftByJs = value;
    }

    /**
     * 获取marginTopByJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarginTopByJs() {
        return marginTopByJs;
    }

    /**
     * 设置marginTopByJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarginTopByJs(String value) {
        this.marginTopByJs = value;
    }

    /**
     * 获取marginRightByJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarginRightByJs() {
        return marginRightByJs;
    }

    /**
     * 设置marginRightByJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarginRightByJs(String value) {
        this.marginRightByJs = value;
    }

    /**
     * 获取marginBottomByJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarginBottomByJs() {
        return marginBottomByJs;
    }

    /**
     * 设置marginBottomByJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarginBottomByJs(String value) {
        this.marginBottomByJs = value;
    }

    /**
     * 获取fontFamily属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * 设置fontFamily属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontFamily(String value) {
        this.fontFamily = value;
    }

    /**
     * 获取fontStyle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontStyle() {
        return fontStyle;
    }

    /**
     * 设置fontStyle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontStyle(String value) {
        this.fontStyle = value;
    }

    /**
     * 获取fontWeight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontWeight() {
        return fontWeight;
    }

    /**
     * 设置fontWeight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontWeight(String value) {
        this.fontWeight = value;
    }

    /**
     * 获取textDecoration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextDecoration() {
        return textDecoration;
    }

    /**
     * 设置textDecoration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextDecoration(String value) {
        this.textDecoration = value;
    }

    /**
     * 获取borderCollapse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderCollapse() {
        return borderCollapse;
    }

    /**
     * 设置borderCollapse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderCollapse(String value) {
        this.borderCollapse = value;
    }

    /**
     * 获取borderSpacing属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderSpacing() {
        return borderSpacing;
    }

    /**
     * 设置borderSpacing属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderSpacing(String value) {
        this.borderSpacing = value;
    }

    /**
     * 获取tableLayout属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableLayout() {
        return tableLayout;
    }

    /**
     * 设置tableLayout属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableLayout(String value) {
        this.tableLayout = value;
    }

    /**
     * 获取textAlign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextAlign() {
        return textAlign;
    }

    /**
     * 设置textAlign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextAlign(String value) {
        this.textAlign = value;
    }

    /**
     * 获取whiteSpace属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhiteSpace() {
        return whiteSpace;
    }

    /**
     * 设置whiteSpace属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhiteSpace(String value) {
        this.whiteSpace = value;
    }

    /**
     * 获取wordWrap属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWordWrap() {
        return wordWrap;
    }

    /**
     * 设置wordWrap属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWordWrap(String value) {
        this.wordWrap = value;
    }

    /**
     * 获取display属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplay() {
        return display;
    }

    /**
     * 设置display属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplay(String value) {
        this.display = value;
    }

    /**
     * 获取visibility属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * 设置visibility属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisibility(String value) {
        this.visibility = value;
    }

    /**
     * 获取clear属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClear() {
        return clear;
    }

    /**
     * 设置clear属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClear(String value) {
        this.clear = value;
    }

    /**
     * 获取zoom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoom() {
        return zoom;
    }

    /**
     * 设置zoom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoom(String value) {
        this.zoom = value;
    }

    /**
     * 获取floatAlign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloatAlign() {
        return floatAlign;
    }

    /**
     * 设置floatAlign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloatAlign(String value) {
        this.floatAlign = value;
    }

    /**
     * 获取fontSize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontSize() {
        return fontSize;
    }

    /**
     * 设置fontSize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontSize(String value) {
        this.fontSize = value;
    }

    /**
     * 获取webkitBoxSizing属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebkitBoxSizing() {
        return webkitBoxSizing;
    }

    /**
     * 设置webkitBoxSizing属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebkitBoxSizing(String value) {
        this.webkitBoxSizing = value;
    }

    /**
     * 获取mozBoxSizing属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMozBoxSizing() {
        return mozBoxSizing;
    }

    /**
     * 设置mozBoxSizing属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMozBoxSizing(String value) {
        this.mozBoxSizing = value;
    }

    /**
     * 获取boxSizing属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoxSizing() {
        return boxSizing;
    }

    /**
     * 设置boxSizing属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoxSizing(String value) {
        this.boxSizing = value;
    }

    /**
     * 获取minHeight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinHeight() {
        return minHeight;
    }

    /**
     * 设置minHeight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinHeight(String value) {
        this.minHeight = value;
    }

    /**
     * 获取position属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置position属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * 获取lineHeight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineHeight() {
        return lineHeight;
    }

    /**
     * 设置lineHeight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineHeight(String value) {
        this.lineHeight = value;
    }

    /**
     * 获取color属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置color属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * 获取borderTopWidth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderTopWidth() {
        return borderTopWidth;
    }

    /**
     * 设置borderTopWidth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderTopWidth(String value) {
        this.borderTopWidth = value;
    }

    /**
     * 获取borderTopStyle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderTopStyle() {
        return borderTopStyle;
    }

    /**
     * 设置borderTopStyle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderTopStyle(String value) {
        this.borderTopStyle = value;
    }

    /**
     * 获取borderTopColor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderTopColor() {
        return borderTopColor;
    }

    /**
     * 设置borderTopColor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderTopColor(String value) {
        this.borderTopColor = value;
    }

    /**
     * 获取borderLeftWidth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderLeftWidth() {
        return borderLeftWidth;
    }

    /**
     * 设置borderLeftWidth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderLeftWidth(String value) {
        this.borderLeftWidth = value;
    }

    /**
     * 获取borderLeftStyle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderLeftStyle() {
        return borderLeftStyle;
    }

    /**
     * 设置borderLeftStyle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderLeftStyle(String value) {
        this.borderLeftStyle = value;
    }

    /**
     * 获取borderLeftColor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderLeftColor() {
        return borderLeftColor;
    }

    /**
     * 设置borderLeftColor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderLeftColor(String value) {
        this.borderLeftColor = value;
    }

    /**
     * 获取borderRightWidth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderRightWidth() {
        return borderRightWidth;
    }

    /**
     * 设置borderRightWidth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderRightWidth(String value) {
        this.borderRightWidth = value;
    }

    /**
     * 获取borderRightStyle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderRightStyle() {
        return borderRightStyle;
    }

    /**
     * 设置borderRightStyle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderRightStyle(String value) {
        this.borderRightStyle = value;
    }

    /**
     * 获取borderRightColor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderRightColor() {
        return borderRightColor;
    }

    /**
     * 设置borderRightColor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderRightColor(String value) {
        this.borderRightColor = value;
    }

    /**
     * 获取borderBottomWidth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderBottomWidth() {
        return borderBottomWidth;
    }

    /**
     * 设置borderBottomWidth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderBottomWidth(String value) {
        this.borderBottomWidth = value;
    }

    /**
     * 获取borderBottomStyle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderBottomStyle() {
        return borderBottomStyle;
    }

    /**
     * 设置borderBottomStyle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderBottomStyle(String value) {
        this.borderBottomStyle = value;
    }

    /**
     * 获取borderBottomColor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorderBottomColor() {
        return borderBottomColor;
    }

    /**
     * 设置borderBottomColor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorderBottomColor(String value) {
        this.borderBottomColor = value;
    }

    /**
     * 获取maxWidth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxWidth() {
        return maxWidth;
    }

    /**
     * 设置maxWidth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxWidth(String value) {
        this.maxWidth = value;
    }

    /**
     * 获取left属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeft() {
        return left;
    }

    /**
     * 设置left属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeft(String value) {
        this.left = value;
    }

    /**
     * 获取top属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTop() {
        return top;
    }

    /**
     * 设置top属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTop(String value) {
        this.top = value;
    }

    /**
     * 获取right属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRight() {
        return right;
    }

    /**
     * 设置right属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRight(String value) {
        this.right = value;
    }

    /**
     * 获取bottom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBottom() {
        return bottom;
    }

    /**
     * 设置bottom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBottom(String value) {
        this.bottom = value;
    }

    /**
     * 获取verticalAlign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerticalAlign() {
        return verticalAlign;
    }

    /**
     * 设置verticalAlign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerticalAlign(String value) {
        this.verticalAlign = value;
    }

    /**
     * 获取overflowX属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverflowX() {
        return overflowX;
    }

    /**
     * 设置overflowX属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverflowX(String value) {
        this.overflowX = value;
    }

    /**
     * 获取overflowY属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverflowY() {
        return overflowY;
    }

    /**
     * 设置overflowY属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverflowY(String value) {
        this.overflowY = value;
    }

    /**
     * 获取maxHeight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxHeight() {
        return maxHeight;
    }

    /**
     * 设置maxHeight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxHeight(String value) {
        this.maxHeight = value;
    }

    /**
     * 获取backgroundColor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 设置backgroundColor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundColor(String value) {
        this.backgroundColor = value;
    }

    /**
     * 获取backgroundImage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * 设置backgroundImage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundImage(String value) {
        this.backgroundImage = value;
    }

    /**
     * 获取backgroundImageOpacityByPdf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundImageOpacityByPdf() {
        return backgroundImageOpacityByPdf;
    }

    /**
     * 设置backgroundImageOpacityByPdf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundImageOpacityByPdf(String value) {
        this.backgroundImageOpacityByPdf = value;
    }

    /**
     * 获取backgroundSize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundSize() {
        return backgroundSize;
    }

    /**
     * 设置backgroundSize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundSize(String value) {
        this.backgroundSize = value;
    }

    /**
     * 获取backgroundPositionX属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundPositionX() {
        return backgroundPositionX;
    }

    /**
     * 设置backgroundPositionX属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundPositionX(String value) {
        this.backgroundPositionX = value;
    }

    /**
     * 获取backgroundPositionY属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundPositionY() {
        return backgroundPositionY;
    }

    /**
     * 设置backgroundPositionY属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundPositionY(String value) {
        this.backgroundPositionY = value;
    }

    /**
     * 获取transformByJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransformByJs() {
        return transformByJs;
    }

    /**
     * 设置transformByJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransformByJs(String value) {
        this.transformByJs = value;
    }

    /**
     * 获取opacityByJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpacityByJs() {
        return opacityByJs;
    }

    /**
     * 设置opacityByJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpacityByJs(String value) {
        this.opacityByJs = value;
    }

    /**
     * 获取zIndexByJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZIndexByJs() {
        return zIndexByJs;
    }

    /**
     * 设置zIndexByJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZIndexByJs(String value) {
        this.zIndexByJs = value;
    }

    /**
     * 获取backgroundRepeatByJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundRepeatByJs() {
        return backgroundRepeatByJs;
    }

    /**
     * 设置backgroundRepeatByJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundRepeatByJs(String value) {
        this.backgroundRepeatByJs = value;
    }

    /**
     * 获取cellspacing属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellspacing() {
        return cellspacing;
    }

    /**
     * 设置cellspacing属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellspacing(String value) {
        this.cellspacing = value;
    }

    /**
     * 获取cellpadding属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellpadding() {
        return cellpadding;
    }

    /**
     * 设置cellpadding属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellpadding(String value) {
        this.cellpadding = value;
    }

    /**
     * 获取colspan属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColspan() {
        return colspan;
    }

    /**
     * 设置colspan属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColspan(String value) {
        this.colspan = value;
    }

    /**
     * 获取rowspan属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRowspan() {
        return rowspan;
    }

    /**
     * 设置rowspan属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRowspan(String value) {
        this.rowspan = value;
    }

}
