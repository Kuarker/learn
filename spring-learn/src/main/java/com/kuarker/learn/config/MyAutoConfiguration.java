package com.kuarker.learn.config;

import com.kuarker.learn.bean.Bean2;
import com.kuarker.learn.bean.Bean3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-15
 **/

@Slf4j
//@ConditionalOnMissingClass({"com.kuarker.learn.bean.Bean3"})
@ConditionalOnProperty(prefix = "my.auto", name = "prefix", havingValue = "kk",
        matchIfMissing = true)
public class MyAutoConfiguration {

    @Bean
    @ConditionalOnBean(name = {"bean3"}) // 不会注入，因为Bean3类型还没有放入容器中，所以这里不会把 bean5放入IOC容器管理
    public Bean2 bean5() {
        return new Bean2();
    }

    @Bean
    @ConditionalOnMissingBean(name = {"bean3"}) // 会注入，因为Bean3类型还没有放入容器中，所以这里会把 bean6放入IOC容器管理
    public Bean2 bean6() {
        return new Bean2();
    }

    /**
     * 排在前面先创建
     *
     * @return
     */
    @Bean
    public Bean3 bean3() {
        return new Bean3();
    }


    /**
     * 排在前面先创建
     *
     * @return
     */
    @Bean
//    @ConditionalOnMissingBean // 不会注入，因为Bean3类型已经注入了，所以这里不会把 bean4放入IOC容器管理
    @ConditionalOnBean // 会注入，因为Bean3类型已经注入了，所以这里会把 bean4放入IOC容器管理
    public Bean3 bean4() {
        return new Bean3();
    }

    @Bean
    @ConditionalOnBean(name = {"bean3"}) // 会注入，因为Bean3类型已经注入了，所以这里不会把 bean2放入IOC容器管理
    public Bean2 bean2() {
        return new Bean2();
    }

}
