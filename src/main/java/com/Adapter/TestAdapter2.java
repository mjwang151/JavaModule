package com.Adapter;

/**
 * 适配器模式
 * @author mjwang
 * @version 1.0
 * @date 2021/4/25 21:59
 */
public class TestAdapter2 {
    public static void main(String[] args) {
        Adapter2 ad = new Adapter2();
        ad.out5v();
    }

}

class Out2202{
    public int out220(){
        return 220;
    }
}

interface  Target2{
    /**
     *
     * @return
     */
    int out5v();
}

class Adapter2 extends  Out2202 implements  Target2{
    @Override
    public int out220(){
        return 220;
    }

    @Override
    public int out5v() {
        int i = out220();
        System.out.println(String.format("输入 %d -> 输出 %d",i,5));
        return 5;
    }
}