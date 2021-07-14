package com.kuarker.common.vo.exp;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-2
 **/
public class RemoteException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;

    public RemoteException(String message) {
        this.message = message;
        this.code = 400;
    }

    public RemoteException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public RemoteException(String message, Throwable e) {
        super(message, e);
        this.code = 400;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public Integer getCode() {
        return this.code;
    }

}


