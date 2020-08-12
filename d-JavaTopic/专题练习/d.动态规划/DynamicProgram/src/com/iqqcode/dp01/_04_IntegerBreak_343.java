package com.iqqcode.dp01;

import java.util.Arrays;

/**
 * @Author: iqqcode
 * @Date: 2020-08-11 14:40
 * @Description:343-整数拆分 https://leetcode-cn.com/problems/integer-break/
 */
public class _04_IntegerBreak_343 {

    /**
     * 递归
     * @param n
     * @return
     */
    static int[] memo;

    public static int integerBreak(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return rec(n);
    }

    public static int rec(int n) {
        if (n == 1)  return 1;
        //将n进行分割（至少分割两部分），可以获得的最大乘积
        if (memo[n] != -1)  return memo[n];
        int result = -1;
        for (int i = 1; i <= n - 1; i++) {
            // i + (n - i)
            result = Math.max(result, Math.max(i * (n - i), i * rec(n - i)));
        }
        memo[n] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
