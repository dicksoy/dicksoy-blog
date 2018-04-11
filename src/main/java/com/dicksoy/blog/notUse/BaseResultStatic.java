package com.dicksoy.blog.notUse;

import java.io.Serializable;

public class BaseResultStatic implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* 错误码 */
	private Integer code;
	/* 提示信息 */
	private String msg;
	/* 数据 */
	private Object data;

	public static class Builder {
		
		private Integer code;
		private String msg;
		private Object data;
		
		public Builder() {

		}

		public Builder code(Integer val) {
			code = val;
			return this;
		}

		public Builder msg(String val) {
			msg = val;
			return this;
		}
		
		public Builder data(Object val) {
			data = val;
			return this;
		}
		
		public BaseResultStatic build() {
			return new BaseResultStatic(this);
		}

	}
	
	public BaseResultStatic(Builder builder) {
		code = builder.code;
		msg = builder.msg;
		data = builder.data;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}
}
