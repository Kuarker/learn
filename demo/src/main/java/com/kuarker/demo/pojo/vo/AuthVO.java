package com.kuarker.demo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-7
 **/
@Data
@Accessors(chain = true) // 使得set方法返回自身，可以开启链式编程 AuthVO authVO = new AuthVO();authVO.setDepartmentUuid("rr").setMobile("tt");
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthVO implements Serializable {

    /**
     * 酒店uuid
     */
    @JsonProperty("department_uuid")
    @JsonAlias({"departmentUuid"})
    private String departmentUuid;

    /**
     * 手机号
     */
    @JsonProperty("mobile")
    private String mobile;

    /**
     * 房间号
     */
    @JsonAlias({"roomNo"})
    @JsonProperty("room_no")
    private String roomNo;


}
