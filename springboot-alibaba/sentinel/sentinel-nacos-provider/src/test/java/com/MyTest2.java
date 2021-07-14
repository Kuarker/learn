package com;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-6-18
 **/
public class MyTest2 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        for (int i = 0; i < 10; i++) {
            System.out.println(now.getDayOfWeek().getValue());
            now = now.plusDays(1);
            System.out.println(String.format("日期 %s", now.toString()));
            System.out.println(new BigDecimal("120").toString());
        }
    }
}
