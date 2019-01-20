package com.example.demo.strategy;

import org.springframework.stereotype.Service;

@Service
public class SvipDiscount implements DiscountStrategy{

    @Override
    public String type() {
        return "svip";
    }

    @Override
    public double discount(double dis) {
        return dis*0.5;
    }
}
