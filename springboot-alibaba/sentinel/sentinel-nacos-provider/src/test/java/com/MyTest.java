package com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-5-21
 **/
public class MyTest {



    public static void main(String[] args) {
//
//        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
//        String unCipher=second+","+(126378793210849821L);
//        final DES des = SecureUtil.des("DXTFCVGJBHKVFYCCVJH".getBytes());
//        final String encryptHex = des.encryptHex(unCipher);
//        final String decryptStr = des.decryptStr(encryptHex);

//        System.out.println(encryptHex);
//        System.out.println(decryptStr);
        final LocalDateTime now1 = LocalDateTime.now();
        final LocalDate localDate1 = now1.toLocalDate();
        final LocalDateTime now2 = LocalDateTime.now();
        // 继续要使用返回的新的对象
        final LocalDateTime localDateTime = now2.plusDays(2L);
        final LocalDate localDate2 = localDateTime.toLocalDate();
        System.out.println(now1);
        System.out.println(now2);
        System.out.println(localDate1.equals(localDate2));
        System.out.println(localDate1.get(ChronoField.DAY_OF_MONTH));
        System.out.println(localDate2.get(ChronoField.DAY_OF_MONTH));

    }
}
