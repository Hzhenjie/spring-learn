package com.rabbit.prototype;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.Map;

/**
 * author:zhenjie
 * Date:2021/12/27
 * time:16:14
 */
@Component
public class Consumer {

    @RabbitListener(queues = "directQueue1")
    @RabbitHandler
    public void directQueue1Consumer(@Payload String message, @Headers Map<String, Object> headers){
        System.out.println("body:"+message+"接收到："+new Date());
        //System.out.println("headers:"+headers);
    }

    @RabbitListener(queues = "topicQueue1")
    @RabbitHandler
    public void topicQueue1(@Payload String message, @Headers Map<String, Object> headers){
        System.out.println("body:"+message+"接收到topicQueue1的message："+message);
        //System.out.println("headers:"+headers);
    }

    @RabbitListener(queues = "topicQueue2")
    @RabbitHandler
    public void topicQueue2(@Payload String message, @Headers Map<String, Object> headers){
        System.out.println("body:"+message+"接收到topicQueue2的message："+message);
    }


}
