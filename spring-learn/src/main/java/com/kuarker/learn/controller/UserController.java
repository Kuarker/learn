package com.kuarker.learn.controller;

import com.kuarker.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-13
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

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
}
