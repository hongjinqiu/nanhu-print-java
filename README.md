# What is nanhu-print-java

nanhu-print-java is a xml to pdf generation framework implemented in java language. 

Users can configure a file in xml format and prepare the json data format they want to print.

Then call the nanhu-print-java framework API to complete the generation of a PDF file.

nanhu-print-java can help users complete these functions that are common in enterprise applications and difficult to achieve with direct code programming by configuring xml:

- Each page has a fixed header, and the last page has a fixed footer (repeat headers and footers fixed to top and bottom on every page).
- Display the page number anywhere on each page.
- Print with template(use an image as background)
- Watermark
- Alternate printing of different backgrounds in the table rows

Cooperating with the nanhu-print-js framework on the web front end, the pdf printing format can be customized.

It is the first time to contact nanhu-print-java, please continue to read this chapter to understand the rich functions and core concepts provided by nanhu-print-java;<br>
If you want to quickly experience nanhu-print-java, please refer to [Quick Start](document/quick_start.md) 

#### nanhu-print-java design concept and core functions

- [Introduction](document/introduction.md)
- [Architecture](document/architecture.md)
- [Extensibility](document/extensibility.md)
- [Quick Start](document/quick_start.md)
- [Faq](document/faq.md)

maven configuration

```xml
<dependency>
    <groupId>io.github.hongjinqiu</groupId>
    <artifactId>nanhu-print-java</artifactId>
    <version>1.0.4</version>
</dependency>
```

Next, refer to [Quick Start](document/quick_start.md) to implement your first nanhu-print-java program

Demo project docker address:
```
docker pull hjq20021984/nanhu-print-java-demo:1.0.4
docker run -d -p 8891:8891 --name my-nanhu-print-java-demo hjq20021984/nanhu-print-java-demo:1.0.4
```

When docker is running, visit `http://localhost:8891`

Development video can refer to: `https://youtu.be/vdTSc8rXr9M`
