package com.example.demo.strategy;

import org.springframework.stereotype.Service;

@Service
public class NormalDiscount implements DiscountStrategy{

    @Override
    public String type() {
        return "normal";
    }

    @Override
    public double discount(double dis) {
        return dis*0.9;
    }
}
