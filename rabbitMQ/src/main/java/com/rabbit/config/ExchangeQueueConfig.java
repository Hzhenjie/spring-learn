package com.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author:zhenjie
 * Date:2021/12/27
 * time:14:26
 */
@Configuration
public class ExchangeQueueConfig {

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
    public Binding bindingTopic1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("zhen");
    }

    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("zhen");
    }
}
