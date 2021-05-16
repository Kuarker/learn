package com.kuarker.nacos.provider.api;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/16
 **/
@RequestMapping("/nacos-provider")
public interface ConfigApi {

    @RequestMapping("/test")
    public String test();
}
