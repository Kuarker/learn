package com.kuarker.demo.relistener;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-14
 **/
@Component
@RabbitListener(queues = "lock_merchant_dead_queue")
public class RabbitMQListener {


    @RabbitHandler
    public void messageHandler(String body, Message message, Channel channel) throws IOException {

        long msgTag = message.getMessageProperties().getDeliveryTag();
        System.out.println("msgTag="+msgTag);
        System.out.println("body="+body);
        //做复杂业务逻辑  TODO

        //告诉broker，消息已经被确认
        channel.basicAck(msgTag,false);
    }
}
