package com.iqqcode.traverse;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-09-26 14:25
 * @Description:根据value获取key - key是唯一的, 对应的value有且只有一个
 * - 相同的value, 可能对应不同的key
 */
public class ValueToKey {
    /**
     * @param value
     * @return
     */
    private static List<String> getToKeyI(Map<String, String> map, String value) {
        List<String> keyList = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).equals(value)) {
                keyList.add(key);
            }
        }
        return keyList;
    }

    public static Object getToKeyII(Map<String, String> map, String value) {
        //通过entrySet()方法把 map中的每个键值对变成对应成 Set集合中的一个 ket-value 对象
        Set set = map.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = set.iterator();
        ArrayList<Object> list = new ArrayList();
        while (iterator.hasNext()) {
            //Map.Entry是一种类型，指向map中的一个键值对组成的对象
            Map.Entry<Object, Object> entry = iterator.next();
            if (entry.getValue().equals(value)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private static String getToAllKey(Map<String, String> map, String value) {
        String key = null;
        for (String getKey : map.keySet()) {
            if (map.get(getKey).equals(value)) {
                key = getKey;
            }
        }
        return key;
    }


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "a");
        map.put("3", "b");
        map.put("4", "b");
        map.put("5", "c");

        //获取 value = "a"的key
        System.out.println("【keySet】根据value获取所有key(相同value的key均会获取) " + getToKeyI(map, "a"));
        System.out.println("【Entry】" + getToKeyII(map, "b"));

        Collection<String> values = map.values();
        Set<String> setRes = new HashSet<>();
        for (String value : values) {
            setRes.add(getToAllKey(map, value));
        }
        System.out.println("根据value获取所有key集合(相同value的key只存一个) " + setRes);
    }
}
