package com.inner.statc;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-15 17:55
 * @Description:
 */
class Out {

    private static int i = 10;
    private int j = 20;

    public static void outer_f1() {
        System.out.println("访问外部类的静态成员");
    }

    public void outer_f2() {
        System.err.println("不能访问外部类的非静态成员");
    }

    //静态内部类
    private static class Inner {

        static int inner_i = 100;
        int inner_j = 200;

        // 静态内部类只能访问外部类的静态成员(包括静态变量和静态方法)
        static void inner_f1() {
            System.out.println("Outer.i:  " + i);
            outer_f1();
        }

        void inner_f2() {
            // 静态内部类不能访问外部类的非静态成员(包括非静态变量和非静态方法)
        }
    }

    public void outer_f3() {
        // 外部类访问内部类的静态成员：内部类.静态成员
        System.out.println("Inner.i:  " + Inner.inner_i);
        Inner.inner_f1();

        // 外部类访问内部类的非静态成员:实例化内部类即可
        new Inner().inner_f2();
    }
}

public class Outerclass {
    public static void main(String[] args) {
        new Out().outer_f3();
    }
}

