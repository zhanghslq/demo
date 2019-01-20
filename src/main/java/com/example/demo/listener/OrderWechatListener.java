package com.example.demo.listener;

import com.example.demo.OrderCreateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OrderWechatListener implements ApplicationListener<OrderCreateEvent> {


    @Override
    public void onApplicationEvent(OrderCreateEvent orderCreateEvent) {
        System.out.println("3.发送微信方法");
    }
}
