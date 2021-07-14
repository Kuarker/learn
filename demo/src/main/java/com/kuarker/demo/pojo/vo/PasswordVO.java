package com.kuarker.demo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-8
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PasswordVO {
    private Long id;
    /**
     * Sdk中使用的Authorization
     */
    private String token;
    /**
     * 版本号
     */
    private String version;
    /**
     * 是否是在线
     */
    @JsonAlias({"http_online"})
    private Boolean httpOnline;
    /**
     * 是否有密码
     */
    @JsonAlias({"has_passwd"})
    private Boolean hasPasswd;
    /**
     * 锁的token
     */
    @JsonAlias({"lock_Token"})
    private String lockToken;
    /**
     * 版本
     */
    private String ver;
    /**
     * 设备号
     */
    @JsonAlias({"device_id"})
    private String deviceId;
    /**
     * 时钟密码
     */
    private String password;
    /**
     * 密码过期时间 unix时间（秒）
     */
    @JsonAlias({"password_expires_at"})
    private Long passwordExpiresAt;
    /**
     * Token过期时间 unix时间（秒）
     */
    @JsonAlias({"expires_at"})
    private Long expiresAt;

}
