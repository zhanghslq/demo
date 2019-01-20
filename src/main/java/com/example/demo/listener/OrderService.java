package com.example.demo.listener;


import com.example.demo.OrderCreateEvent;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    ApplicationContext applicationContext;
    /**
     * 生成订单
     */
    public void saveOrder(){
        System.out.println("1.订单创建成功");


        //创建一个事件，然后将它发布出去
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent("");
        applicationContext.publishEvent(orderCreateEvent);

    }
}
