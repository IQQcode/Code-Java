package com.iqqcode.set;
import java.sql.SQLOutput;
import	java.util.HashSet;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-24 21:38
 * @Description:
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Integer> set  = new HashSet<> ();
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(3);
        set.add(1);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("重地".hashCode()); //1179395
        System.out.println("通话".hashCode()); //1179395
    }
}
