package com.iqqcode.traverse;
import	java.util.HashSet;
import org.junit.Test;

import	java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 09:42
 * @Description:Map集合的遍历
 */
public class MapTravel {
    //通过map.keySet()获取key, 通过key找到value
    @Test
    public void test1() {
        Map<String,String> map = new HashMap<> ();
        map.put("张三","内蒙古");
        map.put("李四","北京");
        map.put("王五","上海");
        map.put("赵六","杭州");
        map.put("田七","南京");
        //通过map.keySet()获取key, 通过key找到value
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key:" + key + " value:" + value);
        }
    }

    //通过Map.Entry(String,String)获取，然后使用entry.getKey()获取到键，通过entry.getValue()获取到值
    @Test
    public void test2() {
        Map<String,String> map = new HashMap<> ();
        map.put("张三","内蒙古");
        map.put("李四","北京");
        map.put("王五","上海");
        map.put("赵六","杭州");
        map.put("田七","南京");
        //entry.getKey()获取到键，通过entry.getValue()获取到值
        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

        //迭代器遍历
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, String> entry=it.next();
            System.out.println("键key ："+entry.getKey()+" value ："+entry.getValue());
        }
    }

    //第三种 先放入Set集合中，Iterator遍历获取
    @Test
    public void test3() {
        Map<String,String> map = new HashMap<> ();
        map.put("张三","内蒙古");
        map.put("李四","北京");
        map.put("王五","上海");
        map.put("赵六","杭州");
        map.put("田七","南京");

        //使用Map集合中的方法 entryset()，把Map集合中多个Entry对象取出来，存储到一个Set集合中
        Set<Map.Entry<String, String>> set = new HashSet<> ();

        //使用迭代器遍历Set集合，获取每一个Entry对象
        Iterator<Map.Entry<String, String>> it = set.iterator();

        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:" + key + " value:" + value);
        }
    }

    //第四种只遍历键或者值，通过加强for循环
    @Test
    public void test4() {
        Map<String,String> map = new HashMap<> ();
        map.put("张三","内蒙古");
        map.put("李四","北京");
        map.put("王五","上海");
        map.put("赵六","杭州");
        map.put("田七","南京");
        //第三种只遍历键或者值，通过加强for循环
        //遍历map的键
        for(String key : map.keySet()) {
            System.out.println("key: " + key);
        }

        //遍历map的值
        for(String value : map.values()) {
            System.out.println("value: " + value);
        }
    }
}
