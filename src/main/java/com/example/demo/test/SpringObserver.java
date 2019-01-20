package com.example.demo.test;

import com.example.demo.DemoApplication;
import com.example.demo.listener.OrderService;
import com.example.demo.strategy.FeeCarculationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SpringObserver {

    @Autowired
    OrderService orderService;
    @Test
    public void test(){//观察者模式
       orderService.saveOrder();
    }

    /**
     * 模板模式
     */
    @Test
    public void template(){
        RedisTemplate redisTemplate1=null;
        RedisCallback<String> redisCallback1 = new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return null;
            }
        };
        redisTemplate1.execute(redisCallback1);

    }
    /**
     * 策略模式
     */
    @Autowired
    FeeCarculationService feeCarculationService;
    @Test
    public void springTest(){
        double vip = feeCarculationService.carculate("vip", 100);

        System.out.println("vip"+vip);

        double svip = feeCarculationService.carculate("svip", 100);

        System.out.println("svip"+svip);

    }
}
