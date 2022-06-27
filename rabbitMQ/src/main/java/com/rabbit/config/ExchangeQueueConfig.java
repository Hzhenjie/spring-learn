package com.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * author:zhenjie
 * Date:2021/12/27
 * time:14:26
 */
@Configuration
public class ExchangeQueueConfig {

    //延时交换机
    private String DELAY_EXCHANGE = "DELAY_EXCHANGE";
    //延时队列
    private String DELAY_QUEUE = "DELAY_QUEUE";

    private String DELAY_ROUTING_KEY = "DELAY_ROUTING_KEY";

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Queue directQueue1(){
        return new Queue("directQueue1");
    }

    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with("sms");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange1");
    }

    @Bean
    public Queue topicQueue1(){
        return new Queue("topicQueue1");
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topicQueue2");
    }

    @Bean
    public Queue topicQueue3(){
        return new Queue("topicQueue3");
    }

    @Bean
    public Binding bindingTopic1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("zhen");
    }

    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("zhen");
    }

    @Bean
    public Binding bindingTopic3(){
        return BindingBuilder.bind(topicQueue3()).to(topicExchange()).with("jie");
    }

    @Bean
    public CustomExchange delayExchange(){
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("x-delayed-type","direct");
        return new CustomExchange( DELAY_EXCHANGE,  "x-delayed-message",  true,  false, arguments);
    }

    @Bean
    public Queue delayQueue(){
        return new Queue(DELAY_QUEUE);
    }

    @Bean
    public Binding delayQueueBindingDelayExchange(@Qualifier("delayExchange")CustomExchange delayExchange,
                                                  @Qualifier("delayQueue")Queue delayQueue){
        return BindingBuilder.bind(delayQueue).to(delayExchange).with(DELAY_ROUTING_KEY).noargs();
    }

}
