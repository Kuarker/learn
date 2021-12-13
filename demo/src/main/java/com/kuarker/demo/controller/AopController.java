package com.kuarker.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-11-19
 **/
@RestController
//@Controller
@RequestMapping("/test2")
public class AopController {

    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;

    @GetMapping("/get")
    public String test() throws IOException {
        System.out.println("session:---->>> " + session.getId());
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            System.out.print(attributeNames.nextElement() + "--->>");
        }
        session.setAttribute("kk" + System.currentTimeMillis(), "yy" + System.currentTimeMillis());
        System.out.println(request);
        Cookie cookie = new Cookie("kk", "yy" + System.currentTimeMillis());
        response.addCookie(cookie);
        System.out.println(response);
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        response.sendRedirect("http://www.baidu.com");
        return String.valueOf(currentTimeMillis);
    }


}
