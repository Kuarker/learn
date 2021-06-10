package com;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-5-21
 **/
@Slf4j
public class MyTestForThreadLocal {
    //    private static ThreadLocal<MyObject> threadLocal = new ThreadLocal<>();
    private static int k = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            MyObject myObject = new MyObject("my" + k++);
            ThreadLocal<MyObject> threadLocal = new ThreadLocal<>();
            log.info("创建0.5GB对象 {}", myObject);
            threadLocal.set(myObject);
            Runnable runnable = () -> {
                threadLocal.set(myObject);
            };
            new Thread(runnable).start();
            System.gc();
        }
    }

    static class MyObject {
        private String name;
        //        0.5GB
        private Byte[] memory = new Byte[1024 * 1024 * 1024 * 1024];

        public MyObject(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyObject{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
