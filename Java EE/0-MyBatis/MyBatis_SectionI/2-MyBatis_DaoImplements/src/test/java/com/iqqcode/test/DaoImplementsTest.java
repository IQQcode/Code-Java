package com.iqqcode.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.iqqcode.dao.IUserDao;
import org.iqqcode.dao.Impl.UserDaoImpl;
import org.iqqcode.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-08 16:27
 * @Description:dao有实现类测试
 */
public class DaoImplementsTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3.使用工厂创建dao对象
        IUserDao userDao = new UserDaoImpl(factory);

        //4.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //5.释放资源
        in.close();
    }
}
