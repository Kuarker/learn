package com.kuarker.nacos.comsumer.controller;

import com.google.common.collect.Maps;
import com.kuarker.nacos.comsumer.feign.provider.ProviderFeign;
import com.kuarker.nacos.consumer.api.ConsumerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/16
 **/
@RestController
public class ConsumerController implements ConsumerApi {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProviderFeign providerFeign;

    @Override
    public String test(String key) {
        Map<String, String> param = Maps.newHashMap();
        param.put("key", key);
        final String test = providerFeign.test(key);
        //return restTemplate.getForObject("http://nacos-provider/provider/test",String.class,param);
        return test;
    }

}
