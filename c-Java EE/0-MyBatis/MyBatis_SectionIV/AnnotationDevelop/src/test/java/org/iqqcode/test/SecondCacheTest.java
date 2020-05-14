package org.iqqcode.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.iqqcode.dao.IUserDao;
import org.iqqcode.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-21 16:51
 * @Description:测试类
 */
public class SecondCacheTest {
    private InputStream in;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindOne() {
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
        User user = userDao.findById(52);
        System.out.println(user);

        sqlSession.close();//释放一级缓存

        SqlSession sqlSession1 = factory.openSession();//再次打开session
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(52);
        System.out.println(user1);
        System.out.println(user==user1);
    }
}
