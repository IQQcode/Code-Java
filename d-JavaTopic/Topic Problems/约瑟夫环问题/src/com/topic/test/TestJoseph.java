package com.topic.test;

import com.topic.joseph.ArraySolution;
import com.topic.joseph.CircularList;
import com.topic.joseph.LinkedListSolution;
import com.topic.joseph.MathSolution;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-08 15:35
 * @Description:
 */
public class TestJoseph {
    @Test
    public void testCircleList() {
        int num = CircularList.joseph(41, 3);
        System.out.println("\n最后幸存的编号为: " + num);
    }

    @Test
    public void testLinkedList() {
        int num = LinkedListSolution.joseph(41, 3);
        System.out.println("\n最后幸存的编号为: " + num);
    }

    @Test
    public void testArray() {
        int n = 41;
        int ans = 3;
        int winner = ArraySolution.joseph(n, ans);
        System.out.println(n + "个人围成一圈数数，数到" + ans + "的被淘汰，最后剩下的是第" + winner + "个人");
    }

    @Test
    public void testMath() {
        int num = MathSolution.joseph(41, 3);
        System.out.println("最后幸存的编号为: " + num);
    }
}
