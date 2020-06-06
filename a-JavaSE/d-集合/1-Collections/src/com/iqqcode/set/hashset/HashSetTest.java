package com.iqqcode.set.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-24 23:07
 * @Description:
 */
public class HashSetTest {
    public static void main(String[] args) {
        //创建Set集合
        Set<String> set  = new HashSet<>();
        String s1 = new String("a");
        String s2 = new String("a");
        set.add(s1);
        set.add(s2);
        set.add("重地"); //1179395
        set.add("通话"); //1179395
        set.add("a");
        System.out.println(set);
        System.out.println("a".hashCode());
    }
}
