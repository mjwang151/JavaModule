package com.amarsoft.AmarPackTest;

import com.selfAnnotation.MethodTest;
import com.springboot.SpringCache;
import com.springboot.TestContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/2 21:49
 */
@SpringBootTest
public class TestCache {

    @Autowired
    SpringCache springCache;


    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("i = " + i+":"+springCache.testCache());
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }


}
