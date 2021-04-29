package com.builder;

/**
 * 具体建造者
 *
 * @author mjwang
 * @version 1.0
 * @date 2021/4/22 21:38
 */
public class ConcreteBuilder2 extends Builder {
    private Product product;

    public ConcreteBuilder2() {
        product = new Product();
    }

    @Override
    void bulidA() {
        product.setBuildA("地基2");
    }

    @Override
    void bulidB() {
        product.setBuildB("钢筋工程2");
    }

    @Override
    void bulidC() {
        product.setBuildC("铺电线2");
    }

    @Override
    void bulidD() {
        product.setBuildD("粉刷2");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
