package com.topic.test;

import com.topic.pointer.JosephRing;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-07 08:21
 * @Description:测试约瑟夫环
 */
public class TestJosephRing {
    @Test
    public void testJoseph() {
        int num = JosephRing.joseph(41, 3);
        System.out.println("\n最后幸存人的编号为： " + num);
    }
}
