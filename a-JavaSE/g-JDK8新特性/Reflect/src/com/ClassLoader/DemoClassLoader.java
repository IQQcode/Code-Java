package com.ClassLoader;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-20 11:54
 * @Description:
 */

// 自定义类，这个类一定在CLASSPATH中
class Member { }

public class DemoClassLoader {
    public static void main(String[] args) {
        Class<?> cls = Member.class ;
        System.out.println(cls.getClassLoader()) ;
        System.out.println(cls.getClassLoader().getParent()) ;
        System.out.println(cls.getClassLoader().getParent().getParent());
    }
}
