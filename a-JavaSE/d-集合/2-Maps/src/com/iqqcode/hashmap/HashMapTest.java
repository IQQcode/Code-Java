package com.iqqcode.hashmap;
import	java.util.HashMap;

import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 08:51
 * @Description:HashMap使用
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<> ();
        String v1 = map.put("华为", "余大嘴");
        System.out.println("v1 : " + v1);
        System.out.println(map.get("华为"));

        String v2 = map.put("华为", "任正非");
        System.out.println("v2 : " + v2);
        System.out.println(map);
    }
}
