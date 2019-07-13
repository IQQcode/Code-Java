package com.test.reflect;

public class DemoReflect {
    public static void main(String[] args) {
        String path = " com.test.reflect.User";
        try {
            Class<?> cls1 = path.getClass();
            Class<?> cls2 = String.class;
            Class cls3 = Class.forName(path);
            System.out.println(cls1);
            System.out.println(cls2);
            System.out.println(cls3);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
