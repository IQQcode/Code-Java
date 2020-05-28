package com.iqqcode.collection;

import	java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-24 16:32
 * @Description:Collection集合
 */
public class Collections {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("Java");
        coll.add("Python");
        coll.add("C++");
        coll.add("GoLang");
        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            String msg = it.next();
            System.out.println(msg);
        }
    }
}
