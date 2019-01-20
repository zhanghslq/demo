package com.example.demo;

import javafx.application.Application;
import org.springframework.context.ApplicationEvent;

public class OrderCreateEvent extends ApplicationEvent {

    public OrderCreateEvent(Object source) {
        super(source);
    }
}
