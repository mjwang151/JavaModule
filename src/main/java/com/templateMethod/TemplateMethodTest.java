package com.templateMethod;

/**
 * 模板方法模式
 * @author mjwang
 * @version 1.0
 * @date 2021/4/27 22:10
 */
public class TemplateMethodTest {

    public static void main(String[] args) {
        new TemplateMethodImpl().service();
    }
}


abstract class TemplateMethodClass{
    public void service(){
        System.out.println("业务代码...");
        abstractMethod();
    }

    protected abstract void abstractMethod();
}

class TemplateMethodImpl extends  TemplateMethodClass{

    @Override
    protected void abstractMethod() {
        System.out.println("抽象方法！");
    }
}