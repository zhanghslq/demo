package com.example.demo.strategy;

import org.springframework.stereotype.Service;

@Service
public class VipDiscount implements DiscountStrategy {
    @Override
    public String type() {
        return "vip";
    }

    @Override
    public double discount(double dis) {
        return dis*0.7;
    }
}
