package com.iqqcode.generic;
import	java.util.ArrayList;

import java.util.Collection;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-24 20:03
 * @Description:泛型通配符
 * 泛型的上限：? extends E 表示使用的泛型只能是E的子类/本身
 * 泛型的下限：? super E   表示使用的泛型只能是E的父类/本身
 */
public class Generic {
    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList<>();
        Collection<String> list2 = new ArrayList<>();
        Collection<Number> list3 = new ArrayList<>();
        Collection<Object> list4 = new ArrayList<>();
        getElement1(list1);
        //getElement1(list2); 报错，String不是Number的子类
        getElement1(list3);
        //getElement1(list4); 报错，Object不是Number的子类

        //getElement2(list1); 报错，Integer不是Number的父类
        //getElement2(list2); 报错，String不是Number的父类
        getElement2(list3);
        getElement2(list4);
    }

    /**
     * 泛型的上限：此时泛型?是Number类型及其子类
     * @param coll
     */
    public static void getElement1(Collection<? extends Number> coll) {}

    /**
     * 泛型的下限：此时泛型?是Number类型及其父类
     * @param coll
     */
    public static void getElement2(Collection<? super Number> coll) { }

}
