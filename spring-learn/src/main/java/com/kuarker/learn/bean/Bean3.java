package com.kuarker.learn.bean;

import com.kuarker.learn.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-15
 **/
public class Bean3 {

    @Autowired
    private UserController userController;
}
