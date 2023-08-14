# 1. Architecture
By writing the configuration file in XML format constrained by nanhu-print-java/src/main/resources/xsd/nanhuprint.xsd and combining their own business data,
then call the API of the Nanhu-print-java framework to generate a PDF file.

The configuration file in XML format is the core of the Nanhu-print-java framework.<br>
The Nanhu-print-java framework defines the following components to parse XML and generate PDF, and the call entry class is: NanhuprintInterpreter.<br>

The overall flow of the code is as follows:

![whole_code_flow_en](https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/7a50f5f5-bc06-4af3-9877-9ff2082aded3)

 
## 1.1. XML configuration to java object mapping component
The Nanhu-print-java framework defines the nanhuprint.xsd file, and then generates a bunch of Java Bean entity classes through the xjc command line tool of jaxb to complete the mapping from XML files to Java Beans.

## 1.2. Dynamic tags are parsed into static tag components

In the process of generating pdf, Nanhu-print-java performs two rounds of parsing.

### 1.2.1. Parsing dynamic tags into static tags

For example:
```xml
<if testJs="!(printConfigTemplate.remarkCheckedHtml)">
    <span value="Upon receipt of your order xxxx" />
</if>
```

After dynamic parsing, it becomes:

`<span value="Upon receipt of your order xxxx" />`

### 1.2.2. Parsing static tags into PDF elements

## 1.3. Convert XML elements into PDF element parsing components
The interface implementation classes of IEval such as TableEval and DivEval in the framework are XML -> PDF conversion and analysis components.

The conversion process is:

<img width="411" alt="xml_to_pdf" src="https://github.com/hongjinqiu/nanhu-print-java/assets/1661806/11fc0bd0-f898-4ef4-81ae-4768b20ed92d">

## 1.4. Expression Parser
This line configures `<if testJs="!(printConfigTemplate.remarkCheckedHtml)"></if>`, the `!(printConfigTemplate.remarkCheckedHtml)` inside is an expression.

The Nanhu-print-java framework stipulates that the grammar of expressions is js grammar, and the implementation class of expression parsing is: `NanhuprintExpressionEvaluator`.

## 1.5. Parameter Parser

Some complex pages are difficult to realize by configuration, and can only be realized by configuration parameters.

A few important parameters are:

- `extendToFillBody`: Realize functions such as fixed header and footer for each page
- `waterMark`: implement the watermark function
- `customContent`: implement the function of code custom content

# 2. Deployment Architecture

## 2.1. Embedded in the application program

In your application, you can use the functions of the Nanhu-print-java framework in your application through the following maven configuration.

```xml
<dependency>
    <groupId>io.github.hongjinqiu</groupId>
    <artifactId>nanhu-print-java</artifactId>
    <version>1.0.3</version>
</dependency>
```

## 2.2. Wrap it into a microservice for web calls
There is a `nanhu-print-java-demo project` on the author's github homepage, which demonstrates the framework functions of nanhu-print-java.

This project is a springboot microservice, and the backend provides the function of generating pdf by calling the web address.

Users can pull the code of this project and modify it slightly to form their own microservice functions.

The docker pull and run method of nanhu-print-java-demo project is as follows:

```
docker pull hjq20021984/nanhu-print-java-demo:2023-07-28.1
docker run -d -p 8891:8891 --name my-nanhu-print-java-demo hjq20021984/nanhu-print-java-demo:2023-07-28.1
```

then visit: http://localhost:8891
