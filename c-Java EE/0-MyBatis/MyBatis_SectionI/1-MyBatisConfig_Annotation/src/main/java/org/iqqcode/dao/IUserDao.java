package org.iqqcode.dao;


import org.apache.ibatis.annotations.Select;
import org.iqqcode.domain.User;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-08 12:19
 * @Description:用户持久层接口(数据访问层)
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
