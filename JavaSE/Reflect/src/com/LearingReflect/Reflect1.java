package com.LearingReflect;

import java.util.Date;


/**
 * @反射 : 根据现有对象倒推类的组成
 *
 * 最核心:Class类
 * 任何一个类在JVM中都有唯一的一个class对象,此对象记录该类的组成结构。
 * 当类加载时由JVM产生，用户只能取得此对象无法创建。
 */

/*
class Person {
    int id;
    String name;
    public Person(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

public class Reflect1 {
    public static void main(String[] args) {
        Person per = new Person(18,"刘德华");
        System.out.println(per.getClass());
        System.out.println(per.getClass().getName());
    }
}
*/

/**
 * 取得类的class对象:
 * I.  调用 Object提供的 getClass方法
 * II. 类名称.class
 * III.调用Class类提供的静态方法 Class.forName(类的全名称);
 */

public class Reflect1 {

    public static void main(String[] args) throws ClassNotFoundException {

        //正向处理
        Date data = new Date();//1

        //I.通过对象调用 getClass();方法
        Class<Date> cls = (Class<Date>) data.getClass();
        //取得Data类的Class对象
        System.out.println(cls);//2
        System.out.println(data.getClass().getName());//作用等同于第一、第二句

        //II.通过  类名称.class
        System.out.println(Date.class);

        //III.调用Class类提供的静态方法Class.forName(类的全名称);
        Class msg = Class.forName("java.util.Date");
        System.out.println(msg);
    }
}


