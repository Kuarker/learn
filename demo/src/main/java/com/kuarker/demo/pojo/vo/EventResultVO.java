package com.kuarker.demo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 推送事件结果
 * @author: Jiayan Lee
 * @date: 2021-7-8
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventResultVO implements Serializable {
    /**
     * 二维码访问链接
     */
    @JsonAlias("qrcode")
    private String qrcode;

    /**
     * 直接访问钥匙
     */
    @JsonAlias("url_scheme")
    private String urlScheme;
}
