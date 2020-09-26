package com.iqqcode.traverse;

import org.junit.Test;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-09-26 13:29
 * @Description:HashMap value-key反转
 */
public class Value_Key {
    /**
     * 排除相同value
     */
    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "111");
        map.put("李四", "222");

        map.put("王五", "333");
        map.put("赵六", "333");

        map.put("田七", "444");
        map.put("田七", "555");

        Map<String, String> rever = new HashMap<>();
        //获取key集合
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("key ---- " + key);
        }
        for (String key : keys) {
            String value = map.get(key);
            rever.put(value, key);
        }

        rever.forEach((key, value) -> {
            System.out.println("key:" + key + "  value:" + value);
        });
    }


    /**
     * 相同的value对应一个key(不排除)
     */
    @Test
    public void test2() {
        Map<Integer, String> map = new HashMap();
        map.put(1, "A");
        map.put(2, "A");
        map.put(3, "B");
        map.put(4, "C");
        map.put(5, "A");
        map.put(6, "D");
        System.out.println(map);

        Map<String, String> reverseMap = new HashMap<>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> next = (Map.Entry<Integer, String>) it.next();
            if (reverseMap.containsKey(next.getValue())) {
                //将相同value的key追加到一起
                // A = 1 - 2 - 5
                StringBuffer sb = new StringBuffer(reverseMap.get(next.getValue()));
                sb.append("-" + next.getKey());
                reverseMap.put(next.getValue(), sb.toString());

            } else {
                reverseMap.put(next.getValue(), next.getKey() + "");
            }
        }
        System.out.println(reverseMap);
    }

}
