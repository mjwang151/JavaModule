package com.builder;

/**
 * 建造者变种 连续设值
 * @author mjwang
 * @version 1.0
 * @date 2021/4/22 22:25
 */
public class Test2 {
    public static void main(String[] args) {
        Product product = new Product.Nbuilder().buildA("1").buildB("2").buildC("3").buildD("4").build();
        System.out.println(product);
    }
}
