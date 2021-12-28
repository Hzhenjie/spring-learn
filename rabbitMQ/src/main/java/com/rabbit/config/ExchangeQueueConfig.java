package com.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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

}
