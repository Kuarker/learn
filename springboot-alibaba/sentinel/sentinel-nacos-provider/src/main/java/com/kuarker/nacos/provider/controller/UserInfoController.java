package com.kuarker.nacos.provider.controller;

import com.kuarker.common.vo.R;
import com.kuarker.nacos.provider.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-6-11
 **/
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/page")
    private R page() {
        return R.ok(userInfoService.doPage());
    }
}
