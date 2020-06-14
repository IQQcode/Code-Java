package com.iqqcode.reflect01;

import java.lang.reflect.Method;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-14 17:07
 * @Description:反射3---获取成员方法
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception{
        Class cls = Person.class;
        Person per = new Person();

        //1.获取指定方法
        Method method = cls.getDeclaredMethod("test");
        //private的成员方法需要暴力反射
        //method.setAccessible(true);
        method.invoke(per);

        //2.获取指定参数的方法
        Method method2 = cls.getDeclaredMethod("test",String.class);
        method2.invoke(per,"hahahahahahahaha!");

        //3.获取所有方法
        Method[] method3 = cls.getDeclaredMethods();
        //由于Object类是所有类的父类，所以会打印Object类中方法
        for (Method m : method3) {
            System.out.println(m);
        }

        //4.获取类名
        String className = cls.getName();
        System.out.println(className);
    }
}
