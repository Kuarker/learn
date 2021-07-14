package com.kuarker.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/5
 **/
@Data
public class R<T> implements Serializable {
    private int code = 0;
    private String msg = "ok";
    private T data;

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(T data) {
        this.data = data;
    }

    public R() {
    }

    public static <T> R<T> ok(T data) {
        return new R(data);
    }

    public static <T> R<T> ok() {
        return new R();
    }

    public static <T> R<T> error() {
        return new R(500, "系统发生错误！");
    }

    public static <T> R<T> error(String msg) {
        return new R(500, msg);
    }

    public static <T> R<T> error(Integer code, String msg) {
        return new R(code, msg);
    }
}
