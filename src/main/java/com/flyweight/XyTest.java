package com.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 *
 * @author mjwang
 * @version 1.0
 * @date 2021/4/23 22:20
 */
public class XyTest {

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            new Runnable() {
                @Override
                public void run() {
                    System.out.println(TreeFactory.getTree("abc1"));
                    System.out.println(TreeFactory.getTree("abc2"));
                }
            }.run();
        }


    }


    public static class TreeFactory {
        public static Map<String, Tree> map = new ConcurrentHashMap<String, Tree>();

        public static Tree getTree(String name) {
            Tree circle = (Tree) map.get(name);
            if (circle == null) {
                circle = new Tree(name, "abcdfff");
                map.put(name, circle);
                System.out.println("Creating Tree of name : " + name);
            }
            return circle;
        }
    }


}
