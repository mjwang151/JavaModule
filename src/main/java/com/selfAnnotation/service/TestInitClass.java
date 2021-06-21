package com.selfAnnotation.service;

import com.selfAnnotation.aoplog.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestInitClass {

    @Bean
    public List<String> qidong(){
        List<String> list = new ArrayList<>();
        list.add("init");
        return list;
    }
}
