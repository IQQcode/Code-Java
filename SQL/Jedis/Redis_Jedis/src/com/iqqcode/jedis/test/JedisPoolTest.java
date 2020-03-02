package com.iqqcode.jedis.test;


import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-02 16:53
 * @Description:JedisPool连接池
 */
public class JedisPoolTest {
    @Test
    public void test() {
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //1.创建JedisPool连接池对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        //2.获取连接
        Jedis jedis = jedisPool.getResource();
        String s = jedis.set("username", "Mr.Q");
        jedis.close();
    }
}
