package com.kuarker.demo.config;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-7
 **/
@Configuration
public class FreeGoConfig implements RequestInterceptor {

    @Value("${freeGo.appId:ftubqxXunEKQ}")
    private String appId = "ftubqxXunEKQ";

    @Value("${freeGo.appId:3f5dd66bb063d88e3fecdc59}")
    private String appSecret = "3f5dd66bb063d88e3fecdc59";

    private String APP_ID = "AppId";

    private String NONCE_STR = "NonceStr";

    private String TIMESTAMP = "Timestamp";

    private String SIGN = "Sign";

    private String STR_FMT = "%s=%s";

    private String KEY_FMT = "&key=";

    private String MODE_VALUE = "normal";

    private String MODE_KEY = "Mode";


    @Override
    public void apply(RequestTemplate requestTemplate) {

        Map<String, String> freeGoHeaderMap = getFreeGoHeaderMap();
        System.out.println(freeGoHeaderMap);
        for (Map.Entry<String, String> entry : freeGoHeaderMap.entrySet()) {
            requestTemplate.header(entry.getKey(), entry.getValue());
        }
    }


    private Map<String, String> getFreeGoHeaderMap() {
        String timestamp = Long.toString(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
        String nonceStr = UUID.fastUUID().toString(true).substring(0, 16);
        Map<String, String> map = new TreeMap<>();
        // 生成一个字符串
        map.put(APP_ID, appId);
        map.put(NONCE_STR, nonceStr);
        map.put(TIMESTAMP, timestamp);
        map.put(MODE_KEY, MODE_VALUE);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (StrUtil.isNotBlank(entry.getValue())) {
                list.add(String.format(STR_FMT, entry.getKey(), entry.getValue()));
            }
        }
        String collect = list.stream().collect(Collectors.joining("&"));
        String newStr = collect + KEY_FMT + this.appSecret;
        String sign = SecureUtil.md5(newStr);
        map.put(SIGN, sign);
        return map;
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
