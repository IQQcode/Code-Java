package com.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-22 17:56
 * @Description:List接口方法的使用
 */
public class ListMethod {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(2,"Mr.Q");
        System.out.println(list);
        System.out.println(list.contains(3));
        System.out.println(list.size());
        //remove的并不是对象本身，而是在容器中的地址
        System.out.println("移除指定元素" + list.remove(2));
        System.out.println(list.get(0));
        System.out.println(list.set(0,"7"));
        System.out.println(list);
    }
}
