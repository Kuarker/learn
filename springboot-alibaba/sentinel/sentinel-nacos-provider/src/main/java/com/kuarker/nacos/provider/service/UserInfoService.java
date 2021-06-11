package com.kuarker.nacos.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuarker.nacos.provider.domain.UserInfo;
import com.kuarker.nacos.provider.util.PageResult;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-6-11
 **/
public interface UserInfoService  extends IService<UserInfo> {
    PageResult doPage();
}
