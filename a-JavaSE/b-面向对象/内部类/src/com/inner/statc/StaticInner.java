package com.inner.statc;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-15 17:40
 * @Description:静态内部类
 */
class Outer {
    private int num;
    private static String msg = "Hello World" ;

    //定义一个静态内部类
    static class Iner {
        //此时只能使用外部类中的static属性
        public void method() {
            /*System.out.println(num); ！！无法访问外部类普通成员变量*/
            System.out.println("访问外部类静态成员变量  " + msg); //访问外部类静态成员变量
        }
    }

    //在外部类中定义一个方法，该方法负责产生内部类对象并且调用method()方法
    public void fun() {
        //实例化内部类对象
        Iner in = new Iner();
        in.method();
    }
}

public class StaticInner {
    public static void main(String[] args) {
        Outer.Iner obj = new Outer.Iner();
        obj.method();
    }
}
