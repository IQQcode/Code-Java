package org.iqqcode.dao.Impl;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.iqqcode.dao.IUserDao;
import org.iqqcode.domain.User;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-08 16:28
 * @Description:
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory  factory){
        this.factory = factory;
    }

    public List<User> findAll(){
        //1.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询所有方法
        List<User> users = session.selectList("org.iqqcode.dao.IUserDao.findAll");
        session.close();
        //3.返回查询结果
        return users;
    }
}
