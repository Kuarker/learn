package com.kuarker.nacos.comsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/16
 **/
@Configuration
public class RpcConfig {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> httpMessageConverter : converters) {
            if(httpMessageConverter instanceof MappingJackson2HttpMessageConverter){
                ArrayList<MediaType> mediaTypes = new ArrayList<>();
                mediaTypes.add(MediaType.ALL);
                ((MappingJackson2HttpMessageConverter) httpMessageConverter).setSupportedMediaTypes(mediaTypes);
            }
        }
        return restTemplate;
    }
}
