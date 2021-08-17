package com.kuarker.common.vo.util;

import com.kuarker.common.vo.exp.BizException;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-8-17
 **/
public class MyAssert {

    public static <T> T notNull(T object, String errorMsgTemplate, Object... params) {
        return notNull(object, () -> new BizException(String.format(errorMsgTemplate, params)));

    }

    public static <T, X extends BizException> T notNull(T object, Supplier<X> supplier) throws X {
        if (Objects.isNull(object)) {
            throw supplier.get();
        } else {
            return object;
        }
    }
}
