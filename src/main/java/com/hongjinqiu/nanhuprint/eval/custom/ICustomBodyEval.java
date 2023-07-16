package com.hongjinqiu.nanhuprint.eval.custom;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.hongjinqiu.nanhuprint.model.Body;

import java.util.List;
import java.util.Map;

public interface ICustomBodyEval {
    List<Element> evalToPdf(Document document, Body body, Map<String, Object> env);
}
