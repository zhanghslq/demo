package com.example.demo.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Component
public class FeeCarculationService {


    @Autowired
    VipDiscount vipDiscount;

    @Autowired
    NormalDiscount normalDiscount;
    /**
     * 根据不同的用户计费
     */
    public double carculate(String type,double count){
        return hashMap.get(type).discount(count);
    }

    /**
     * 定义一个map
     * @param discountStrategies
     */
    HashMap<String,DiscountStrategy> hashMap=new HashMap<>();

    public FeeCarculationService(List<DiscountStrategy> discountStrategies) {

        for (DiscountStrategy discountStrategy : discountStrategies) {
            hashMap.put(discountStrategy.type(),discountStrategy);
        }
    }
}
