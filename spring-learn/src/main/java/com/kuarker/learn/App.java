package com.kuarker.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-13
 **/
//@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Component
    static class Bean {

    }
}
