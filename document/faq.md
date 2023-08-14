### 1. Is there some sample code for reference
You can refer to nanhu-print-java-demo<br>
Git URL: https://github.com/hongjinqiu/nanhu-print-java-demo.git

```
docker pull hjq20021984/nanhu-print-java-demo:2023-07-28.1
docker run -d -p 8891:8891 --name my-nanhu-print-java-demo hjq20021984/nanhu-print-java-demo:2023-07-28.1
```

After docker is running, visit http://localhost:8891

### 2. How to realize the development of a fixed header for each page and a fixed footer for the last page

For reference: nanhu-print-java-demo/src/main/resources/templates/printconfig/r_head_body_r_tail.xml

Git URL: https://github.com/hongjinqiu/nanhu-print-java-demo.git

The basic page format is:

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

### 3. Must the first element be a table?

Because the framework implements the fixed table header algorithm, it takes the first table element for calculation, therefore, it is recommended that the first element be table.

The contents of the page are put into the table.

### 4.	Can the height of a row in the table exceed the page height?

When the program implements the fixed header algorithm, it will calculate the height of a single row. <br>If the height of this row cannot fit on the current page, the content of this row will be placed on the next page.<br>
Therefore, the height of a row in the table cannot exceed the height of the page, so as to avoid stretching the pdf page.

### 5. Can the tloop element not be configured? Can the content of the tloop element be empty?

If you use the extendToFillBody configuration, then the table element needs to add the tloop child element.<br>
The content of the tloop element is used to fill the content of the page on the last page, so that the bottom can be displayed at the bottom of the page.<br>
The content of tloop cannot be empty.<br>
The content of the td element in tloop can be set as: `<span value=" "/>`, so that its height will not be empty, and the program will not loop infinitely.

