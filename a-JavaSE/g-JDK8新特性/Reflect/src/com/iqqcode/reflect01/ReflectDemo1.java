package com.iqqcode.reflect01;

import java.util.Date;

/**
 * 取得类的class对象:
 * I.  调用 Object提供的 getClass方法
 * II. 类名称.class
 * III.调用Class类提供的静态方法 Class.forName(类的全名称);
 */

public class ReflectDemo1 {

    public static void main(String[] args) throws ClassNotFoundException {

        //I.调用Class类提供的静态方法Class.forName(类的全名称);
        Class cls1 = Class.forName("java.util.Date");
        System.out.println(cls1);

        //II.通过类名称.class
        Class<?> cls2 = Date.class;
        System.out.println(cls2);

        //III.通过对象调用getClass();方法
        Date data = new Date();
        Class<?> cls3 = data.getClass();
        System.out.println(cls3);
    }
}


