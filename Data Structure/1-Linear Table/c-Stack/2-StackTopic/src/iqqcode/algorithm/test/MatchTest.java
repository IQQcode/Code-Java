package iqqcode.algorithm.test;

import iqqcode.algorithm.match.BracketMatch;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-10 08:50
 * @Description:括号匹配测试
 */
public class MatchTest {
    @Test
    public void testMatch() {
        String str = "(abc(f())ws)";
        System.out.println("当前字符串中括号是否匹配： " + BracketMatch.isMatch(str));
    }
}
