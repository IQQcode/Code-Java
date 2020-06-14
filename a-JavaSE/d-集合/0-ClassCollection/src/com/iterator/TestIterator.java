package com.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-31 09:36
 * @Description:
 */
public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // modCount = 1
        list.add("Today");
        // modCount = 2
        list.add("is");
        // modCount = 3
        list.add("My");
        // modCount = 4
        list.add("21th");
        // modCount = 5
        list.add("Birthday...");
        // expectedModCount = 4
        Iterator<String> iterator = list.iterator();
        //迭代输出
        while(iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
            // modCount = 6
            // modCount != expectedModCount
            // throw new ConcurrentModificationException();
            list.remove(2);
        }

        for (String strs : list) {
            System.out.print(strs + " ");
        }
    }
}
