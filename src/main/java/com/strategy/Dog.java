package com.strategy;

import java.util.Comparator;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/29 22:10
 */
public class Dog extends  Animal implements Comparator {


    public Dog(Attack attack, Move move) {
        super(attack, move);
    }

    @Override
    public void display() {
        System.out.println("一只狗");
    }

    @Override
    public void attack() {
        super.attack.attack();
    }

    @Override
    public void move() {
        super.move.move();
    }



    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
