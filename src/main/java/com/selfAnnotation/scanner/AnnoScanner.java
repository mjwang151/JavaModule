package com.selfAnnotation.scanner;

import com.selfAnnotation.MethodAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;

@Slf4j
public class AnnoScanner  implements ApplicationListener<ContextRefreshedEvent> {
    ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext rootApplicationContext = contextRefreshedEvent.getApplicationContext().getParent();
        this.applicationContext = rootApplicationContext != null ? rootApplicationContext : contextRefreshedEvent.getApplicationContext();

    }

    public void findAnnoByName(String name){
        //获取所有bean的名字
        String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
        if (beanNames == null || beanNames.length == 0) {
            return;
        }
        //注册Api服务
        log.info("开始注册寻找服务");
        for (String beanName : beanNames) {
            Class<?> beanType = applicationContext.getType(beanName);
            MethodAnnotation anno = findAnnotation(beanType, MethodAnnotation.class);
            if (anno == null) {
                continue;
            }
//            IDataService service = (IDataService)applicationContext.getBean(beanName);
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
}
