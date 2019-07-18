package com.Annotations;

import java.lang.reflect.Field;

public class AnnotationUtils {
    public static void main(String[] args) {

        Class<Person> cls = Person.class;

        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            if(field.isAnnotationPresent(Name.class)) {
                //获得作用在该方法上的 Name类的注解
                Name annotation = field.getAnnotation(Name.class);
                String value = annotation.value();
                System.out.println(field.getName() + " : " + value);
            }
            if(field.isAnnotationPresent(Sex.class)) {
                //获得作用在该方法上的 Sex类的注解
                Sex annotation = field.getAnnotation(Sex.class);
                String value = annotation.gender().name();
                System.out.println(field.getName() + " : " + value);
            }
        }
    }
}
