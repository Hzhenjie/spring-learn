package com.rabbit.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author:zhenjie
 * Date:2021/12/27
 * time:15:11
 */
@Component
public class Publish {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendSms(String message){
        rabbitTemplate.convertAndSend("directExchange","sms",message);
    }

    public void sendTopic(String message){
        rabbitTemplate.convertAndSend("topicExchange1","zhen","zhenjie"+message);
    }
}
