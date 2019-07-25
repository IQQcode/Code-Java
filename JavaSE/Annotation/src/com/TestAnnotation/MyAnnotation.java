package com.TestAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target 表示自定义的 Annotation可以使用在方法或者类上
 */

@Target(value = {ElementType.METHOD, ElementType.FIELD})

/**
 * @Retention 表示自定义的Annotation不仅被保存在class文件中，jvm加载class文件后，仍然存在
 */

@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnotation {
    String hello() default "你好！";

    String world();
}



