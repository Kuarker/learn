package com.kuarker.demo.config.fonfig.config2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-11-19
 **/
@Aspect
@Component
public class AopConfig {

    @Pointcut("execution(* com.kuarker.demo.controller.AopController.test(..))")
    public void point() {
    }

}
