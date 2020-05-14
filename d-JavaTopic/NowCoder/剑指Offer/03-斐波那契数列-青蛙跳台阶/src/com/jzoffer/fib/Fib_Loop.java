package com.jzoffer.fib;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-02 15:42
 * @Description:循环
 */
public class Fib_Loop {
    public static int fib(int n) {
        if(n == 0) {
            return 0;
        }

        int sum = 0;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            int fab1 = 1;
            int fab2 = 1;
            for (int i = 3; i <= n; i++) {
                sum = fab1 + fab2;
                fab1 = fab2;
                fab2 = sum;
            }
        }
        return sum;
    }
}
