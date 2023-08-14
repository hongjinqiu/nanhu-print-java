# Quick Start

Using the nanhu-print-java framework to generate PDF Getting Started Guide

## 1. Target

Develop a pdf generation application based on the nanhu-print-java framework from scratch, and understand how the nanhu-print-java framework is developed.

## 2. Difficulty
Low

## 3. Environmental requirements
- System: Windows, Linux, MacOS
- maven
- JDK 8 and above (JDK17 is recommended)
- IntelliJ IDEA(Optional)

## 4. Project Introduction

In this project, maven will be used to import the jar package of the nanhu-print-java framework to simulate the development process using the nanhu-print-java framework in a real environment.

The code structure is:
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

## 5. Hands-on practice (from zero code development version)

From this section onwards, the project will be built and tested based on IntelliJ IDEA.

### 5.1. Initialize project
 

As shown in the picture above, a basic project can be established.

### 5.2. Adding Maven dependency
After initializing the project, we need to add maven dependencies related to the nanhu-print-java framework jar package first.

 

### 5.3. Add XML configuration, and JSON business data
 
 

In the hello_world.xml configuration, we have referenced a variable `businessData`, and the syntax must start with `js:`.
In hello_world.json configuration, we defined a variable `businessData="I am businessData"`

### 5.4. Write programs and generate pdf

 
### 5.5. View the generated PDF file
 

## 6. More

You can download the nanhu-print-java-demo project to see more code samples.

git clone https://github.com/hongjinqiu/nanhu-print-java-demo.git
