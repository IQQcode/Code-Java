package org.iqqcode.dao;

import org.iqqcode.domain.Role;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:41
 * @Description:
 */
public interface IRoleDao {
    /**
     * 查询所有角色，同时获取到角色下所有用户的信息
     * @return
     */
    List<Role> findAll();
}