package com.kuarker.demo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 *     @JsonAlias("room_no") 反序列化前的字符串，可以有多个不同json属性对应一个对象属性
 *     @JsonProperty("room_no") 反序列化前、序列化后的字符串的值，只有一个值
 * @author: Jiayan Lee
 * @date: 2021-7-7
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PmsEventVO implements Serializable {

    /**
     * 具体门店的uuid具体由福瑞狗提供
     *
     * 是否必填 ： 是
     */
    @JsonAlias({"departmentUuid"})
    @JsonProperty("department_uuid")
    private String departmentUuid;

    /**
     * 推送类型：
     * checkin：入住
     * checkout：离店退房
     * changeroom：换房
     * changemobile：更新手机号
     * keepon：续住，修改入住时间
     * addtenant：同一订单添加入住人
     * rmtenant：同一订单移除入住人
     *
     * 是否必填 ： 是
     */
    @JsonAlias({"eventType"})
    @JsonProperty("event_type")
    private String eventType;

    /**
     * 住客手机号, 针对该手机号生产对应电子钥匙
     *
     * 是否必填 ： 是
     */
    private String mobile;

    /**
     * PMS房间号请与freego保持一致
     *
     * 是否必填 ： 是
     */
    @JsonAlias({"roomNo"})
    @JsonProperty("room_no")
    private String roomNo;

    /**
     * PMS唯一入住单单号，方便PMS数据核查
     *
     * 是否必填 ： 是
     */
    @JsonAlias({"orderId"})
    @JsonProperty("order_id")
    private String orderId;

    /**
     * 入住时间. Unix 时间戳 如 1600935273(秒级)
     *
     * 是否必填 ： 是  (退房除外)
     */
    @JsonAlias({"arrTime"})
    @JsonProperty("arr_time")
    private String arrTime;

    /**
     * 离店时间. Unix 时间戳 如 1600935273(秒级)
     *
     * 是否必填 ： 是  (退房除外)
     */
    @JsonAlias({"depTime"})
    @JsonProperty("dep_time")
    private String depTime;

    /**
     * 旧手机号
     *
     * 是否必填 ：否(更换手机号时必填)
     */
    @JsonAlias({"oldMobile"})
    @JsonProperty("old_mobile")
    private String oldMobile;

    /**
     * 原入住房间号
     *
     * 是否必填 ：否(更换房间时必填)
     */
    @JsonAlias({"oldRoomNo"})
    @JsonProperty("old_room_no")
    private String oldRoomNo;

    /**
     * 性别：{男 => 10, 女 => 20}
     * 是否必填 ：否
     */
    @JsonProperty("gender")
    private String gender;

    /**
     * 出生日期："1999-01-02"
     * 是否必填 ：否
     */
    @JsonProperty("birth")
    private String birth;

}
