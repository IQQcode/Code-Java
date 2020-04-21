import org.iqqcode.dao.IAccountDao;
import org.iqqcode.domain.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:45
 * @Description:测试类
 */
public class OntToOne_AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

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
        accountDao = sqlSession.getMapper(IAccountDao.class);
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
        List<Account> accs = accountDao.findAll();
        for (Account acc : accs) {
            System.out.println(acc);
        }
    }

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @throws IOException
     */
    @Test
    public void testFindAccountUser() throws IOException {
        List<Account> accs = accountDao.findAccountUser();
        for (Account acc : accs) {
            System.out.println(acc);
        }
    }

}
