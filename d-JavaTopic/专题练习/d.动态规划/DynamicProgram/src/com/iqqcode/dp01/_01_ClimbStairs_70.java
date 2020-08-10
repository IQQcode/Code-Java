package com.iqqcode.dp01;

import java.util.Arrays;

/**
 * @Author: iqqcode
 * @Date: 2020-08-09 19:29
 * @Description:70-爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class _01_ClimbStairs_70 {
    /**
     * 递归 + 记忆化
     * @param n
     * @return
     */
    static int[] memo;

    public static int climbStairs(int n) {
        // 0 ~ n 共有 n+1 个数
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climb(n);
    }

    private static int climb(int n) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] == -1)
            memo[n] = climb(n - 1) + climb(n - 2);
        return memo[n];
    }

    /**
     * DP
     * @param n
     * @return
     */
    public static int dp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;  dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int steps = 45;
        System.out.println(dp(steps));
        System.out.println(climbStairs(steps));
    }
}
