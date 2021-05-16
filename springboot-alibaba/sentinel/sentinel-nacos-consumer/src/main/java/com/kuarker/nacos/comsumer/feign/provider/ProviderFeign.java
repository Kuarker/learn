package com.kuarker.nacos.comsumer.feign.provider;

import com.kuarker.nacos.provider.api.ConfigApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/5/16
 **/
@FeignClient(name = "nacos-provider")
public interface ProviderFeign extends ConfigApi {
}
