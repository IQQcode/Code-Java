package com.iqqcode.travelocity.service.impl;


import com.iqqcode.travelocity.dao.CategoryDao;
import com.iqqcode.travelocity.dao.impl.CategoryDaoImpl;
import com.iqqcode.travelocity.domain.Category;
import com.iqqcode.travelocity.service.CategoryService;
import com.iqqcode.travelocity.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-26 16:00
 * @Description:缓存的优化
 * 分类信息不常变化，可以将其放入缓存中优化来减少数据库访问的压力
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findSort() {
        //1.从Jedis中查询
        Jedis jedis = JedisUtil.getJedis();
        //sortedset排序查询
        //Set<String> categorys = jedis.zrange("category", 0, -1);

        //2.判断查询的集合是否为空
        //查询sortedset中的分数(cid)和值(cname)
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        List<Category> cs = null;
        if(categorys == null || categorys.size() == 0) {
            System.out.println("从数据库中查询分类信息...");
            //3.如果集合为空，先从数据库中查询，再放入到Redis
            //从数据库查询
            cs = categoryDao.findSort();
            //将集合数据存储到redis中的 category的key
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        }else {
            //4.不为空，将set的数据存入list
            System.out.println("从Redis中查询分类信息...");
            cs = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                cs.add(category);
            }
        }
        return cs;
    }
}
