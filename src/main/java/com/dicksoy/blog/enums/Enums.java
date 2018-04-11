package com.dicksoy.blog.enums;

/**
 * 使用枚举表述常量数据字典
 */
public enum Enums {
	
	SUCCESS(200, "ok"),
	ERROR(500, "internalError"),
	PARAMETER_ERROR(501, "parameterError"),
	DATA_EMPTY(502, "dataIsEmpty")
	;
	
	private Integer code;
	private String msg;
	
	private Enums(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
