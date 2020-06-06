package com.iqqcode.treemap;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-31 14:22
 * @Description:TreeMap使用
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<String,String> treeMap = new TreeMap<String, String>();
        treeMap.put("202001","张三");
        treeMap.put("202020","李四");
        treeMap.put("202007","王五");
        treeMap.put("202133","赵六");
        for (String s : treeMap.keySet()) {
            String value = treeMap.get(s);
            System.out.println("key: " + s + "   value: " + value);
        }
    }
}
