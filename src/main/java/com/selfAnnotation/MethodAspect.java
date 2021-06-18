package com.selfAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author xcf
 * @Description
 * @date $ $
 */
@Aspect
@Component
public class MethodAspect {

    @Pointcut("@annotation(com.selfAnnotation.MethodAnnotation)")
    public void methodAspectAnno(){};

    @After("methodAspectAnno()")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("进入After方法");
    }

    /**
     * 在这个步骤处理日志的记录等
     * @param joinPoint
     * @param jsonResult
     */
    @AfterReturning(pointcut = "methodAspectAnno()", returning = "jsonResult")
    public void afterReturning(JoinPoint joinPoint, Object jsonResult){
        System.out.println("进入afterReturning方法");
        /*下面需要做两个事情：1.获取注解中的三个内置参数。2.获取调用的方法，类等等*/
        //1.获取注解中的三个内置参数
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();//转为method对应的Signature
        Method method = methodSignature.getMethod();//获取当前method对象
        MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);//获取method对象中对应的注解对象
        System.out.println("模块名称" + annotation.title());
        System.out.println("功能" + annotation.bussinessType());
        System.out.println("操作级别" + annotation.operatorType());

        //2.获取调用的方法，类等等
        String name = joinPoint.getSignature().getName();
        System.out.println("当前调用方法" + name);
        String className = joinPoint.getTarget().getClass().getName();
        System.out.println("当前调用类" + className);
        System.out.println("返回参数" + jsonResult);
        //以下就是将这些参数记录到日志文件中，这里就不演示了，需要的信息都在上面获取出来了
    }



}
