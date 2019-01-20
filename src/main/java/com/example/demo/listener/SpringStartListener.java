package com.example.demo.listener;


import org.springframework.boot.context.event.ApplicationStartedEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringStartListener implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("Spring  启动之后的相关逻辑");
    }
}
