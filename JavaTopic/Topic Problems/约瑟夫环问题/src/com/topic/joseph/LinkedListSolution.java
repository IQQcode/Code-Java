package com.topic.joseph;

import	java.util.LinkedList;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-08 18:26
 * @Description:Java自带链表实现
 */
public class LinkedListSolution {
    public static int joseph(int n, int ans) {
        LinkedList<Integer> list = new LinkedList<> ();
        for (int i = 1; i <= n; i++) {
           list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                index++;
                int away = 0;
                if (index == ans) {
                    away = list.get(i);
                    list.remove(i);
                    index = 1;  //指针重置
                    if(i == list.size() || index == ans){
                        index = 0;
                    }
                    System.out.print(away + " ");
                }
            }
        }
        return list.get(0);
    }
}


