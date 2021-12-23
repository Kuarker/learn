package com.kuarker.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-13
 **/
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Component
    @Scope(scopeName = "prototype")
    static class Bean {
        public void go() {
            System.out.println("----------");
        }

    }
}
