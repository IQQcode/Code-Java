package com.iqqcode.jedis.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-02 17:04
 * @Description:JedisPool工具类
 * 加载配置文件，配置连接池的参数
 * 提供获取连接的方法
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        //类加载器读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("com/iqqcode/jedis/config/jedis.properties");
        //创建Properties对象
        Properties props = new Properties();
        //关联文件
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置到JedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        //配置文件中的字符串数字转换成为数字
        config.setMaxTotal(Integer.parseInt(props.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(props.getProperty("maxIdle")));
        //初始化JedisPool
        jedisPool = new JedisPool(config, props.getProperty("host"), Integer.parseInt(props.getProperty("port")));
    }

    /**
     * 获取连接方法
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
