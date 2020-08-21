package com.iqqcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: iqqcode
 * @Date: 2020-08-10 15:58
 * @Description:
 */
public class ListTest {
    public static void main(String[] args) {
        //Map<String, String> map = new HashMap<>();
        //Map<String, String> map = new ConcurrentHashMap<>();
        Map<String, String> map = new Hashtable<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        //ConcurrentModificationException
        for (String s : map.keySet()) {
            if(s.equals("2")) {
                map.remove(s);
            }
        }

        /*Iterator var2 = map.keySet().iterator();

        while(var2.hasNext()) {
            String s = (String)var2.next();
            if (s.equals("2")) {
                //调用iterator的remove()
                //map.remove(s);
                var2.remove(); //保证了modCount和exceptedModCount相等
            }
        }*/
    }
}