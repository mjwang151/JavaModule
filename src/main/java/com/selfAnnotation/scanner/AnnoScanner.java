package com.selfAnnotation.scanner;

import com.selfAnnotation.anno.ApiAnno;
import com.selfAnnotation.anno.ApiAnnoMethod;
import com.selfAnnotation.service.ApiInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class AnnoScanner  implements ApplicationListener<ContextRefreshedEvent> {
    ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext rootApplicationContext = contextRefreshedEvent.getApplicationContext().getParent();
        this.applicationContext = rootApplicationContext != null ? rootApplicationContext : contextRefreshedEvent.getApplicationContext();
    }

    /**
     * 通过注解类上面的注解获取对应类
     * @param name
     */
    public void findAnnoByName(String name){
        //获取所有bean的名字
        String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
        if (beanNames == null || beanNames.length == 0) {
            return;
        }
        log.info("开始注册寻找注解");
        for (String beanName : beanNames) {
            Class<?> beanType = applicationContext.getType(beanName);
            ApiAnno anno = findAnnotation(beanType, ApiAnno.class);
        }
    }
    public void findAnnoByMethodName(String name){
        //获取所有bean的名字
        String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
        if (beanNames == null || beanNames.length == 0) {
            return;
        }
        log.info("开始注册寻找注解");
        for (String beanName : beanNames) {
            Class<?> beanType = applicationContext.getType(beanName);
            List<AnnoBean> annoMethod = findAnnotationMethod(beanType, ApiAnnoMethod.class);
            if(annoMethod != null && annoMethod.size() > 0 ){
                annoMethod.stream().forEach(v->{
                    ApiAnnoMethod anm = (ApiAnnoMethod) v.getAnnotation();
                    System.out.println("==" + anm.value());
                    if(name.equals(anm.value())){
                        try {
                            v.getMethod().invoke(v.getClassName().getDeclaredConstructor().newInstance() , null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
    public static <T extends Annotation> T findAnnotation(Class<?> beanClass, Class<T> annotationType) {
        Assert.notNull(beanClass, "Class can not be null");
        if (annotationType == null) {
            return null;
        }
        Annotation[] annotations = beanClass.getAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == annotationType) {
                return (T)annotation;
            }
        }
        return null;
    }

    public static <T extends Annotation> List<AnnoBean> findAnnotationMethod(Class<?> beanClass, Class<T> annotationType) {
        List<AnnoBean> list = new ArrayList<AnnoBean>();
        try {
            Assert.notNull(beanClass, "Class can not be null");
            if (annotationType == null) {
                return list;
            }
            Method[] ms = beanClass.getMethods();
            for (Method method : ms) {
                boolean flag = method.isAnnotationPresent(annotationType);
                if (flag) {
                    log.info("找到注解类："+beanClass.getName());
                    Annotation annotation = method.getAnnotation(annotationType);
                    AnnoBean annoBean = new AnnoBean(beanClass,method,(T)annotation);
                    list.add(annoBean);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
