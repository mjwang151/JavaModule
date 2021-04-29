package com.builder;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/22 21:45
 */
public class Director {
    //指挥工人按顺序造房
    public Product create(Builder builder) {
        builder.bulidA();
        builder.bulidB();
        builder.bulidC();
        builder.bulidD();
        return builder.getProduct();
    }
    //指挥工人按顺序造房2
    public Product create2(Builder builder) {
        builder.bulidA();
        builder.bulidB();
        builder.bulidC();
        return builder.getProduct();
    }
}
