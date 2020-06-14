package com.iqqcode.reflect01;

import java.lang.reflect.Constructor;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-14 16:51
 * @Description:反射2---获取构造方法
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class cls = Person.class;

        Constructor cos1 = cls.getDeclaredConstructor(String.class,int.class);
        //private的构造方法需要暴力反射(单例模式)
        cos1.setAccessible(true);
        Object obj1 = cos1.newInstance("Mr.Q",18);
        System.out.println(obj1);

        //空参构造I
        Constructor cos2 = cls.getDeclaredConstructor();
        Object obj2 = cos2.newInstance();
        System.out.println(obj2);

        //空参构造II--使用Class对象的newInstance()
        Object obj3 = cls.newInstance();
        System.out.println(obj3);
    }
}
