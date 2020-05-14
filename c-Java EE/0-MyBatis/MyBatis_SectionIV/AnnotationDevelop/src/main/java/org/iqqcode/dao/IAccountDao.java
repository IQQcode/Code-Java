package org.iqqcode.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.iqqcode.domain.Account;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-21 16:40
 * @Description:表结构一对一关系关系映射
 */
public interface IAccountDao {
    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",
                    one = @One(select="org.iqqcode.dao.IUserDao.findById",
                            fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid = #{userId}")
    List<Account> findAccountByUid(Integer userId);
}



