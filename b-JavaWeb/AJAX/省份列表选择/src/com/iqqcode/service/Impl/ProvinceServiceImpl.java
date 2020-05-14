package com.iqqcode.service.Impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iqqcode.dao.Impl.ProvinceDaoImpl;
import com.iqqcode.dao.ProvinceDao;
import com.iqqcode.domain.Province;
import com.iqqcode.service.ProvinceService;
import com.iqqcode.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-17 13:47
 * @Description:使用redis缓存
 */
public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        //从redis中查询数据
        //1.获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String p_json = jedis.get("province");

        //2判断p_json数据是否为null
        //redis中没有数据
        if(p_json == null || p_json.length() == 0) {
            System.out.println("redis中没有数据，从数据库中查找...");
            //2.1从数据库中查询
            List<Province> all = dao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                p_json = mapper.writeValueAsString(all);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3将json数据存入redis
            jedis.set("province",p_json);
            //关闭连接
            jedis.close();
        }
        return p_json;
    }
}
