package com.kuarker.nacos.provider.util;


import lombok.Data;
import lombok.experimental.Delegate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: 封装可用于请求参数校验的List,一定要加@Data，否则校验会出错
 * @author: Jiayan Lee
 * @date: 2021/4/29
 **/
@Data
public class ValidList<E> implements List<E> {

    /**
     * //是lombok注解
     * // 一定要加@Valid注解
     */
    @Delegate
    @Valid
    @NotEmpty
    public List<E> list = new ArrayList<>();

    // 一定要记得重写toString方法
    @Override
    public String toString() {
        return list.toString();
    }
}
