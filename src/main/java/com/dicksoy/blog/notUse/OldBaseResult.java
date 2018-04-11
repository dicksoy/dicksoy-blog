package com.dicksoy.blog.notUse;

import com.dicksoy.blog.enums.Enums;

public class OldBaseResult {

	/* 成功与否 */
	private boolean success;
	/* 错误码 */
	private Integer code;
	/* 提示信息 */
	private String msg;
	/* 数据 */
	private Object data;
	
	public OldBaseResult(Enums enums) {
		if (enums.getCode() == 200) {
			this.success = true;
		} else {
			this.success = false;
		}
		this.code = enums.getCode();
		this.msg = enums.getMsg();
	}
	
	/**
	 * 返回多个不同的对象（不能存在相同的对象）
	 * json键 ---> 类名小写
	 * @param enums
	 * @param datas
	 */
	public OldBaseResult(Enums enums, Object data) {
		if (enums.getCode() == 200) {
			this.success = true;
		} else {
			this.success = false;
		}
		this.code = enums.getCode();
		this.msg = enums.getMsg();
		this.data = data;
	}
	
//	出现异常，思考逻辑
//	public static BaseResult build(Enums enums) {
//		return new BaseResult(enums);
//	}
//	
//	public BaseResult resule(Object result) {
//		this.data = new JSONObject();
//		data.put(data.getClass().getSimpleName().toLowerCase(), data);
//		return this;
//	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
