package com.kuarker.nacos.provider.controller;


import com.kuarker.nacos.provider.api.ConfigApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/13
 **/
@RestController // 必须使用在实现类上
@RefreshScope // 必须使用在实现类上
public class ConfigController implements ConfigApi {
    @Value("${my.config}")
    private String config;


    @Override
    public String test(String key) {
        System.out.println("-----------------"+key+"--------------");
        return config;
    }
}
