# 可扩展性

Nanhu-print-java 提供了两个接口, 用来实现页面配置难以实现, 只能用代码完成的功能。

## 1. com.hongjinqiu.nanhuprint.eval.custom.ICustomContent

示例代码为:

`com.hongjinqiu.nanhuprint.eval.custom.CustomPageNumber`

这个类实现的功能是,在配置的位置,显示自定义的页码.

配置示例为：

```xml
<div>
    <params>
        <param name="customContent" value="com.hongjinqiu.nanhuprint.eval.custom.CustomPageNumber" />
        <param name="customContentFormat" value="{currentPageNumber} /of/ {totalPageNumber}" />
    </params>
</div>
```

参考这个类的实现, 便可以在页面位置, 生成自己想展示的内容。

## 2. com.hongjinqiu.nanhuprint.eval.custom.ICalcWidth

示例代码为:

`com.hongjinqiu.nanhuprint.eval.custom.CalcWidth`

这个类实现的功能是, 根据单元格内容的宽度, 自动设置单元格的宽度, 避免内容换行。

配置示例为:

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
