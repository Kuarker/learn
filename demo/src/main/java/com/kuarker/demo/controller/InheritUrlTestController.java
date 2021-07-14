package com.kuarker.demo.controller;

import com.kuarker.demo.api.InheritUrlTestApi;
import com.kuarker.demo.config.RabbitMQConfig;
import lombok.Data;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-5
 **/
@RestController
@Data
@ConfigurationProperties(prefix = "test")
public class InheritUrlTestController implements InheritUrlTestApi {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TestMap testMap;

    private String name = "hello";

    private Map<String,String> map;
    @Override
    public String getName(String suffix) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.CHECK_OUT_QUEUE,RabbitMQConfig.CHECK_OUT_QUEUE_ROUTING_KEY,
                "商家账号通过审核"+suffix);
        return name + " " + suffix;
    }
}
