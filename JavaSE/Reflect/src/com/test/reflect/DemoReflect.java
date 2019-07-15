package com.test.reflect;

import	java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class DemoReflect {
    public static void main(String[] args) {
        String path = "com.test.reflect.User";
        try {
            Class<User> cls2 = User.class;//拿到类的对象

            Class<?> cls1 = path.getClass();
            Class clazz = Class.forName("java.util.Date");
            System.out.println(clazz);
            System.out.println(cls1);
            System.out.println(cls2);

            //取得类的属性
            Field[] fields = cls2.getDeclaredFields();
            System.out.println(fields.length);

            //通过反射API调用构造方法
            User u = cls2.newInstance();
            System.out.println(u);
            //指定构造器
            Constructor<User> use = cls2.getDeclaredConstructor(int.class, int.class,String.class);
            User u2 = use.newInstance(2019,21,"Mr.Q");
            System.out.println("\n" + u2.getName());

            //通过反射API来调用普通方法
            //----> 正向调用   u3.setName("IQQCode")
            /**
             * 反射的好处是只传入方法名，传入的方法和参数都是变量，就可以动态的调用相关的方法
             */
            User u3 = cls2.newInstance();
            Method method = cls2.getDeclaredMethod("setName", String.class);
            method.invoke(u3,"IQQCode");
            System.out.println(u3.getName());

            //通过反射API操作属性
            User u4 = cls2.newInstance();
            Field field = cls2.getDeclaredField("name");
            field.set(u4,"犹梦");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
