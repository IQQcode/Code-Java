package com.jzoffer;

import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-04 08:08
 * @Description:测试类
 */
public class DFSTest {
    @Test
    public void test() {
        char[][] boards = {{'a','b','c','e'},
                             {'s','f','c','s'},
                             {'a','d','e','e'}};
        String word = "bfce";
        System.out.println(Solution.exist(boards, word));
    }

    @Test
    public void test1() {
        char[][] boards = {{'a','b'},
                           {'c','d'}};
        String word = "abcd";
        System.out.println(Solution.exist(boards, word));
    }
}
