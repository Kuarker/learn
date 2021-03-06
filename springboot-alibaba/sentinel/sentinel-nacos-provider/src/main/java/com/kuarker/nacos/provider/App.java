package com.kuarker.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/13
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
