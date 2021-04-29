package com.factory;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/23 19:39
 */
public class SimpleProductB implements SimpleCore {
    @Override
    public String create() {
        return "工厂B";
    }
}

