import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.iqqcode.dao.IRoleDao;
import org.iqqcode.domain.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:45
 * @Description:测试类
 */
public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IRoleDao roleDao;

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
        roleDao = sqlSession.getMapper(IRoleDao.class);
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
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("--------------每个角色的信息---------------");
            System.out.println(role);
            System.out.println(role.getPersons());
        }
    }
}
