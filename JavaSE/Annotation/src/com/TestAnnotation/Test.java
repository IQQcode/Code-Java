package com.TestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        MyTest myTest = new MyTest();

        Class<MyTest> classType = MyTest.class;

        Method method = classType.getMethod("print", new Class[]{});
        //查看某个方法是否存在该注解
        if(method.isAnnotationPresent(MyAnnotation.class)) {
            //获得作用在该方法上的MyAnnotation类的注解
            MyAnnotation myAnnotation =  method.getAnnotation(MyAnnotation.class);
            String hello = myAnnotation.hello();
            String world = myAnnotation.world();
            System.out.println(hello + "  " +world);
        }
        //得到方法的所有注解，并遍历
        Annotation[] annotations =  method.getAnnotations();
        for(Annotation a : annotations) {
            System.out.println(a);
        }
    }
}


