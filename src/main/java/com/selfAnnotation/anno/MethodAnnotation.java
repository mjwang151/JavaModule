package com.selfAnnotation.anno;

import java.lang.annotation.*;

/**
 * java.lang.annotation 提供了四种元注解，专门注解其他的注解（在自定义注解的时候，需要使用到元注解）：
 *    @Documented – 注解是否将包含在JavaDoc中
 *    @Retention – 什么时候使用该注解
 *    @Target – 注解用于什么地方
 *    @Inherited – 是否允许子类继承该注解
 *
 *   1.）@Retention – 定义该注解的生命周期
 *   ●   RetentionPolicy.SOURCE : 在编译阶段丢弃。这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。@Override, @SuppressWarnings都属于这类注解。
 *   ●   RetentionPolicy.CLASS : 在类加载的时候丢弃。在字节码文件的处理中有用。注解默认使用这种方式
 *   ●   RetentionPolicy.RUNTIME : 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。我们自定义的注解通常使用这种方式。
 *
 *   2.）Target – 表示该注解用于什么地方。默认值为任何元素，表示该注解用于什么地方。可用的ElementType 参数包括
 *   ● ElementType.CONSTRUCTOR: 用于描述构造器
 *   ● ElementType.FIELD: 成员变量、对象、属性（包括enum实例）
 *   ● ElementType.LOCAL_VARIABLE: 用于描述局部变量
 *   ● ElementType.METHOD: 用于描述方法
 *   ● ElementType.PACKAGE: 用于描述包
 *   ● ElementType.PARAMETER: 用于描述参数
 *   ● ElementType.TYPE: 用于描述类、接口(包括注解类型) 或enum声明
 *
 *  3.)@Documented – 一个简单的Annotations 标记注解，表示是否将注解信息添加在java 文档中。
 *
 *  4.)@Inherited – 定义该注释和子类的关系
 *      @Inherited 元注解是一个标记注解，@Inherited 阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited 修饰的annotation 类型被用于一个class，则这个annotation 将被用于该class 的子类。
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodAnnotation {

     /**
      * 模块名称
      * @return
      */
     public String title() default "";

     /**
      * 功能
      * @return
      */
     public String bussinessType() default "other";

     /**
      * 操作级别
      * @return
      */
     public String operatorType() default "other";


}
