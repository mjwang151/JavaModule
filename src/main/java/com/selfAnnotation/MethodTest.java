package com.selfAnnotation;

import com.selfAnnotation.anno.MethodAnnotation;
import org.springframework.stereotype.Component;

@Component
public class MethodTest {



    @MethodAnnotation(title = "test", bussinessType = "test", operatorType = "admin")
    public String testMethod(){
        return "testMethod";
    }

}
