package com.kuarker.nacos.provider.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/16
 **/
@RequestMapping("/provider")
public interface ConfigApi {

    @GetMapping("/test")
    public String test(@RequestParam("key") String key);
}
