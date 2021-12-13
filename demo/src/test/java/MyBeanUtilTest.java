import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-11-18
 **/
public class MyBeanUtilTest {

    public static void main(String[] args) throws IOException {

        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(BeanConfigUtils.class);
        AnnotationConfigUtils.registerAnnotationConfigProcessors(context.getDefaultListableBeanFactory());
        // org.springframework.context.annotation.ConfigurationClassParser.parse(java.util.Set<org.springframework.beans.factory.config.BeanDefinitionHolder>)
        // 会去解析     @Configuration 标注的类
        context.refresh();
        System.in.read();

    }

    @Configuration
    static class BeanConfigUtils {
        @Bean
        public Bean1 getBean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 getBean2() {
            return new Bean2();
        }

        @Bean
        public Bean3 getBean3() {
            return new Bean3();
        }


        ;
    }

    static class Bean1 {
    }

    static class Bean2 {
    }

    static class Bean3 {
    }
}
