package com.kuarker.nacos.consumer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/16
 **/
@RequestMapping("/consumer")
public interface ConsumerApi {

    @GetMapping("/test")
    public String test(@RequestParam("key") String key);
}
