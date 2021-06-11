package com.kuarker.nacos.provider.util;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021/4/29
 **/
public interface Group {
    /**
     * 参数校验分组：增加
     */
    public @interface add {
    }

    /**
     * 参数校验分组：编辑
     */
    public @interface edit {
    }

    /**
     * 参数校验分组：删除
     */
    public @interface delete {
    }


    /**
     * 参数校验分组：编辑
     */
    public @interface list {
    }

}
