package com.Map.HashMap;

import	java.util.Iterator;
import	java.util.HashMap;
import	java.util.Map;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-31 11:41
 * @Description:
 */
public class Test_HashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Today");
        map.put(1, "is");
        map.put(2, "my");
        map.put(3, "21th");
        map.put(4, "Birthday");
        map.put(4, "生日");  // key重复
        System.out.println(map) ;

        // 根据key取得value
        System.out.println(map.get(4)) ;

        // 取得 Map中所有的key值
        Set<Integer> keySet = map.keySet();
        // 取得 Map中所有的value值
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key + "->" + map.get(key));
        }
    }
}
