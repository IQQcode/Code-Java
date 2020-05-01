package org.iqqcode.test;

import org.apache.commons.dbutils.QueryRunner;
import org.iqqcode.config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-30 17:24
 * @Description:测试QueryRunner是为否单例
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner(){
        //1.获取容易
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取queryRunner对象
        QueryRunner runner = ac.getBean("run",QueryRunner.class);
        QueryRunner runner1 = ac.getBean("run",QueryRunner.class);
        System.out.println(runner == runner1);
    }
}
