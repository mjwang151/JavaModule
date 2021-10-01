package com.amarsoft.AmarPackTest;

import com.selfAnnotation.MethodTest;
import com.springboot.TestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/2 21:49
 */
@SpringBootTest
public class TestBoot {

    @Autowired
    MethodTest methodTest;

    @Autowired
    TestContext testContext;

    @Test
    public void test(){
//        methodTest.testMethod();
        testContext.testApp();
    }


}
