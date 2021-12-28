package com.rabbit.controller;

import com.rabbit.service.Publish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return "rabbitTest-------------";
    }
}
