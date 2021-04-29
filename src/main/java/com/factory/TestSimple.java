package com.factory;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/23 19:41
 */
public class TestSimple {
    public static void main(String[] args) {
        System.out.println(TestSimple.create("1").create());
    }

    public static SimpleCore create(String type) {
        switch (type) {
            case "1":
                return new SimpleProductA();
            case "2":
                return new SimpleProductB();
            default:
                return null;
        }
    }

}
