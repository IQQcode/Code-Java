package org.iqqcode.dao;

import org.iqqcode.domain.QueryVo;
import org.iqqcode.domain.User;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:41
 * @Description:
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    /**
     * 根据传入条件动态查询
     * @param user 查询条件不确定(name,age,address or all)
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据id集合查询用户信息(in---子查询)
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}