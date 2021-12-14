package com.kuarker.learn.controller;

import com.kuarker.common.vo.R;
import lombok.extern.slf4j.Slf4j;
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
        throw new RuntimeException("hhaha");
//        return R.ok("okj" + key);
    }
}
