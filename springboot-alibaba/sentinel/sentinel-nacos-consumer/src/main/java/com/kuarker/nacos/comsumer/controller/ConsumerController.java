package com.kuarker.nacos.comsumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/16
 **/
@RestController
@RequestMapping("/nacos-consumer")
public class ConsumerController {

    public String test(){
        return "ok";
    }
}
