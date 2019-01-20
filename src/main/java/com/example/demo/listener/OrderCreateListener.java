package com.example.demo.listener;

import com.example.demo.OrderCreateEvent;
import javafx.application.Application;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ding'dan'chaun
 */
@Component
public class OrderCreateListener implements ApplicationListener<OrderCreateEvent> {
    @Override
    public void onApplicationEvent(OrderCreateEvent orderCreateEvent) {

        System.out.println("发送短信");
    }}
