package com.kuarker.common.vo;

import lombok.Data;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/5
 **/
@Data
public class R {
    private int code = 0;
    private String msg = "ok";
    private Object data;

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(Object data) {
        this.data = data;
    }

    public R() {
    }

    public static R ok(Object data) {
        return new R(data);
    }

    public static R ok() {
        return new R();
    }

    public static R error() {
        return new R(500, "系统发生错误！");
    }

    public static R error(String msg) {
        return new R(500, msg);
    }
}
