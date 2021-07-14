package com.kuarker.demo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @JsonAlias("arr_time") arr_time  反序列化 时字符串的属性
 * private LocalDate arrTime;  对象的属性
 * @author: Jiayan Lee
 * @date: 2021-7-8
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EKeyVO implements Serializable {

    /**
     * 入住时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonAlias("arr_time")
    private LocalDateTime arrTime;

    /**
     * 离店时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonAlias("dep_time")
    private LocalDateTime depTime;

    /**
     * 手机号
     */
    private String mobile;
    /**
     * 房号
     */
    @JsonAlias("room_no")
    private String roomNo;
    /**
     * 二维码文本, 扫码可以直接打开门锁小程序；
     * 微信小程序电子钥匙二维码，任何人10分钟内扫码可以获取时效内该房间电子钥匙，仅限定一个用户扫码获取钥匙
     */
    private String qrcode;
    /**
     * 打开门锁小程序的 URL Scheme，客户接收短信可以直接跳转到小程序获取电子钥匙，
     * 仅限定一个用户成功获取钥匙，如何发短信通道，接入客户自行完成实现
     */
    @JsonAlias("url_scheme")
    private String urlScheme;
}
