package com.kuarker.nacos.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuarker.nacos.provider.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-6-11
 **/
@Repository
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
