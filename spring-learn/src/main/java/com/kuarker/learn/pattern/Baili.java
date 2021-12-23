package com.kuarker.learn.pattern;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-23
 **/
@Component
public class Baili implements LockStrategy {

    private Integer type = 200;

    @Override
    public Integer getType() {
        return this.type;
    }

    @Override
    public String getPassword() {
        return "baili";
    }
}
