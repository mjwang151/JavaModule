package com.strategy;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/29 22:11
 */
public class Test {

    public static void main(String[] args) {
        Dog dog = new Dog(new AttackImpl(), new MoveImpl());
        dog.display();
        dog.attack();
        dog.move();

        Cat cat = new Cat(new AttackImpl2(), new MoveImpl2());
        cat.display();
        cat.attack();
        cat.move();

    }
}
