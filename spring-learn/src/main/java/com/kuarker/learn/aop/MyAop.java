package com.kuarker.learn.aop;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-14
 **/
@Aspect
@Component
@Slf4j
@Data
public class MyAop {

    private String name;

    @Pointcut("execution(* com.kuarker.learn.controller.UserController.get(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object run2(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法参数值数组
        Object[] args = joinPoint.getArgs();
        //得到其方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
        Object result = joinPoint.proceed(args);
        log.info("响应结果 {} ", result);
        return result;
    }


}
