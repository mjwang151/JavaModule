package com.strategy;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/29 22:16
 */
public class Cat extends Animal{


    public Cat(Attack attack, Move move) {
        super(attack, move);
    }

    @Override
    public void display() {
        System.out.println("一只猫");
    }

    @Override
    public void attack() {
        super.attack.attack();
    }

    @Override
    public void move() {
        super.move.move();
    }
}
