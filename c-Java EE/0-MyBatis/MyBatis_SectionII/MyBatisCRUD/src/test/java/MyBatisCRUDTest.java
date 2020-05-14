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
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:45
 * @Description:测试类
 */
public class MyBatisCRUDTest {
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
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 测试保存用户
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("MyBatis");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("西安市");
        System.out.println("保存操作之前：" + user);
        //执行方法
        userDao.saveUser(user);
        System.out.println("保存操作之后：" + user);
    }

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(49);
        user.setUsername("Update");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("西安市");
        //执行方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteUser() {
        userDao.deleteUser(49);;
    }

    /**
     * 测试查询一个用户
     */
    @Test
    public void testFindOne() {
        User u = userDao.findbyId(48);
        System.out.println(u);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindLike() {
        //List<User> users = userDao.findByName("乔");
        List<User> users = userDao.findByName("%乔%");
        for (User us : users) {
            System.out.println(us);
        }
    }

    /**
     * 测试查询用户数目
     */
    @Test
    public void testTotalCount() {
        int count = userDao.totalCount();
        System.out.println("user count is: " + count);
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%乔%");
        vo.setUser(user);
        //5.执行查询一个方法
        List<User> users = userDao.findUserByVo(vo);
        for(User u : users){
            System.out.println(u);
        }
    }
}
