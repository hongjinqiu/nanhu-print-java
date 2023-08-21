# 什么是 nanhu-print-java
nanhu-print-java 是一个用 java 语言实现的 pdf 生成框架, 用户可通过配置一个 xml 格式的文件, 准备好想打印的 json 数据格式, 

再调用 nanhu-print-java 框架API, 即可完成一个 PDF 文件的生成。

nanhu-print-java 可以通过配置 xml 的方式,帮助用户完成企业应用常见, 用直接代码编程难以实现的这些功能:

- 每个页面固定表头, 最后一页固定表尾.
- 每个页面任意位置显示页码.
- 套打
- 水印
- 表格行不同背景交替打印

在 web 前端与 nanhu-print-js 框架相配合, 可实现 pdf 打印格式自定义.

第一次接触 nanhu-print-java, 请继续阅读本章, 了解 nanhu-print-java 提供的丰富功能和核心概念;

如果您想快速体验 nanhu-print-java, 请参考 快速入门[Quick Start](document/quick_start-zh_CN.md)

nanhu-print-java 设计理念与核心功能

- [Introduction](document/introduction-zh_CN.md)
- [Architecture](document/architecture-zh_CN.md)
- [Extensibility](document/extensibility-zh_CN.md)
- [Quick Start](document/quick_start-zh_CN.md)
- [Faq](document/faq-zh_CN.md)

maven 配置

```xml
<dependency>
    <groupId>io.github.hongjinqiu</groupId>
    <artifactId>nanhu-print-java</artifactId>
    <version>1.0.4</version>
</dependency>
```

接下来参考[Quick Start](document/quick_start-zh_CN.md)来实现你的第一个nanhu-print-java程序

Docker Demo 项目地址:

```
docker pull hjq20021984/nanhu-print-java-demo:1.0.4
docker run -d -p 8891:8891 --name my-nanhu-print-java-demo hjq20021984/nanhu-print-java-demo:1.0.4
```

docker 运行起来之后, 访问 `http://localhost:8891`
