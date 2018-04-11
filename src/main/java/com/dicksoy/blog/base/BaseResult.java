package com.dicksoy.blog.base;

import java.io.Serializable;

public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private Object result;

    public static interface Message {
        String USER_NOT_EXIST = "用户不存在";
        String DEFAULT_SERVER_ERROR_MSG = "对不起服务出现异常";
        String DEFAULT_SUCCESS_MGS = "请求操作API成功";
        String DEFAULT_VALI_MSG = "传入数据不合法";
        String INVALID_USERPHONE_FILE = "上传文件不合法";
        String VERIFY_CODE_ERROR_MSG = "校验码错误";
        String UN_AUTH_CODE_ERROR_MSG = "未登陆";
    }

    public static interface Code {
        int OK = 200;
        int ERROR = 500;
        int UN_AUTH = 501;
        int BAD_REQUEST = 400;
    }

    public static BaseResult builder() {
        return new BaseResult();
    }

    public BaseResult code(Integer code) {
        this.code = code;
        return this;
    }

    public BaseResult msg(String msg) {
        this.msg = msg;
        return this;
    }

    public BaseResult result(Object result) {
        this.result = result;
        return this;
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
