package com.kuarker.learn.controller;

import com.kuarker.common.vo.R;
import com.kuarker.learn.bean.Bean3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-13
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private Bean3 bean3;
    @Autowired
    private Bean3 bean4;

    @Autowired
    private ThreadPoolTaskExecutor myPool;


    @GetMapping("/get")
    public R get(@RequestParam(name = "kk", defaultValue = "66") String key) {

        log.info("我进来啦");

        return R.ok("okj" + key);
    }

    @GetMapping("/aop")
    public R aop(@RequestParam(name = "kk", defaultValue = "66") String key) {
//        throw new RuntimeException("hhaha");
        UserController proxy = (UserController) AopContext.currentProxy();
        System.out.println("--------代理类--------");
        proxy.get(key);
        System.out.println("--------当前类--------");
        this.get(key);
        return R.ok("okj" + key);
    }


    @GetMapping("/pool")
    public R pool(@RequestParam(name = "kk", defaultValue = "66") String key) throws Exception {

        long start = System.currentTimeMillis();
        Future<String> hh = myPool.submit(() -> {
            log.info("--A--");
            TimeUnit.SECONDS.sleep(5);
            log.info("--B--");
            return "ok";
        });

        // 若是不使用get，submit（）是异步执行的
        myPool.execute(() -> {
            log.info("--C--");

        });
        // 会在这里阻塞，直到有结果返回
        try {
            hh.get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("出现异常：{} ", e.getMessage());
        }
        hh.get();

        String s = hh.get();
        log.info("耗时 {} ms,响应结果 {}", System.currentTimeMillis() - start, s);
        return R.ok("okj" + key);
    }

    @GetMapping("/completableFuture")
    public R completableFuture(@RequestParam(name = "kk", defaultValue = "66") String key) throws Exception {


        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            log.info("--A--");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("--B--");
            return key;
        }, myPool);

        supplyAsync.whenCompleteAsync((k, throwable) -> {
            log.info("--{}--", k);
        }, myPool); // CompletableFuture 需要指定线程池，不然会使用框架的默认线程池
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            log.info("--C--");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("--D--");

        }, myPool);
        runAsync.whenComplete((k, ex) -> {

            log.info("--{}--", k);
            log.info("--E--");

        });
        return R.ok("okj" + key);
    }
}
