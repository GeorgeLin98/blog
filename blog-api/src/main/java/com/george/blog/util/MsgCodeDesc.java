package com.george.blog.util;

import lombok.Data;

/**
 * @description 信息码枚举类
 * @date 2021.01.6
 * @author linzhuangze
 */
public enum MsgCodeDesc {

    SUCCESS(200,"成功"),
    FAIL(500,"系统异常");

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;

    MsgCodeDesc(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
