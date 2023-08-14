# Quick Start

使用 nanhu-print-java 框架来生成 PDF 入门指南

## 1.目标
从零开始基于 nanhu-print-java 框架开发 pdf 生成应用，了解 nanhu-print-java 框架的配置方法。

## 2.难度
低

## 3.环境要求
- 系统：Windows、Linux、MacOS
- maven
- JDK 8及以上（推荐JDK17）
- IntelliJ IDEA（可选）

## 4.项目介绍
本次项目中, 将使用 maven 引入 nanhu-print-java 框架 jar 包, 模拟真实环境下, 使用 nanhu-print-java 框架进行开发的过程。<br>

其代码结构为:<br>

```
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─hongjinqiu
│  │  │          └─demo
│  │  │                  HelloWorld.java
│  │  │
│  │  └─resources
│  │          hello_world.json
│  │          hello_world.xml
```

## 5.动手实践（从零代码开发版开始）
	
从本节开始，项目将基于IntelliJ IDEA进行构建和测试。

### 5.1. 初始化项目

<img width="960" alt="init_project" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/ff619512-8881-4a65-9029-e4b89e646c67">
 
如上图，一个基本的工程就可以建立起来了。

### 5.2.添加Maven依赖

初始化项目后，我们需要先添加 nanhu-print-java 框架 jar 包相关的maven依赖。
 
<img width="960" alt="add_maven" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/ffa0dac1-6a11-4351-bb8d-b1d205ec0e86">

### 5.3. 添加 xml 配置, 和 json 业务数据

<img width="960" alt="hello_world_xml" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/99f53af2-264a-46a0-b535-f404c6a2054d">

<img width="960" alt="hello_world_json" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/2e5232a2-85c5-46aa-8e38-b894fe9b13c8">  

在 hello_world.xml 配置中, 我们引用了一个变量 `businessData`, 语法必须以 `js:` 开头。<br>
在 hello_world.json 配置中, 我们定义了一个变量 `businessData="I am businessData"`<br>

### 5.4. 编写程序,生成 pdf

<img width="960" alt="hello_world_java" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/68aec38a-e615-487b-92e8-7337b1bcf3b7">

### 5.5. 查看生成的 PDF 文件

<img width="960" alt="hello_world_pdf" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/49630bd7-f284-42e8-9bae-7ecc12d32360">

### 6. More

你可以下载 nanhu-print-java-demo 项目, 以察看更多代码示例。<br>

git clone https://github.com/hongjinqiu/nanhu-print-java-demo.git
