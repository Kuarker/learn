package com.kuarker.common.vo.exp;

import com.kuarker.common.vo.R;

import java.util.function.Supplier;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-2
 **/
public class ExpUtil {

    private static int success = 200;
    private static int fail = 500;

    // 处理一个R的状态码即可，非200就抛出异常
    public static void checkResponse(R r) {
        if (r.getCode() != 0) {
            throw new RemoteException(r.getMsg());
        }
    }

    public static void checkResponse(Supplier<R> supplier) {
        R r = supplier.get();
        if (r.getCode() != 0) {
            throw new RemoteException(r.getMsg());
        }
    }

}
