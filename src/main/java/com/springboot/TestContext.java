package com.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Repository("TestContext")
public class TestContext {

    @Resource
    ApplicationContext applicationContext;



    public void testApp(){
        TestContext bean = applicationContext.getBean(TestContext.class);
        System.out.println(bean+"--"+applicationContext.getBeanNamesForType(TestContext.class)[0]);

        TestContext testContext = (TestContext) applicationContext.getBean("TestContext");
        System.out.println(testContext);

    }
}
