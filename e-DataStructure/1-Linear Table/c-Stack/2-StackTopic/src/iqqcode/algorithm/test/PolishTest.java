package iqqcode.algorithm.test;

import iqqcode.algorithm.expression.PolishExpression;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-10 10:18
 * @Description:逆波兰表达式测试
 */
public class PolishTest {
    @Test
    public void testPolish() {
        // 3 * (8 - 6) + 18 / 3 = 12
        String[] str = {"3","8","6","-","*","18","3","/","+"};
        System.out.println("逆波兰表达式结果为： " + PolishExpression.polish(str));
    }
}
