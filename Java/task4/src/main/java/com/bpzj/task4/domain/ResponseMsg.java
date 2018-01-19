package com.bpzj.task4.domain;

import sun.awt.AppContext;

import java.util.HashMap;
import java.util.Map;

public class ResponseMsg {
    private int code;
    private String msg;
    private Map<String, Object> backMag = new HashMap<>();

    public static ResponseMsg success() {
        ResponseMsg result = new ResponseMsg();
        result.setCode(100);
        result.setMsg("处理成功");
        return result;
    }

    public static ResponseMsg fail() {
        ResponseMsg result = new ResponseMsg();
        result.setCode(200);
        result.setMsg("处理失败");
        return result;
    }

    public ResponseMsg add(String key, Object value) {
        this.getBackMsg().put(key, value);
        return this;
    }

    // *************************************************
    // setter and getter
    private void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    private void setMsg(String msg) {
        this.msg = msg;
    }
    private Map<String, Object>  getBackMsg() {
        return backMag;
    }

    // ************************************************
    // 构造器

    public ResponseMsg() {
        super();
    }
}
