package com.kuarker.demo.controller;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-14
 **/
@Data
@ConfigurationProperties(prefix = "test")
@ToString
@Component
public class TestMap {

    private Map<String,String> map;
}
