package com.jzoffer.test;

import com.jzoffer.fib.Fib_Loop;
import com.jzoffer.fib.Fibonacci;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-02 15:37
 * @Description:
 */
public class FibTest {
    @Test
    public void testRecursive() {
        System.out.println(Fibonacci.fib(45));
    }

    @Test
    public void testLopp() {
        System.out.println(Fib_Loop.fib(45));
    }
}
