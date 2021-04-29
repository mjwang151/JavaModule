package com.builder;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/22 21:45
 */
public class Test {
        public static void main(String[] args) {
            Director director = new Director();
            Product create = director.create(new ConcreteBuilder());
            Product create2 = director.create(new ConcreteBuilder2());
            System.out.println(create.toString());
            System.out.println(create2.toString());
        }
}
