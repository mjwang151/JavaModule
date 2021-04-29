package com.strategy;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/29 22:04
 */
public interface Move {
    void move();
}
class MoveImpl implements Move{
    @Override
    public void move() {
        System.out.println("一步一步走");
    }
}
class MoveImpl2 implements Move{
    @Override
    public void move() {
        System.out.println("奔跑");
    }
}