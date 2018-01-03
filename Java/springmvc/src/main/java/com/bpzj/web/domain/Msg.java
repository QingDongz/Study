package com.bpzj.web.domain;

import java.util.HashMap;
import java.util.Map;

public class Msg {

    // 状态码
    private int code;
    // 提示信息
    private String message;
    // 服务器返回的信息
    private Map<String, Object> backValue = new HashMap<>();

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMessage("处理成功");
        return result;
    }

    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMessage("处理失败");
        return result;
    }

    public Msg add(String key, Object value) {
        this.getBackValue().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getBackValue() {
        return backValue;
    }

    public void setBackValue(Map<String, Object> backValue) {
        this.backValue = backValue;
    }

}
