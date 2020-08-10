package com.iqqcode.dp;

/**
 * @Author: iqqcode
 * @Date: 2020-08-09 18:38
 * @Description:斐波那切数列
 */
public class _00_Fibonacci {
    public static int dp_solve(int n) {
        if(n <= 1)   return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp [i - 2];
        }
        return dp[n];
    }

    public static int iteration_sub(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(dp_solve(n));
        System.out.println(iteration_sub(n));
    }
}
