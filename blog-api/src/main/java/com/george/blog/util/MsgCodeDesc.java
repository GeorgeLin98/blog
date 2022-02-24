package com.george.blog.util;

import lombok.Data;

/**
 * @description 信息码枚举类
 * @date 2021.01.6
 * @author linzhuangze
 */
public enum MsgCodeDesc {

    SUCCESS(200,"成功"),
    FAIL(500,"系统异常"),
    PARAMS_ERROR(10001,"参数有误"),
    ACCOUNT_PWD_NOT_EXIST(10002,"用户名或密码不存在"),
    NO_PERMISSION(70001,"无访问权限"),
    SESSION_TIME_OUT(90001,"会话超时"),
    ACCOUNT_EXIST(10004,"账号已存在"),
    NO_LOGIN(90002,"未登录");

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
