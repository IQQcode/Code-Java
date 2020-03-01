package com.iqqcode.jedis.test;
import	java.util.Map;
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

    @Test
    public void testHash() {
        Jedis jedis = new Jedis();
        jedis.hset("user", "name","zhangsan");
        jedis.hset("user", "age","22");
        jedis.hset("user", "gender","male");
        //获取hsah
        String name = jedis.hget("user", "name");
        System.out.println(name);
        //获取hash中map的所有数据
        Map<String, String> user = jedis.hgetAll("user");
        //keySet()
        Set<String> keys = user.keySet();
        for (String key : keys) {
            //获取value
            String value = user.get(key);
            System.out.println(key + " : " + value);
        }
        jedis.close();
    }
}
