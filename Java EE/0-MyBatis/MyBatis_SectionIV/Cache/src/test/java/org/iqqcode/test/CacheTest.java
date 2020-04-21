package org.iqqcode.test;

import org.iqqcode.dao.IUserDao;
import org.iqqcode.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class CacheTest {

    private InputStream in;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception {
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testLevelCache(){
        User u1 = userDao.findById(51);
        System.out.println(u1);
        userDao = sqlSession.getMapper(IUserDao.class);
        User u2 = userDao.findById(51);
        System.out.println(u2);
        System.err.println(u1==u2);
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
        User u1 = userDao.findById(51);
        System.out.println(u1);
        //清空缓存
        sqlSession.clearCache();
        userDao = sqlSession.getMapper(IUserDao.class);
        User u2 = userDao.findById(51);
        System.out.println(u2);
        System.err.println(u1==u2);
    }

}
