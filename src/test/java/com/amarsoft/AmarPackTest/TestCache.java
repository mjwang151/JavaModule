package com.amarsoft.AmarPackTest;

import com.springboot.SpringCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/2 21:49
 */
@SpringBootTest
@EnableCaching
public class TestCache {

    @Autowired
    SpringCache springCache;


    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            ThreadTask threadTask = new ThreadTask();
            threadTask.start();

            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    class ThreadTask extends Thread{
        //2):在A类中覆盖Thread类中的run方法.
        public void run() {
            System.out.println(springCache.testCache("11"));
        }
    }
}
