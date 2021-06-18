package com.selfAnnotation;

import org.springframework.stereotype.Component;

@Component
public class MethodTest {



    @MethodAnnotation(title = "test", bussinessType = "test", operatorType = "admin")
    public String testMethod(){
        return "testMethod";
    }

}
