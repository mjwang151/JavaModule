package com.selfAnnotation.scanner;

import com.selfAnnotation.anno.ApiAnnoMethod;
import com.selfAnnotation.service.ApiAnnoService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.*;

/**
 *
 */
@Slf4j
public class AnnotationUtil {

    private final String BASE_PACKAGE = "com.selfAnnotation";
    private final String RESOURCE_PATTERN = "/**/*.class";

    public static void main(String[] args) {
        new AnnotationUtil().test();
    }

    public void test() {
        Map<String, Class> handlerMap = new HashMap<String, Class>();
        //spring工具类，可以获取指定路径下的全部类
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    ClassUtils.convertClassNameToResourcePath(BASE_PACKAGE) + RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(pattern);
            //MetadataReader 的工厂类
            MetadataReaderFactory readerfactory = new CachingMetadataReaderFactory(resourcePatternResolver);
            for (Resource resource : resources) {
                //用于读取类信息
                MetadataReader reader = readerfactory.getMetadataReader(resource);
                //扫描到的class
                String classname = reader.getClassMetadata().getClassName();
                Class<?> clazz = Class.forName(classname);
                //判断是否有指定主解
                ApiAnnoMethod anno = clazz.getAnnotation(ApiAnnoMethod.class);
                if (anno != null) {
                    //将注解中的类型值作为key，对应的类作为 value
                    handlerMap.put(classname, clazz);
                }
                Method[] ms = clazz.getMethods();
                for (Method method : ms) {
                    boolean flag = method.isAnnotationPresent(ApiAnnoMethod.class);
                    if (flag) {
                        log.info("找到类："+classname);
                        method.invoke(clazz.getDeclaredConstructor().newInstance() , null);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
