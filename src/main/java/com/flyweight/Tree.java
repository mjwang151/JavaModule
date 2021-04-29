package com.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/23 22:26
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Tree {
    String name;
    String data;

    @Override
    public String toString() {
        return this.hashCode()+"Tree{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
