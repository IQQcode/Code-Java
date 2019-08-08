package com.LearingReflect;

import java.util.Date;


/**
 * 通过反射实例化对象：
 * 1.创建该类的新对象(简单工厂模式)
 * 2.取得包名、父类、父接口信息
 * 3.取得构造方法 getConstructers()、普通方法 getMethods()、普通属性 getFields()
 */


interface IMessage { }

interface INews { }

class MyClassImpl implements IMessage,INews { }

public class Reflect2 {
    public static void main(String[] args) throws Exception {

        Class<Date> cls = Date.class;


        //通过反射取得 Date类对象
        System.out.println("通过反射取得 Date类对象:");
        Date date = cls.newInstance();
        System.out.println(date);

        //取得该类的包名
        System.out.println("\n取得该类的包名:" + cls.getPackage().getName());

        //取得父类的Class对象
        System.out.println("取得父类的Class对象:" + cls.getSuperclass().getName());

        //取得一个类的父接口
        System.out.println("取得一个类的父接口:");
        Class[] classes = MyClassImpl.class.getInterfaces();
        for(Class msg : classes) {
            System.out.println(msg);
        }
    }
}







/**
 * 反射调用构造
 */
/*
class Person {
    private String name;
    private Integer age;

    public Person() { }   //无参构造

    Person(Integer age) {  //default权限的有参构造
        this.age = age;
    }

    private Person(String name,Integer agr) {
        this.name = name;
        this.age = age;
    }
}
 */


/**
 * 取得所有构造方法
 * Class类提供的getConstructors() : 只能取得权限为public的构造方法
 *
 * Class类提供的getDeclaredConstructors() : 可以取得类中所有构造方法
 */
/*

public  class Reflect2 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Person> per = Person.class;    //取得 Person()类的class对象

        //取得所有构造方法
        Constructor[] constructors = per.getDeclaredConstructors();//多个构造方法，放入数组
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}


public class Reflect2 {
    public static void main(String[] args) throws  Exception {
        Class<Person> cls = Person.class;

        //取得有参构造
        //构造函数参数类型.class
        Constructor constructor = cls.getConstructor(String.class,int.class);

        //实例化对象
        //相当于调用 Person per = new Person("大二",20)
        Person per = (Person) constructor.newInstance("大二",20);
        System.out.println(per);
    }
}
*/
