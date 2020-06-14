package com.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-31 13:07
 * @Description:Map集合输出
 */
public class MapIterator {

    public static void main(String[] args) {
        Map<Integer, String> maps = new HashMap<>();
        maps.put(1, "Today");
        maps.put(2, "is");
        maps.put(3, "My");
        maps.put(4, "Birthday");
        maps.put(5, null);
        //map -> set
        // map的标准输出
        Set<Map.Entry < Integer, String>> set = maps.entrySet();
        Iterator<Map.Entry < Integer, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " -> "+entry.getValue());
        }
    }
}
