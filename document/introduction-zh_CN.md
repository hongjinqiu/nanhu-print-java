# 1. Nanhu-print-java 是什么?

nanhu-print-java 是一个用 java 语言实现的 pdf 生成框架。

用户可通过配置一个 xml 格式的文件, 准备好想打印的 json 数据格式, 再调用 nanhu-print-java 框架API, 即可完成一个 PDF 文件的生成。

开发视频可参考:`https://youtu.be/vdTSc8rXr9M`

## 1.1. Nanhu-print-java 诞生的背景

笔者就职公司想实现一个自定义打印的功能, 需要满足以下功能:

1. 定义一些模版, 每个模版的每个字段, label 可自定义, 可显示隐藏, 表格的每列宽度, 可自定义, 客户可在浏览器端, 对这些模版进行字段选择。
2. 模版的表头, 表格的头部, 需要在每一页都显示, 金额汇总,签名等信息需要固定在页面底部。

公司最开始准备了两个技术方案

1. 前后端分开各自实现,前端用 js 实现页面, 做页面字段控制, 后端用 java, 调 iText pdf 库, 来生成 pdf 进行打印.
2. 基本上前端实现, 前端 js 实现页面后, 将生成的 html 发往后端, 后端用 java, 调用 html 转 pdf 框架, 生成 pdf 进行打印.

考虑到页面上每个字段都要做复杂的显示隐藏操作, 而直接 java 实现做界面显示的开发, 又很繁琐, 并且开发完后, 需求变更, 加字段减字段, 都会涉及到程序修改, 不好维护, 因此, 第一种方案就被否决了。

公司于是选择了第二个方案, 在前端用 js 生成 html, 发给后端 html 转 pdf。

在实现的过程中, 就碰到了以下的几个问题难以解决。
1. 前端的 html, 与后端生成的 pdf, 存在着明显的字体, 页面样式等差异。<br>
对于一份较长的文档, 文档里面有一个长表格, 打印时会出现多页。<br>
前端 js 代码, 按定义的高度, 生成一个 div, 逐条添加页面的内容, 当超过一页内容时, 重新生成一个 div, 再往里面添加内容，形成多个页面。<br>
当把这多个页面, 发往后端, 用 html 转 pdf 框架, 生成 pdf 后, 就发现，在前端显示好好的 html 页面, 由于前端 windows 的字体,与后端环境 linux 的差异,	以及字体渲染的差异, 以及前端 windows 环境的浏览器,与后端环境 html 转 pdf 框架对 css 样式的解析不同, 后端生成的 pdf, 会出现页面内容过小, 或过大的问题，打印的效果不好。<br>
例如：一个 A4 的页面, 前端一个 html 页面, 填满了整个 div, 展示的非常漂亮，而生成 pdf 时, 由于字体偏小, 或者是框架转化的原因, 生成的这个 pdf 页面，其显示出来的内容偏小，整个页面下方存在大量的空白。<br>
而由于 html 转 pdf 的不透明, 这个问题难以解决。

2. 页面上存在复杂的 js 控制显示隐藏, 页面代码较难维护。<br>
例如: 当表格某一列调整列宽时, 可能这一列中的文字就会出现换行, 此时, 原先位于表尾的那部分内容, 就会被挤出页面边界，需要触发页面元素高度控制等一系列代码。

在一段失败的开发测试后, 笔者开发了 Nanhu-print-java 框架, 较为顺利的解决了公司碰到的问题。

Nanhu-print-java 定义了一个 xml 格式的文件, 定义了 if, forEach, set 等动态标签，以及 table, div, span 等静态标签。<br>约束用户只能使用这些标签。<br>
在前端，通过 Nanhu-print-js, 解析 xml 生成 html，在浏览器显示。<br>
在后端, 通过解析 xml 生成 pdf, 使得 pdf 的字体等样式, 不受前端环境的影响，较好的解决了 前端展示与后端打印的差异问题。<br>
而用户的开发过程, 主要在配置 xml 格式的文件, 基本不存在复杂的代码控制，也达到了开发效率大幅提高，维护成本降低的效果。

# 2. Nanhu-print-java 的基本工作流程
	 
<img width="439" alt="work_flow_chart" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/c97363da-964e-4195-9a1c-6424f3ff54a4">

首先, Nanhu-print-java 是一个 pdf 打印框架, 其定义了自己的 XML 模型格式文件, 用户编写 XML 格式文件时, 需遵循 XSD 文件的元素定义。<br>
如上图所示，用户在使用 Nanhu-print-java, 须准备 XML模型文件 以及希望打印的业务数据, 接下来, 调用 Nanhu-print-java 的框架 API 即可完成 PDF 文件的生成。<br>
示例代码如下:
	 
<img width="556" alt="demo_code" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/01eb7fcf-3614-48bd-886f-84090ad3e904">

# 3. Nanhu-print-java 的主要功能

## 3.1. 每个页面固定表头, 最后一页固定表尾
单据打印是企业应用中常见的功能，通常要求在一个页面顶部位置，显示标题,企业名称, 在页面底部，显示表格金额汇总，日期，公司签章等信息。<br>
如果单据中表格信息比较长, 出现多页, 通常还要求每一页顶部位置, 都出现表格标题行信息。<br>
使用 Nanhu-print-java 框架, 用户可通过配置的方式, 方便快捷地完成这类功能。<br>
配置简化内容为:

```xml
<body>
    <params>
        <param name="extendToFillBody" value="default"></param>
    </params>
    <table>
        <thead showPosition="firstPage">
            BillTitle,,,,,,
        </thead>
        <thead showPosition="everyPage">
            table head content,,,,,,
        </thead>
        <tbody>
            table body content,,,,,,
        </tbody>
        <tloop>
            last page fill content,,,,,,
        </tloop>
        <tbottom>
            last page bottom content,,,,,,
        </tbottom>
    </table>
</body>
```

## 3.2. 每个页面任意位置显示页码
多页文档, 可能需要在表头显示页码, 也可能需要在表尾显示页码。<br>
用户可通过以下的配置方式, 实现在页面任意位置, 出现页码的相关信息。<br>
```xml
<div>
    <params>
        <param name="customContent" value="com.hongjinqiu.nanhuprint.eval.custom.CustomPageNumber" />
        <param name="customContentFormat" value="{currentPageNumber} of {totalPageNumber}" />
    </params>
</div>
```

## 3.3. 套打
像快递单之类的单据, 开发 pdf 打印模版时, 需要以一张图片作为背景。<br>
用户使用 Nanhu-print-java 开发这类版时, 可以设置背景图, 再调整文字的 padding 值<br>

```xml
<div backgroundSize="contain" width="100px" height="420px">
    <div paddingLeft="10px" paddingTop="24px"><span value="InvoiceCode" /></div>
</div>
``` 

## 3.4. 文字水印,图片水印
Nanhu-print-java 框架, 支持通过配置的方式, 实现文字水印或图片水印。<br>
配置如下:<br>
图片水印:
```xml
<div fontWeight="bold" paddingTop="10">
    <params>
        <param name="waterMark" value="default" />
        <param name="waterMarkOpacity" value="0.9" />
        <param name="waterMarkOffsetX" value="-150" />
        <param name="waterMarkOffsetY" value="0" />
        <param name="waterMarkImage" value="http://localhost:8891/images/camel.png" />
        <param name="waterMarkImageWidth" value="200" />
        <param name="waterMarkImageHeight" value="78" />
        <param name="waterMarkRotation" value="45" />
        <param name="waterMarkLayer" value="default" />
    </params>
</div>
```

文字水印:

```xml
<div>
    <params>
        <param name="waterMark" value="default" />
        <param name="waterMarkText" value="I am waterMarkText" />
        <param name="waterMarkOpacity" value="0.5" />
        <param name="waterMarkTextFontSize" value="24" />
        <param name="waterMarkOffsetX" value="0" />
        <param name="waterMarkOffsetY" value="100" />
        <param name="waterMarkRotation" value="45" />
        <param name="waterMarkLayer" value="under" />
    </params>
</div>
```

## 3.5. 表格行不同背景交替打印
如果你有一个长表格, 需要每一行显示不同的背景颜色, 可以通过配置的方式，方便的实现, 配置示例为:<br>

```xml
<forEach var="item" itemsJs="data.contentList" varStatus="index">
    <set valueJs="'white'" var="loopBgColor" />
    <if testJs="index %2 == 0">
        <set valueJs="'orange'" var="loopBgColor" />
    </if>
    <tr fontFamily="abc" backgroundColor="js:loopBgColor">
        <td width="100%">
            <div paddingTop="20">
                <span value="js:item"/>
            </div>
        </td>
    </tr>
</forEach>
```

## 3.6. 使用动态标签以实现复杂的显示逻辑
Nanhu-print-java 框架, 支持的动态标签有: if, forEach, macroRef, set, Macro。<br>
配置示例为:<br>

```xml
<if testJs="index %2 == 0"></if>
<forEach var="item" itemsJs="data.contentList" varStatus="index"></forEach>
```

## 3.7. 宏以实现重复显示块的引用
页面里面, 如果存在重复的代码显示块, 可以将重复的代码显示块, 给放到 macro 标签中, 再在其它的地方进行引用。<br>

```xml
<macro name="addressBillingMacro">
    <div cls="f12">
        <span value="wwww"/>
    </div>
</macro>
<macroRef name="addressBillingMacro"/>
```

## 3.8. 单元格内缩小字体以显示完整内容
在单据的打印中, 有时候会出现单元格宽度固定, 但是单元格内容过长的情景, 可以通过 `scaleToFitContentByPdf` 参数配置, 方便地实现内容缩放。<br>
配置示例:<br>

```xml
<div width="20px" scaleToFitContentByPdf="true">
    <span value="RMB 999,999,999.99" />
</div>
```

## 3.9. 可设置单元格宽度随单元格内容动态变化
如果你想要文字不缩小，也不换行, 单元格宽度随内容变化, 可以通过如下的配置方式实现:<br>

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

## 3.10. 数量,单价,金额等字段的格式化
数量, 单价, 金额等字段, 通常需要格式化展示.<br>
用户可以通过自己在应用程序格式化的方式, 将值传给框架, 也可以在通过框架提供的配置, 实现对这些字段的格式化:<br>

```xml
<span value="js:item.item_price" format="num"/>
<span value="js:item.item_price" format="unitPrice"/>
<span value="js:item.item_price" format="amt"/>
```
