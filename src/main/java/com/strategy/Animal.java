package com.strategy;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/29 22:05
 */
@Getter
@Setter
public abstract class Animal {

    public abstract void display();
    Attack attack;
    Move move;
    public abstract void attack();
    public abstract void move();



    public Animal(Attack attack,Move move){
        this.attack = attack;
        this.move = move;
    }

}
