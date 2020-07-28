package com.iqqcode.dao.impl;

import com.iqqcode.dao.UserDao;
import com.iqqcode.domain.User;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-28 00:37
 * @Description:
 */

@Data
public class UserDaoImpl implements UserDao {

    //注入基本类型
    private String name;
    private int age;

    //注入集合
    private int[] arr;
    private List<Integer> list;
    private Map<String, User> map;
    private Properties propt;


    @Override
    public void save() {
        System.out.println("user save!");

        System.out.println("name: " + name + "\tage: " + age);

        System.out.println(list);
        System.out.println(map);
        System.out.println(propt);
    }
}
