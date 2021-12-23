package com.kuarker.learn.controller;

import com.kuarker.common.vo.R;
import com.kuarker.learn.pattern.LockHandler;
import com.kuarker.learn.pattern.LockStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-23
 **/
@RestController
@RequestMapping("/lock")
public class LockController {

    @Autowired
    private LockHandler lockHandler;


    @GetMapping("/getPassword")
    public R getPassword(@RequestParam("type") Integer type) {
        LockStrategy lockStrategy = lockHandler.getLockStrategy(type);
        String password = lockStrategy.getPassword();
        return R.ok(password);
    }

}
