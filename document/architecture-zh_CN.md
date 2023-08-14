# 1.架构

用户通过编写由 nanhu-print-java/src/main/resources/xsd/nanhuprint.xsd 所约束的 XML 格式配置文件, 结合自己的业务数据, 
再调用 Nanhu-print-java 框架的 API, 即可生成 PDF 文件。

XML 格式配置文件, 即为 Nanhu-print-java 框架的核心。

Nanhu-print-java 框架通过定义了以下几个组件, 来解析 XML, 并生成 PDF, 调用入口类为: `NanhuprintInterpreter`。

代码的整体流程如下:

<img width="531" alt="while_code_flow" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/e261f56e-c511-4813-8907-e3bdba235e69">

	 
## 1.1. XML 配置转 java 对象映射组件
Nanhu-print-java 框架定义 nanhuprint.xsd 文件, 再通过 jaxb 的 xjc 命令行工具, 生成了一堆 Java Bean 实体类, 	以完成从 XML 文件到 Java Bean 的映射。

## 1.2. 动态标签解析为静态标签组件

在生成 pdf 的过程中, Nanhu-print-java 进行了两轮解析

### 1.2.1. 将动态标签, 解析成静态标签,
例如:
```xml
<if testJs="!(printConfigTemplate.remarkCheckedHtml)">
    <span value="Upon receipt of your order xxxx" />
</if>
```

经过动态解析后, 其变为:

`<span value="Upon receipt of your order xxxx" />`

### 1.2.2. 将静态标签解析成 PDF 元素

## 1.3. XML 元素转化成 PDF 元素解析组件

框架中的 TableEval, DivEval 等 IEval 的接口实现类,  即为 XML -> PDF 的转化解析组件。

转化过程为:

<img width="411" alt="xml_to_pdf" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/11fc0bd0-f898-4ef4-81ae-4768b20ed92d">

## 1.4. 表达式解析器
这一个配置里面 `<if testJs="!(printConfigTemplate.remarkCheckedHtml)"></if>`, `!(printConfigTemplate.remarkCheckedHtml)` 就是一个表达式。

Nanhu-print-java 框架, 规定表达式的语法为 js 语法, 表达式解析的实现类为: `NanhuprintExpressionEvaluator`。

## 1.5. 参数解析器
一些复杂的页面, 难以用配置的方式实现, 只能用配置参数的方式实现。

几个重要的参数有:

- `extendToFillBody`: 实现每页固定表头表尾等功能
- `waterMark`: 实现水印功能
- `customContent`: 实现代码自定义内容的功能

# 2. 部署架构

## 2.1. 内嵌到应用程序中
在你的应用程序中, 通过以下的 maven 配置, 即可在应用程序中, 使用 Nanhu-print-java 框架 的功能。
```xml
<dependency>
    <groupId>io.github.hongjinqiu</groupId>
    <artifactId>nanhu-print-java</artifactId>
    <version>1.0.3</version>
</dependency>
```

## 2.2. 包装成一个微服务进行 web 调用
笔者 github 主页, 有一个 nanhu-print-java-demo 项目, 这个项目, 演示了 nanhu-print-java 的框架功能。

这个项目就是一个 springboot 的微服务, 后端对外提供了 web 地址调用生成 pdf 的功能。

用户可拉取这个项目的代码, 再稍微改造, 便可以形成自己的微服务功能。

nanhu-print-java-demo 项目的 docker 拉取和运行方式为:
```
docker pull hjq20021984/nanhu-print-java-demo:2023-07-28.1
docker run -d -p 8891:8891 --name my-nanhu-print-java-demo hjq20021984/nanhu-print-java-demo:2023-07-28.1
```

web 访问 http://localhost:8891
