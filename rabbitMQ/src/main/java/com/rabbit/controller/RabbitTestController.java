package com.rabbit.controller;

import com.rabbit.service.Publish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * author:zhenjie
 * Date:2021/12/24
 * time:19:13
 */
@RestController
@RequestMapping("/rabbitMQ/")
public class RabbitTestController {

    @Autowired
    Publish publish;

    @GetMapping("rabbitTest")
    public String rabbitTest(@RequestParam String content) {
        publish.sendSms("开始："+new Date() +"-内容："+content);
        publish.sendTopic("123456");
        return "rabbitTest-------------";
    }

    @GetMapping("delayMessage/{time}")
    public String delayMessage(@RequestParam String content, @PathVariable("time")Integer time) {
        System.out.println("有效时间："+time/1000+"s"+"---"+"当前时间："+new Date());
        System.out.println("内容："+content+"当前时间："+System.currentTimeMillis());
        publish.sendDelayMessage(content,time);
        return "rabbitTest-----success";
    }

    @GetMapping("rabbitTest1")
    public String rabbitTest1(@RequestParam String content) {
        publish.sendSms("开始："+new Date() +"-内容："+content);
        publish.sendTopic("123456");
        return "rabbitTest-------------";
    }
}
