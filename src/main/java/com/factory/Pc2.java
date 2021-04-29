package com.factory;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/22 22:35
 */
public class Pc2 extends Computer{
    private String ram;
    private String hdd;
    private String cpu;

    public Pc2(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}
