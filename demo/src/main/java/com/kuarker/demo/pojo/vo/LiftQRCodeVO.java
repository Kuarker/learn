package com.kuarker.demo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-8
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiftQRCodeVO {
    /**
     * Image base64格式，请自行转化为图片
     */
    private String qrcode;
}
