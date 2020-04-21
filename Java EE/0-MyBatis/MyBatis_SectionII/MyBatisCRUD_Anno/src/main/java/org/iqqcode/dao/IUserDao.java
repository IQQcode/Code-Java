package org.iqqcode.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} ")
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id=#{uid}")
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    @Select("select * from user where id = #{uid}")
    User findbyId(Integer uid);

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{name}")
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    @Select("select count(id) from user")
    int totalCount();

    /**
     * 多个对象组成的查询条件，进行数据的查询
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    @Select("select * from user where username like #{user.username}")
    List<User> findUserByVo(QueryVo vo);
}