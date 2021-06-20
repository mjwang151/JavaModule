package com.selfAnnotation.service;

import com.selfAnnotation.anno.ApiAnno;
import com.selfAnnotation.anno.ApiAnnoMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

@ApiAnno("test1")
@Slf4j
@Component
public class ApiAnnoService implements ApiInter {
    @Autowired
    List<String> qidong;




    @Override
    public String exec(String obj) {

        log.info("-----------------进入了执行类-----------------");
        log.info(obj);
        return null;
    }


    @ApiAnnoMethod("test2")
    public void test2(){
        log.info("-----------------进入了方法2-----------------");
        qidong.stream().forEach(System.out::println);
    }

    @ApiAnnoMethod("test3")
    public void test3(){
        log.info("-----------------进入了方法3-----------------");
    }
}
