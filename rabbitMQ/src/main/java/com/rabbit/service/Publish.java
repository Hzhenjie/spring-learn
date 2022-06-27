package com.rabbit.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        rabbitTemplate.convertAndSend("topicExchange1","zhen","Topic:"+message);
    }

    public void sendTopic1(String message){
        rabbitTemplate.convertAndSend("topicExchange1","jie","Topic:"+message);
    }

    public void sendDelayMessage(String message, int time){
        List<String> list = new ArrayList<String>();
        list.add(message+"当前时间："+new Date());
        list.add(time+"");
        rabbitTemplate.convertAndSend("DELAY_EXCHANGE","DELAY_ROUTING_KEY", list, msg->{
            msg.getMessageProperties().setDelay(time);
            return msg;
        });
    }
}
