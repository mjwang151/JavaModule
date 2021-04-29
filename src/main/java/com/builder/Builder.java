package com.builder;

/**
 * 建造者模式
 * @author mjwang
 * @version 1.0
 * @date 2021/4/22 21:33
 */
public abstract class Builder {
    //地基
    abstract void bulidA();
    //钢筋工程
    abstract void bulidB();
    //铺电线
    abstract void bulidC();
    //粉刷
    abstract void bulidD();
    //完工-获取产品
    abstract Product getProduct();

}
