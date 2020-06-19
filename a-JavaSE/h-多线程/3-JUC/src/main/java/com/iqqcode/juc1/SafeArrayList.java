package com.iqqcode.juc1;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-06 16:37
 * @Description:解决ArrayList线程不安全
 */
public class SafeArrayList {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();

        //List<String> list = new Vector<>();

        //List<String> list = Collections.synchronizedList(new ArrayList<>());

        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }).start();
        }
    }
}
