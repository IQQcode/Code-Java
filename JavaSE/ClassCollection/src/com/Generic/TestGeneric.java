package com.Generic;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-22 17:27
 * @Description:Object引入泛型
 */
/*

class MyCollectin {
    Object[] obj = new Object[5];
    public void set(Object msg,int index) {
        obj[index] = msg;
    }
    public Object get(int index) {
        return obj[index];
    }
}
public class TestGeneric {
    public static void main(String[] args) {
        MyCollectin mc = new MyCollectin();
        mc.set("Mr.Q",0);
        mc.set(666,1);
        System.out.println(mc.get(0));
        System.out.println(mc.get(1));
    }
}
*/


/**
 * Type change the Generic
 */

class MyCollectin <E>{
    Object[] obj = new Object[5];
    public void set(E e,int index) {
        obj[index] = e;
    }
    public E get(int index) {
        return (E)obj[index];
    }
}
public class TestGeneric {
    public static void main(String[] args) {
        MyCollectin<String> mc = new MyCollectin<>();
        mc.set("Mr.Q",0);
        System.out.println(mc.get(0));
    }
}

