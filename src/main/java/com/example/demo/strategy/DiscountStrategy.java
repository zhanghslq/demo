package com.example.demo.strategy;

public interface DiscountStrategy {
    public String type();
    double discount(double dis);
}
