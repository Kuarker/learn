package com.kuarker.demo.api;

import com.kuarker.demo.config.FreeGoConfig;
import com.kuarker.demo.pojo.vo.AuthVO;
import com.kuarker.demo.pojo.vo.EKeyVO;
import com.kuarker.demo.pojo.vo.EventResultVO;
import com.kuarker.demo.pojo.vo.LiftQRCodeVO;
import com.kuarker.demo.pojo.vo.PasswordVO;
import com.kuarker.demo.pojo.vo.PmsEventVO;
import com.kuarker.demo.pojo.vo.ResponseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-7
 **/
@Component
@FeignClient(name = "freeGoApi", url = "https://lock.wangjile.cn/apiv3", configuration = FreeGoConfig.class)
public interface FreeGoApi {

    @GetMapping(value = "/authsL", consumes = "application/json")
    ResponseVO<Object> auths(@RequestParam("mobile") String mobile,
                             @RequestParam("department_uuid") String departmentUuid);

    @PostMapping(value = "/pms_events", consumes = "application/json")
    ResponseVO<EventResultVO> pmsEvents(PmsEventVO pmsEvent);

    @GetMapping(value = "/auths", consumes = "application/json")
    ResponseVO<List<EKeyVO>> authsForObject( /*@RequestBody*/ AuthVO authVO);

    @GetMapping(value = "/auths", consumes = "application/json")
    String authsForStr(  AuthVO authVO);

    @PostMapping(value = "/rooms/ev_qrcode", consumes = "application/json")
    ResponseVO<LiftQRCodeVO> getLiftQRCode(  AuthVO authVO);

    @PostMapping (value = "/rooms/sdk", consumes = "application/json")
    ResponseVO<PasswordVO> getPassWord( AuthVO authVO);
}
