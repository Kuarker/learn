package com.kuarker.demo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-7
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseVO<T> implements Serializable {
    /**
     * 响应状态码
     */
    private String errcode;
    /**
     * 提示信息
     */
    private String msg;
    /**
     *  追踪uuid
     */
    private String uuid;

    /**
     * 数据
     */
    private T data;



}
