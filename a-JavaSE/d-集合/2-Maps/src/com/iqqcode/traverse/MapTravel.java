package com.iqqcode.traverse;

import java.util.*;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 09:42
 * @Description:Map集合的遍历
 */
public class MapTravel {
    /**
     * 【EntrySet】
     * 通过Map.Entry(String,String)来映射结果集
     * - 然后使用entry.getKey()获取到键
     * - 通过entry.getValue()获取到值
     */
    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "内蒙古");
        map.put("李四", "北京");
        map.put("王五", "上海");
        map.put("赵六", "杭州");
        map.put("田七", "南京");

        //增强for遍历
        //entry.getKey()获取到键，通过entry.getValue()获取到值
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

        System.out.println("========================分割线==============================");

        //迭代器遍历
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("键key ：" + entry.getKey() + " value ：" + entry.getValue());
        }
    }


    /**
     * 【KeySet】: 将HashMap中的key取出放入到Set集合中，根据key映射value
     * - 通过map.keySet()获取key
     * - 通过key找到value
     */
    @Test
    public void test2() {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "内蒙古");
        map.put("李四", "北京");
        map.put("王五", "上海");
        map.put("赵六", "杭州");
        map.put("田七", "南京");
        //通过map.keySet()获取key, 通过key找到value
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key:" + key + " value:" + value);
        }

        System.out.println("========================分割线==============================");

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }


    /**
     * 【Lambda】
     * JDLK8 后Map默认的迭代
     */
    @Test
    public void test3() {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "内蒙古");
        map.put("李四", "北京");
        map.put("王五", "上海");
        map.put("赵六", "杭州");
        map.put("田七", "南京");
        // key-value的类型省略
        map.forEach((key, value) -> {
            System.out.println("key:" + key + " value:" + value);
        });
    }


    /**
     * 【Streams API 单线程】
     */
    @Test
    public void test4() {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "内蒙古");
        map.put("李四", "北京");
        map.put("王五", "上海");
        map.put("赵六", "杭州");
        map.put("田七", "南京");
        map.put("贾七", "南京");
        // 遍历
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }


    /**
     * 【Set集合分别获取key与value -- key不能重复, key-value顺序不对应】
     * - 遍历map的键[]
     * - 遍历map的值
     */
    @Test
    public void test5() {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "内蒙古");
        map.put("李四", "北京");
        map.put("王五", "上海");
        map.put("赵六", "杭州");
        map.put("田七", "南京");
        map.put("郑八", "南京");
        //第三种只遍历键或者值，通过加强for循环
        //遍历map的键
        for (String key : map.keySet()) {
            System.out.println("key: " + key);
        }

        //遍历map的值
        for (String value : map.values()) {
            System.out.println("value: " + value);
        }
    }
}
