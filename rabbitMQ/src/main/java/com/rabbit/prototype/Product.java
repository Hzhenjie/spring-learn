package com.rabbit.prototype;

import com.rabbit.service.Publish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author:zhenjie
 * Date:2021/12/27
 * time:15:17
 */
public class Product {

    public static void main(String[] args) {
        Publish publish = new Publish();
        publish.sendSms("123456");
    }
}
