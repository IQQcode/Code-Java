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
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    User findbyId(Integer uid);

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int totalCount();

    /**
     * 多个对象组成的查询条件，进行数据的查询
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}