package com.hongjinqiu.nanhuprint.enumerate;

/**
 * thead, tbottom 元素的属性 showPosition 的枚举值
 */
public enum ShowPositionEnum {
    FIRST_PAGE("firstPage", "首页"),
    EVERY_PAGE("everyPage", "每页"),
    LAST_PAGE("lastPage", "末页");

    private String code;
    private String name;

    ShowPositionEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
