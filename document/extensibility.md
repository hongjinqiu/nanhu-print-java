# Extensibility

Nanhu-print-java provides two interfaces, which are used to implement functions that are difficult to implement on page configuration and can only be completed by code.

## 1. com.hongjinqiu.nanhuprint.eval.custom.ICustomContent

The sample code is:

`com.hongjinqiu.nanhuprint.eval.custom.CustomPageNumber`

The function implemented by this class is to display a custom page number at the configured position.

An example configuration is:

```xml
<div>
    <params>
        <param name="customContent" value="com.hongjinqiu.nanhuprint.eval.custom.CustomPageNumber" />
        <param name="customContentFormat" value="{currentPageNumber} /of/ {totalPageNumber}" />
    </params>
</div>
```

Referring to the implementation of this class, you can generate the content you want to display at the page position.

## 2. com.hongjinqiu.nanhuprint.eval.custom.ICalcWidth

The sample code is:

`com.hongjinqiu.nanhuprint.eval.custom.CalcWidth`

The function implemented by this class is to automatically set the width of the cell according to the width of the cell content, so as to avoid content wrapping.

An example configuration is:

```xml
<td textAlign="left">
    <params>
        <param name="calcWidth" value="com.hongjinqiu.nanhuprint.eval.custom.CalcWidth" />
        <param name="calcWidthTagId" value="leftIssueBy" />
    </params>
    <div id="leftIssueBy" cls="f13 bodyLineHeight" whiteSpace="nowrap" paddingRight="5px" >
        <span value="ISSUED BY:" />
    </div>
</td>
```
