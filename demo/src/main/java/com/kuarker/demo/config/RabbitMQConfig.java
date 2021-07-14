package com.kuarker.demo.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    /**
     * 延时的时长
     */
    @Value("${hotel.room-status.delay-time:1800000}")
    private Integer delayTime;

    //死信队列
    public static final String CHECK_OUT_DEAD_QUEUE = "betterwood.check.out.dead.queue";

    //死信交换机
    public static final String CHECK_OUT_DEAD_EXCHANGE = "betterwood_check_out_dead_exchange";

    //进入死信队列的路由key
    public static final String CHECK_OUT_QUEUE_ROUTING_KEY = "check_out_dead_queue_routing_key";

    //创建死信交换机
    @Bean
    public Exchange lockMerchantDeadExchange() {
        return new TopicExchange(CHECK_OUT_DEAD_EXCHANGE, true, false);
    }

    //创建死信队列
    @Bean
    public Queue lockMerchantDeadQueue() {
        return QueueBuilder.durable(CHECK_OUT_DEAD_QUEUE).build();
    }

    //绑定死信交换机和死信队列
    @Bean
    public Binding lockMerchantBinding() {
        return new Binding(CHECK_OUT_DEAD_QUEUE, Binding.DestinationType.QUEUE,
                CHECK_OUT_DEAD_EXCHANGE, CHECK_OUT_QUEUE_ROUTING_KEY, null);
    }

    //普通队列，绑定的个死信交换机
    public static final String CHECK_OUT_QUEUE = "check_out_queue";

    //普通的topic交换机
    public static final String CHECK_OUT_EXCHANGE = "check_out_exchange";

    //路由key
    public static final String CHECK_OUT_ROUTIING_KEY = "check_out_routing_key";

    //创建普通交换机
    @Bean
    public Exchange newMerchantExchange() {
        return new TopicExchange(CHECK_OUT_EXCHANGE, true, false);
    }

    //创建普通队列
    @Bean
    public Queue newMerchantQueue() {
        Map<String, Object> args = new HashMap<>(3);
        //消息过期后，进入到死信交换机
        args.put("x-dead-letter-exchange", CHECK_OUT_DEAD_QUEUE);
        //消息过期后，进入到死信交换机的路由key
        args.put("x-dead-letter-routing-key", CHECK_OUT_QUEUE_ROUTING_KEY);
        //过期时间，单位毫秒
        args.put("x-message-ttl", delayTime);
        return QueueBuilder.durable(CHECK_OUT_QUEUE).withArguments(args).build();
    }

    //绑定交换机和队列
    @Bean
    public Binding newMerchantBinding() {
        return new Binding(CHECK_OUT_QUEUE, Binding.DestinationType.QUEUE,
                CHECK_OUT_EXCHANGE, CHECK_OUT_ROUTIING_KEY, null);
    }
}
