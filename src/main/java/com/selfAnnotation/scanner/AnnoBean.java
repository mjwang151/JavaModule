package com.selfAnnotation.scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Data
@AllArgsConstructor
public class AnnoBean {
    Class<?> className;
    Method method;
    Annotation annotation;

}
