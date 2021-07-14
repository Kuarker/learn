package com.kuarker.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-5
 **/
@EnableFeignClients(basePackages = {"com.kuarker.demo.api"})
@SpringBootApplication
@EnableConfigurationProperties
public class DemoApp {


    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class,args);

    }
}
