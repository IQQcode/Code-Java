package com.jzoffer.fib;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-02 15:35
 * @Description:递归
 */
public class Fibonacci {
    public static int fib(int n) {
        if(n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
