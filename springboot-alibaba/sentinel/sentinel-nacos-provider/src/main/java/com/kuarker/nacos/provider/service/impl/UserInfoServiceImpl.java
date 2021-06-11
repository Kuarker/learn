package com.kuarker.nacos.provider.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuarker.nacos.provider.domain.UserInfo;
import com.kuarker.nacos.provider.mapper.UserInfoMapper;
import com.kuarker.nacos.provider.service.UserInfoService;
import com.kuarker.nacos.provider.util.PageFactoryUtil;
import com.kuarker.nacos.provider.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-6-11
 **/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public PageResult doPage() {

        Page<UserInfo> page = this.page(PageFactoryUtil.defaultPage());

        return new PageResult(page);
    }
}
