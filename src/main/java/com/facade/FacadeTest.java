package com.facade;

/**
 * Facade 门面模式
 * @author mjwang
 * @version 1.0
 * @date 2021/4/24 9:41
 */
public class FacadeTest {

    public static void main(String[] args) {
        new Facade().doThing();
    }



}

class Facade{
    ShiXian1 sx1 = new ShiXian1();
    ShiXian2 sx2= new ShiXian2();
    public void doThing(){
        sx1.doSomeThing();;
        sx2.doSomeThing();
    }

}

class ShiXian1{
    public  ShiXian1(){
        System.out.println("实现1");
    }
    public void doSomeThing(){
        System.out.println("do11111111");
    }
}
class ShiXian2{
    public  ShiXian2(){
        System.out.println("实现2");
    }
    public void doSomeThing(){
        System.out.println("do11111111");
    }
}