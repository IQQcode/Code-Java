package com.iqqcode.jedis.test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-01 20:50
 * @Description:Jedis的测试类
 */
public class JedisTest {
    @Test
    public void test() {
        //1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.set("name", "Mr.Q");
        //3.关闭连接
        jedis.close();
    }

    /**
     * 操作String
     */
    @Test
    public void testString() {
        Jedis jedis = new Jedis();
        jedis.set("name", "zhangsan");
        String name = jedis.get("name");
        System.out.println(name);
        //可以使用setex()方法存储可以指定过期时间的key-value
        //将activeCode : code 键值对存入redis，并且20秒后自动删除该键值对
        jedis.setex("activeCode", 20, "code");
        jedis.close();
    }

    /**
     * 操作hash
     */
    @Test
    public void testHash() {
        Jedis jedis = new Jedis();
        jedis.hset("user", "name","zhangsan");
        jedis.hset("user", "age","22");
        jedis.hset("user", "gender","male");
        //获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);
        //获取hash中map的所有数据
        Map<String, String> user = jedis.hgetAll("user");
        //keySet()
        Set<String> keys = user.keySet();
        for (String key : keys) {
            //遍历key集合来获取相应value
            String value = user.get(key);
            System.out.println(key + " : " + value);
        }
        jedis.close();
    }

    /**
     * 操作List
     */
    @Test
    public void testList() {
        Jedis jedis = new Jedis();
        //list存储
        // c,b,a,a,b,c
        jedis.lpush("myList", "a","b","c");
        jedis.rpush("myList", "a","b","c");
        //list范围获取
        List<String> myList = jedis.lrange("myList", 0, -1);
        System.out.println(myList);
        String element1 = jedis.lpop("myList");
        System.out.println(element1);
        String element2 = jedis.rpop("myList");
        System.out.println(element2);
        System.out.println(myList);
        jedis.close();
    }

    /**
     * 操作Set
     */
    @Test
    public void testSey() {
        Jedis jedis = new Jedis();
        jedis.sadd("mySet", "Java","Python","Go");
        Set<String> mySet = jedis.smembers("mySet");
        System.out.println(jedis.srem("mySet", "Java"));
        System.out.println(mySet);
        jedis.close();
    }

    /**
     * 操作SortedSet
     */
    @Test
    public void testSortedSet() {
        Jedis jedis = new Jedis();
        //SortedSet存储
        // c,b,a,a,b,c
        jedis.zadd("mySort", 3 , "Apple");
        jedis.zadd("mySort", 10 , "HuaWei");
        jedis.zadd("mySort", 1 , "Mi");
        Set<String> mySort = jedis.zrange("mySort", 0, -1);
        System.out.println(mySort);
        jedis.close();
    }
}
