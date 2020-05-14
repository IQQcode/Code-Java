package org.iqqcode.dao;


import org.iqqcode.domain.Person;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:41
 * @Description:
 */
public interface IPersonDao {
    /**
     * 查询所有用户，同时获取到用户下所有角色的信息
     * @return
     */
    List<Person> findAll();
}