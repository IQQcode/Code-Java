package com.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-31 10:02
 * @Description:
 */
public class Test_ListIterator {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        Collections.addAll(lists, "Today","is","My","21th","Birthday...");
        ListIterator<String> iterator = lists.listIterator();
        //双向迭代输出
        while(iterator.hasNext()) {
            String str = iterator.next();
            System.out.print(str + " ");
        }
        System.out.println("\n----------------------------");
        while(iterator.hasPrevious()) {
            String str = iterator.previous();
            System.out.print(str + " ");
        }
    }
}
