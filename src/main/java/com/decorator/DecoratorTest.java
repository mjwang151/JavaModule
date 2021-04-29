package com.decorator;

/**
 * 装饰者模式
 * @author mjwang
 * @version 1.0
 * @date 2021/4/27 21:50
 */
public class DecoratorTest {
    public static void main(String[] args) {
        new DecoratorImpl2(new DecoratorImpl1(new TakeComponent())).kaKa();
    }
}


interface TakeInter{
    String kaKa();
}
class TakeComponent implements  TakeInter{

    @Override
    public String kaKa() {
        System.out.println("开始拍照");
        return null;
    }
}
abstract class  Decorator implements  TakeInter{
    TakeInter takeInter;
    public Decorator(TakeInter takeInter){
        this.takeInter = takeInter;
    }
}

class DecoratorImpl1 extends  Decorator{
    public DecoratorImpl1(TakeInter takeInter) {
        super(takeInter);
    }
    @Override
    public String kaKa() {
        takeInter.kaKa();
        System.out.println("添加美颜");
        return null;
    }
}
class DecoratorImpl2 extends  Decorator{
    public DecoratorImpl2(TakeInter takeInter) {
        super(takeInter);
    }
    @Override
    public String kaKa() {
        takeInter.kaKa();
        System.out.println("添加滤镜");
        return null;
    }
}