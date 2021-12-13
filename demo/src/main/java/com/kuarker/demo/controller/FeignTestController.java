package com.kuarker.demo.controller;

import com.alibaba.fastjson.JSON;
import com.kuarker.common.vo.R;
import com.kuarker.demo.api.FreeGoApi;
import com.kuarker.demo.pojo.vo.AuthVO;
import com.kuarker.demo.pojo.vo.EKeyVO;
import com.kuarker.demo.pojo.vo.EventResultVO;
import com.kuarker.demo.pojo.vo.LiftQRCodeVO;
import com.kuarker.demo.pojo.vo.PasswordVO;
import com.kuarker.demo.pojo.vo.PmsEventVO;
import com.kuarker.demo.pojo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-7
 **/
@RestController
@RequestMapping("/freego")
public class FeignTestController {

    private String DEPARTMENT_UUID = "12e1082d-75af-4ac8-ab0e-f5e9b7abb036";

    private String ROOM_NO = "百达屋1516";
    private String CHECK_IN = "checkin";
    private String CHECK_OUT = "checkout";

    @Autowired
    private FreeGoApi freeGoApi;

    @PostMapping("/pmsEvent")
    public R pmsEventCheckIn(@RequestBody PmsEventVO pmsEvent) {

        long start = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        long end = LocalDateTime.now().plusDays(1L).toEpochSecond(ZoneOffset.of("+8"));
        pmsEvent.setArrTime(String.valueOf(start));
        pmsEvent.setDepTime(String.valueOf(end));
        System.out.println(JSON.toJSONString(pmsEvent));
        ResponseVO<EventResultVO> stringResponseVO = freeGoApi.pmsEvents(pmsEvent);
        System.out.println(JSON.toJSONString(stringResponseVO));
        return R.ok(stringResponseVO);
    }

    @PostMapping("/pmsEvent/checkIn")
    public R pmsEventCheckIn(String orderId) {

        long start = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        long end = LocalDateTime.now().plusDays(1L).toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(start);
        PmsEventVO pmsEvent = new PmsEventVO();
        pmsEvent.setDepartmentUuid(DEPARTMENT_UUID);
        pmsEvent.setRoomNo(ROOM_NO);
        pmsEvent.setEventType(CHECK_IN);
        pmsEvent.setArrTime(String.valueOf(start));
        pmsEvent.setDepTime(String.valueOf(end));
        pmsEvent.setOrderId(orderId);
        pmsEvent.setMobile("18280164776");


        System.out.println(JSON.toJSONString(pmsEvent));
        ResponseVO<EventResultVO> stringResponseVO = freeGoApi.pmsEvents(pmsEvent);
        System.out.println(JSON.toJSONString(stringResponseVO));
        return R.ok(stringResponseVO);
    }

    @PostMapping("/pmsEvent/checkOut")
    public R pmsEventCheckOut(String orderId) {

        long start = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        long end = LocalDateTime.now().plusDays(1L).toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(start);
        PmsEventVO pmsEvent = new PmsEventVO();
        pmsEvent.setDepartmentUuid(DEPARTMENT_UUID);
        pmsEvent.setRoomNo(ROOM_NO);
        pmsEvent.setEventType(CHECK_OUT);
        pmsEvent.setArrTime(String.valueOf(start));
        pmsEvent.setDepTime(String.valueOf(end));
        pmsEvent.setOrderId(orderId);
        pmsEvent.setMobile("18280164776");

        System.out.println(JSON.toJSONString(pmsEvent));
        ResponseVO<EventResultVO> stringResponseVO = freeGoApi.pmsEvents(pmsEvent);
        System.out.println(JSON.toJSONString(stringResponseVO));
        return R.ok(stringResponseVO);
    }

    @GetMapping("/auth")
    public R auth(AuthVO authVO) {
        System.out.println(JSON.toJSONString(authVO));
        ResponseVO<Object> stringResponseVO = freeGoApi.auths(authVO.getMobile(), authVO.getDepartmentUuid());
        System.out.println(JSON.toJSONString(stringResponseVO));
        return R.ok(stringResponseVO);
    }

    @PostMapping("/authsForObject")
    public R authsForObject(@RequestBody AuthVO authVO) {
        System.out.println(JSON.toJSONString(authVO));
        ResponseVO<List<EKeyVO>> stringResponseVO = freeGoApi.authsForObject(authVO);
        System.out.println(JSON.toJSONString(stringResponseVO));
        return R.ok(stringResponseVO);
    }

    @GetMapping("/authsForStr")
    public R authsForStr(AuthVO authVO) {
        System.out.println(JSON.toJSONString(authVO));
        String stringResponseVO = freeGoApi.authsForStr(authVO);
        System.out.println(JSON.toJSONString(stringResponseVO));
        return R.ok(stringResponseVO);
    }

    @GetMapping("/password")
    public R password(AuthVO authVO) {
        System.out.println(JSON.toJSONString(authVO));
        ResponseVO<PasswordVO> passWord = freeGoApi.getPassWord(authVO);
        System.out.println(JSON.toJSONString(passWord));
        return R.ok(passWord.getData());
    }

    @GetMapping("/liftQRCode")
    public R lift(AuthVO authVO) {
        System.out.println(JSON.toJSONString(authVO));
        ResponseVO<LiftQRCodeVO> liftQRCode = freeGoApi.getLiftQRCode(authVO);
        System.out.println(JSON.toJSONString(liftQRCode));
        return R.ok(liftQRCode.getData());
    }


    @GetMapping("/test")
    public R test(AuthVO authVO) {
        System.out.println(JSON.toJSONString(authVO));
        ResponseVO<LiftQRCodeVO> liftQRCode = freeGoApi.getLiftQRCode(authVO);
        System.out.println(JSON.toJSONString(liftQRCode));
        return R.ok(liftQRCode.getData());
    }
}
