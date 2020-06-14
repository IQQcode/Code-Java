package com.iqqcode.reflect01;

import java.lang.reflect.Field;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-14 16:18
 * @Description:反射1---获取成员变量
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Class cls = Person.class;
        Person per = new Person();

        //获取所有权限的成员变量
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("\n--------------------------------------------------\n");

        //获取指定的成员变量
        Field name = cls.getDeclaredField("name");
        //获取成员变量值
        //忽略访问权限修饰符的安全检查(IllegalAccessException)
        name.setAccessible(true);  //暴力反射
        name.set(per,"Mr.Q");  //修改值
        Object value = name.get(per);
        System.out.println(value);
    }
}
