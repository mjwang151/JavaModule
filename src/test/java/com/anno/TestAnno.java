package com.anno;

import com.selfAnnotation.scanner.AnnoScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAnno {
    @Autowired
    AnnoScanner annoScanner;

    @org.junit.jupiter.api.Test
    public void test(){
        annoScanner.findAnnoByMethodName("test2");
    }
}
