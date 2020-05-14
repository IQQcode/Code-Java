package iqqcode.algorithm.test;

import iqqcode.algorithm.link.OrderSymbolTable;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-14 10:09
 * @Description:有序符号表Debug测试
 */
public class OrderSymbolTest {
    @Test
    public void test() {
        OrderSymbolTable<Integer,String> order = new OrderSymbolTable<>();

        // 测试put
        order.put(1 , "张三");
        order.put(4 , "李四");
        order.put(6 , "赵六");
        //Debug测试查看
        order.put(5 , "王五");

    }
}
