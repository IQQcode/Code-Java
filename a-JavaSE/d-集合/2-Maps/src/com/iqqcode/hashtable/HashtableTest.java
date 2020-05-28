package com.iqqcode.hashtable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 10:54
 * @Description:Hashtable使用
 */
public class HashtableTest {
    public static void main(String[] args) {
        //HashMap允许存放空值
        Map<String,String> map = new HashMap<>();
        map.put("张三",null);
        map.put(null,"北京");
        map.put(null,null);
        System.out.println(map);

        //Hashtable不允许存放空值
        Map<String, String> tab = new Hashtable<>();
        tab.put("张三",null); //产生空指针异常
        tab.put(null,"北京"); //产生空指针异常
        tab.put(null,null); //产生空指针异常
        System.out.println(tab);
    }
}
