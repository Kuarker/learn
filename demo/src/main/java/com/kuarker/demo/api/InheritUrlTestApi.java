package com.kuarker.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-5
 **/
@RequestMapping("/test")
public interface InheritUrlTestApi {

    /**
     * @param suffix 输入后缀
     * @return 名字
     */
    @GetMapping("/get")
     String getName(String suffix);

    /**
     * @param suffix 输入后缀
     * @return 名字
     */
    @PutMapping("/testPost")
    String testPost(String suffix);
}
