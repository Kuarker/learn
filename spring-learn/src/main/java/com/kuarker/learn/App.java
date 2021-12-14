package com.kuarker.learn;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-13
 **/
//@SpringBootApplication
public class App {
    public static void main(String[] args) {
//        SpringApplication.run(App.class, args);


        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Bean.class);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        beanFactory.registerBeanDefinition("bean",beanDefinition);
        ConfigurationClassPostProcessor postProcessor = new ConfigurationClassPostProcessor();
        postProcessor.postProcessBeanDefinitionRegistry(beanFactory);
        System.out.println(Arrays.toString(beanFactory.getBeanDefinitionNames()));
    }

    @Component
    static class Bean{

    }
}
