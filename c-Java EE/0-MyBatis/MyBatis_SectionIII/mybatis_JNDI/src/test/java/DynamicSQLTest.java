import org.iqqcode.domain.QueryVo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.iqqcode.dao.IUserDao;
import org.iqqcode.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:45
 * @Description:测试类
 */
public class DynamicSQLTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    /**
     * 初始化
     */
    @Before //用于在测试方法之前执行
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After //用于在测试方法之后执行
    public void destroy() throws IOException {
        //5.提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有用户
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 根据条件动态查询
     * @throws IOException
     */
    @Test
    public void testFindUserByCondition() throws IOException {
        User u = new User();
        u.setUsername("小猪佩奇");
        u.setSex("女");
        u.setAddress("北京");
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 测试<foreach>的使用
     * @throws IOException
     */
    @Test
    public void testFindUserInIds() throws IOException {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(51);
        list.add(50);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
