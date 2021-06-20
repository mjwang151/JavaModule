package com.selfAnnotation.service;

import com.selfAnnotation.anno.ApiAnno;
import com.selfAnnotation.anno.ApiAnnoMethod;
import lombok.extern.slf4j.Slf4j;

@ApiAnno("test1")
@Slf4j
public class ApiAnnoService implements ApiInter {


    @Override
    public String exec(String obj) {

        log.info("-----------------进入了执行类-----------------");
        log.info(obj);
        return null;
    }


    @ApiAnnoMethod("test2")
    public void test2(){
        log.info("-----------------进入了方法2-----------------");
    }

    @ApiAnnoMethod("test3")
    public void test3(){
        log.info("-----------------进入了方法3-----------------");
    }
}
