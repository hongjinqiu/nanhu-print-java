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
 *       &lt;attribute name="testJs" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
@XmlRootElement(name = "if")
public class If {

    @XmlElements({
        @XmlElement(name = "width", type = com.hongjinqiu.nanhuprint.model.Macro.Width.class),
        @XmlElement(name = "height", type = com.hongjinqiu.nanhuprint.model.Macro.Height.class),
        @XmlElement(name = "paddingLeft", type = com.hongjinqiu.nanhuprint.model.Macro.PaddingLeft.class),
        @XmlElement(name = "paddingTop", type = com.hongjinqiu.nanhuprint.model.Macro.PaddingTop.class),
        @XmlElement(name = "paddingRight", type = com.hongjinqiu.nanhuprint.model.Macro.PaddingRight.class),
        @XmlElement(name = "paddingBottom", type = com.hongjinqiu.nanhuprint.model.Macro.PaddingBottom.class),
        @XmlElement(name = "marginLeftByJs", type = com.hongjinqiu.nanhuprint.model.Macro.MarginLeftByJs.class),
        @XmlElement(name = "marginTopByJs", type = com.hongjinqiu.nanhuprint.model.Macro.MarginTopByJs.class),
        @XmlElement(name = "marginRightByJs", type = com.hongjinqiu.nanhuprint.model.Macro.MarginRightByJs.class),
        @XmlElement(name = "marginBottomByJs", type = com.hongjinqiu.nanhuprint.model.Macro.MarginBottomByJs.class),
        @XmlElement(name = "fontFamily", type = com.hongjinqiu.nanhuprint.model.Macro.FontFamily.class),
        @XmlElement(name = "fontStyle", type = com.hongjinqiu.nanhuprint.model.Macro.FontStyle.class),
        @XmlElement(name = "fontWeight", type = com.hongjinqiu.nanhuprint.model.Macro.FontWeight.class),
        @XmlElement(name = "textDecoration", type = com.hongjinqiu.nanhuprint.model.Macro.TextDecoration.class),
        @XmlElement(name = "borderCollapse", type = com.hongjinqiu.nanhuprint.model.Macro.BorderCollapse.class),
        @XmlElement(name = "borderSpacing", type = com.hongjinqiu.nanhuprint.model.Macro.BorderSpacing.class),
        @XmlElement(name = "tableLayout", type = com.hongjinqiu.nanhuprint.model.Macro.TableLayout.class),
        @XmlElement(name = "textAlign", type = com.hongjinqiu.nanhuprint.model.Macro.TextAlign.class),
        @XmlElement(name = "whiteSpace", type = com.hongjinqiu.nanhuprint.model.Macro.WhiteSpace.class),
        @XmlElement(name = "wordWrap", type = com.hongjinqiu.nanhuprint.model.Macro.WordWrap.class),
        @XmlElement(name = "display", type = com.hongjinqiu.nanhuprint.model.Macro.Display.class),
        @XmlElement(name = "visibility", type = com.hongjinqiu.nanhuprint.model.Macro.Visibility.class),
        @XmlElement(name = "clear", type = com.hongjinqiu.nanhuprint.model.Macro.Clear.class),
        @XmlElement(name = "zoom", type = com.hongjinqiu.nanhuprint.model.Macro.Zoom.class),
        @XmlElement(name = "floatAlign", type = com.hongjinqiu.nanhuprint.model.Macro.FloatAlign.class),
        @XmlElement(name = "fontSize", type = com.hongjinqiu.nanhuprint.model.Macro.FontSize.class),
        @XmlElement(name = "webkitBoxSizing", type = com.hongjinqiu.nanhuprint.model.Macro.WebkitBoxSizing.class),
        @XmlElement(name = "mozBoxSizing", type = com.hongjinqiu.nanhuprint.model.Macro.MozBoxSizing.class),
        @XmlElement(name = "boxSizing", type = com.hongjinqiu.nanhuprint.model.Macro.BoxSizing.class),
        @XmlElement(name = "minHeight", type = com.hongjinqiu.nanhuprint.model.Macro.MinHeight.class),
        @XmlElement(name = "position", type = com.hongjinqiu.nanhuprint.model.Macro.Position.class),
        @XmlElement(name = "lineHeight", type = com.hongjinqiu.nanhuprint.model.Macro.LineHeight.class),
        @XmlElement(name = "color", type = com.hongjinqiu.nanhuprint.model.Macro.Color.class),
        @XmlElement(name = "borderTopWidth", type = com.hongjinqiu.nanhuprint.model.Macro.BorderTopWidth.class),
        @XmlElement(name = "borderTopStyle", type = com.hongjinqiu.nanhuprint.model.Macro.BorderTopStyle.class),
        @XmlElement(name = "borderTopColor", type = com.hongjinqiu.nanhuprint.model.Macro.BorderTopColor.class),
        @XmlElement(name = "borderLeftWidth", type = com.hongjinqiu.nanhuprint.model.Macro.BorderLeftWidth.class),
        @XmlElement(name = "borderLeftStyle", type = com.hongjinqiu.nanhuprint.model.Macro.BorderLeftStyle.class),
        @XmlElement(name = "borderLeftColor", type = com.hongjinqiu.nanhuprint.model.Macro.BorderLeftColor.class),
        @XmlElement(name = "borderRightWidth", type = com.hongjinqiu.nanhuprint.model.Macro.BorderRightWidth.class),
        @XmlElement(name = "borderRightStyle", type = com.hongjinqiu.nanhuprint.model.Macro.BorderRightStyle.class),
        @XmlElement(name = "borderRightColor", type = com.hongjinqiu.nanhuprint.model.Macro.BorderRightColor.class),
        @XmlElement(name = "borderBottomWidth", type = com.hongjinqiu.nanhuprint.model.Macro.BorderBottomWidth.class),
        @XmlElement(name = "borderBottomStyle", type = com.hongjinqiu.nanhuprint.model.Macro.BorderBottomStyle.class),
        @XmlElement(name = "borderBottomColor", type = com.hongjinqiu.nanhuprint.model.Macro.BorderBottomColor.class),
        @XmlElement(name = "maxWidth", type = com.hongjinqiu.nanhuprint.model.Macro.MaxWidth.class),
        @XmlElement(name = "left", type = com.hongjinqiu.nanhuprint.model.Macro.Left.class),
        @XmlElement(name = "top", type = com.hongjinqiu.nanhuprint.model.Macro.Top.class),
        @XmlElement(name = "right", type = com.hongjinqiu.nanhuprint.model.Macro.Right.class),
        @XmlElement(name = "bottom", type = com.hongjinqiu.nanhuprint.model.Macro.Bottom.class),
        @XmlElement(name = "verticalAlign", type = com.hongjinqiu.nanhuprint.model.Macro.VerticalAlign.class),
        @XmlElement(name = "overflowX", type = com.hongjinqiu.nanhuprint.model.Macro.OverflowX.class),
        @XmlElement(name = "overflowY", type = com.hongjinqiu.nanhuprint.model.Macro.OverflowY.class),
        @XmlElement(name = "maxHeight", type = com.hongjinqiu.nanhuprint.model.Macro.MaxHeight.class),
        @XmlElement(name = "backgroundColor", type = com.hongjinqiu.nanhuprint.model.Macro.BackgroundColor.class),
        @XmlElement(name = "backgroundImage", type = com.hongjinqiu.nanhuprint.model.Macro.BackgroundImage.class),
        @XmlElement(name = "backgroundImageOpacityByPdf", type = com.hongjinqiu.nanhuprint.model.Macro.BackgroundImageOpacityByPdf.class),
        @XmlElement(name = "backgroundSize", type = com.hongjinqiu.nanhuprint.model.Macro.BackgroundSize.class),
        @XmlElement(name = "backgroundPositionX", type = com.hongjinqiu.nanhuprint.model.Macro.BackgroundPositionX.class),
        @XmlElement(name = "backgroundPositionY", type = com.hongjinqiu.nanhuprint.model.Macro.BackgroundPositionY.class),
        @XmlElement(name = "transformByJs", type = com.hongjinqiu.nanhuprint.model.Macro.TransformByJs.class),
        @XmlElement(name = "opacityByJs", type = com.hongjinqiu.nanhuprint.model.Macro.OpacityByJs.class),
        @XmlElement(name = "zIndexByJs", type = com.hongjinqiu.nanhuprint.model.Macro.ZIndexByJs.class),
        @XmlElement(name = "backgroundRepeatByJs", type = com.hongjinqiu.nanhuprint.model.Macro.BackgroundRepeatByJs.class),
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
    @XmlAttribute(name = "testJs")
    @XmlSchemaType(name = "anySimpleType")
    protected String testJs;

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
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Width }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Height }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.PaddingLeft }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.PaddingTop }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.PaddingRight }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.PaddingBottom }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.MarginLeftByJs }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.MarginTopByJs }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.MarginRightByJs }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.MarginBottomByJs }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.FontFamily }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.FontStyle }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.FontWeight }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.TextDecoration }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderCollapse }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderSpacing }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.TableLayout }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.TextAlign }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.WhiteSpace }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.WordWrap }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Display }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Visibility }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Clear }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Zoom }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.FloatAlign }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.FontSize }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.WebkitBoxSizing }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.MozBoxSizing }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BoxSizing }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.MinHeight }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Position }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.LineHeight }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Color }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderTopWidth }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderTopStyle }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderTopColor }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderLeftWidth }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderLeftStyle }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderLeftColor }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderRightWidth }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderRightStyle }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderRightColor }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderBottomWidth }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderBottomStyle }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BorderBottomColor }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.MaxWidth }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Left }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Top }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Right }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.Bottom }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.VerticalAlign }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.OverflowX }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.OverflowY }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.MaxHeight }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BackgroundColor }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BackgroundImage }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BackgroundImageOpacityByPdf }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BackgroundSize }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BackgroundPositionX }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BackgroundPositionY }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.TransformByJs }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.OpacityByJs }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.ZIndexByJs }
     * {@link com.hongjinqiu.nanhuprint.model.Macro.BackgroundRepeatByJs }
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
     * 获取testJs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestJs() {
        return testJs;
    }

    /**
     * 设置testJs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestJs(String value) {
        this.testJs = value;
    }

}
