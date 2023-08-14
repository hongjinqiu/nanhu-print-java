### 1. 有没有一些示例代码可供参考
可以参考 nanhu-print-java-demo<br>
git 地址: https://github.com/hongjinqiu/nanhu-print-java-demo.git

```
docker pull hjq20021984/nanhu-print-java-demo:2023-07-28.1
docker run -d -p 8891:8891 --name my-nanhu-print-java-demo hjq20021984/nanhu-print-java-demo:2023-07-28.1
```

docker 运行起来之后, 访问 http://localhost:8891

### 2.如何来实现每个页面固定表头, 最后一页固定表尾的开发

可以参考: nanhu-print-java-demo/src/main/resources/templates/printconfig/r_head_body_r_tail.xml<br>
git 地址: https://github.com/hongjinqiu/nanhu-print-java-demo.git

基本页面格式为:

```xml
<body>
    <params>
        <param name="extendToFillBody" value="default"></param>
    </params>
    <table cellspacing="0" cellpadding="0" width="100%" tableLayout="fixed">
        <thead showPosition="everyPage"></thead>
        <tbody></tbody>
        <tloop></tloop>
        <tbottom showPosition="lastPage"></tbottom>
    </table>
</body>
```

### 3.第一个元素必须为 table 吗?

因为框架实现固定表头算法时, 是取第一个表格元素来进行计算, 因此, 推荐第一个元素为 table。
页面的内容都放到 table 里面去。

### 4.表格中一行的高度可以超出页面高度吗?

程序在实现固定表头算法时, 会计算单行的高度, 如果当前页放不下这一行高度，这一行的内容会放到下一页。<br>
因此, 表格中一行的高度不可以超出页面高度, 避免撑开 pdf 页面。

### 5. tloop 元素可以不配置吗? tloop 元素内容可以为空吗?
如果你用了 extendToFillBody 的配置, 那么表格元素需要添加 tloop 子元素。<br>
tloop 元素的内容, 是用来在最后一页, 填充页面的内容, 使得底部可以展示在页面的底部。<br>
tloop 的内容不能为空。<br>
tloop 中的 td 元素, 其内容可以设为: `<span value=" "/>`, 这样其高度不会为空, 程序不会死循环。

