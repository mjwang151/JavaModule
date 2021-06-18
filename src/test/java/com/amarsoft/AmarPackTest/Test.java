package com.amarsoft.AmarPackTest;

import com.selfAnnotation.MethodTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/2 21:49
 */
@SpringBootTest
public class Test {

    @Autowired
    MethodTest methodTest;

    @org.junit.jupiter.api.Test
    public void test(){
        methodTest.testMethod();
    }
}
