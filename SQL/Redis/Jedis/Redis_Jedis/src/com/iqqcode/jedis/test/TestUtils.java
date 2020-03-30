package com.iqqcode.jedis.test;


import com.iqqcode.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-02 17:36
 * @Description:
 */
public class TestUtils {
    @Test
    public void testJedisPoolUtils() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("age" , "18");
        String age = jedis.get("age");
        System.out.println(age);
        jedis.close();
    }
}
