package com.Annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)

@Retention(RetentionPolicy.RUNTIME)

//自定义 Name注解
public @interface Name {
    String value() default "";
}
