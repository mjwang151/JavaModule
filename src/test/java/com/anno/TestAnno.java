package com.anno;

import com.selfAnnotation.scanner.AnnoScanner;
import com.selfAnnotation.service.ApiAnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAnno {
    @Autowired
    AnnoScanner annoScanner;
    @Autowired
    ApiAnnoService apiAnnoService;
    @org.junit.jupiter.api.Test
    public void test(){
        annoScanner.findAnnoByMethodName("test3");
//        apiAnnoService.test3();
    }
}
