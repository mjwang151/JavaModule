package com.strategy;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/29 22:04
 */
public interface Attack {

    void attack();
}

class AttackImpl implements Attack {
    @Override
    public void attack() {
        System.out.println("锤击.");
    }
}
class AttackImpl2 implements Attack {
    @Override
    public void attack() {
        System.out.println("枪击.");
    }
}