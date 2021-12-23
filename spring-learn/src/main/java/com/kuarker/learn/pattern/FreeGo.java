package com.kuarker.learn.pattern;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-23
 **/
@Component
public class FreeGo implements LockStrategy{


    private Integer type=100;

    @Override
    public Integer getType() {
        return this.type;
    }

    @Override
    public String getPassword() {
        return "freeGo";
    }
}
