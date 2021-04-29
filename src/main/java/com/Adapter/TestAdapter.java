package com.Adapter;

/**
 * 适配器模式
 * @author mjwang
 * @version 1.0
 * @date 2021/4/25 21:59
 */
public class TestAdapter {
    public static void main(String[] args) {
        Out220 o2 = new Out220();
        Adapter ad = new Adapter(o2);
        ad.out5v();
    }

}

class Out220{
    public int out(){
        return 220;
    }
}

interface  Target{
    /**
     *
     * @return
     */
    int out5v();
}
class Adapter implements  Target{
    Out220 Out220;

    public Adapter(Out220 Out220) {
        this.Out220 = Out220;
    }

    @Override
    public int out5v() {
        int i = Out220.out();
        System.out.println(String.format("输入 %d -> 输出 %d",i,5));
        return 5;
    }
}