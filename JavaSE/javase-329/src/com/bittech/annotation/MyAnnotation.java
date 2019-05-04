package com.bittech.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解：
 * 1. 注解类是一个接口，interface前面添加@符号
 * 2. 通过@Retention标注作用范围
 * 3. 通过@Target标注注解使用的位置（类型，方法，参数，变量等）
 * 4. 注解类定义了抽象方法，如果无默认值，使用时需要指定值
 * 在抽象方法签名之后通过default关键字添加默认值
 * <p>
 * Author: secondriver
 * Created: 2019/3/31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface MyAnnotation {
    
    String name() default "lisi";
    
    int age() default 10;
}


