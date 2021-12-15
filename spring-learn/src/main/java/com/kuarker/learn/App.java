package com.kuarker.learn;

import cn.hutool.extra.spring.SpringUtil;
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
        Object bean3 = SpringUtil.getBean("bean3");
        System.out.println(bean3);
        Object bean4 = SpringUtil.getBean("bean4");
        System.out.println(bean4);

//        Object bean5 = SpringUtil.getBean("bean5");
//        System.out.println(bean5);
        Object bean6 = SpringUtil.getBean("bean6");
        System.out.println(bean6);

    }

    @Component
    @Scope(scopeName = "prototype")
    static class Bean {
        public void go() {
            System.out.println("----------");
        }

    }
}
