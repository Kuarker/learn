package com.kuarker.learn.pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-23
 **/

@Configuration
public  class LockHandler {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<Integer, LockStrategy> map = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, LockStrategy> map = applicationContext.getBeansOfType(LockStrategy.class);

        map.forEach((k, v) -> {
            this.map.put(v.getType(), v);
        });
    }

    public LockStrategy getLockStrategy(Integer type) {
        return this.map.get(type);
    }

}
