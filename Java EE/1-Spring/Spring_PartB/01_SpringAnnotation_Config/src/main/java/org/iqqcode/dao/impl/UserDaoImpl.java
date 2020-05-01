package org.iqqcode.dao.impl;

import org.iqqcode.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 10:58
 * @Description:用户的持久层接口实现类
 * xml配置
 *     <bean id="userDao" class="org.iqqcode.dao.impl.UserDaoImpl"/>
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void regist() {
        System.out.println("user regist...");
    }
}
