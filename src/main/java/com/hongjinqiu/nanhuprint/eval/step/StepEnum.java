package com.hongjinqiu.nanhuprint.eval.step;

public enum StepEnum {
	EVAL_DYNAMIC_ELEMENT("0", "动态标签解析阶段"),
	EVAL_TO_PDF("1", "生成 PDF 阶段");

	private String code;
	private String name;

	StepEnum(String code, String name) {
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
