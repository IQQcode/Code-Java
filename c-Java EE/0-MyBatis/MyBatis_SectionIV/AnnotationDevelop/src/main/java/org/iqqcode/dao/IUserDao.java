package org.iqqcode.dao;

import org.apache.ibatis.annotations.*;
import java.util.List;
import org.apache.ibatis.mapping.FetchType;
import org.iqqcode.domain.User;
/**
 * @Author: Mr.Q
 * @Date: 2020-04-21 16:40
 * @Description:表结构一对多关系关系映射
 */
public interface IUserDao {
    @Select("select * from user")
    //重新映射表字段
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "org.iqqcode.dao.IAccountDao.findAccountByUid",
                            fetchType = FetchType.LAZY))
    })

    List<User> findAll();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{id}")
    @ResultMap("userMap")
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username} ")
    @ResultMap("userMap")
    List<User> findUserByName(String username);
}



