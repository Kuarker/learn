package com.kuarker.common.vo.exp;

import com.kuarker.common.vo.R;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-2
 **/
@Slf4j
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

//    public static <T> T getData(Supplier<T> supplier, String errorMsg) {
//        try {
//            return supplier.get();
//        } catch (Exception e) {
//            log.info("异常信息 {}", e);
//            throw new RuntimeException(errorMsg);
//        }
//    }
//
//    public static <T> T getData(Supplier<T> supplier, String errorMsg, Integer code) {
//        try {
//            return supplier.get();
//        } catch (Exception e) {
//            log.info("异常信息 {}", e);
//            throw new CustomException(errorMsg, code);
//        }
//    }
//
//    public static <T> T getDataAndCheckNull(Supplier<T> supplier, String errorMsg, Integer code) {
//        T t = null;
//        try {
//            t = supplier.get();
//        } catch (Exception e) {
//            log.info("异常信息 {}", e);
//            throw new CustomException(errorMsg, code);
//        }
//        if (Objects.isNull(t)) {
//            throw new CustomException(errorMsg, code);
//        } else if (t instanceof Collection) {
//            if (CollectionUtils.isEmpty((Collection<?>) t)) {
//                throw new CustomException(errorMsg, code);
//            }
//        }
//        return t;
//    }
//
//    public static <T> T getDataAndCheckNull(Supplier<T> supplier, String errorMsg) {
//        T t;
//        try {
//            t = supplier.get();
//        } catch (Exception e) {
//            log.info("异常信息 {}", e);
//            throw new CustomException(errorMsg);
//        }
//        if (Objects.isNull(t)) {
//            throw new CustomException(errorMsg);
//        } else if (t instanceof Collection) {
//            if (CollectionUtils.isEmpty((Collection<?>) t)) {
//                throw new CustomException(errorMsg);
//            }
//        }
//        return t;
//    }
}
