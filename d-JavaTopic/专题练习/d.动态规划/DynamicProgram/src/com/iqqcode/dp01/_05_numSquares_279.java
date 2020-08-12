package com.iqqcode.dp01;

import java.util.Arrays;

/**
 * @Author: iqqcode
 * @Date: 2020-08-11 18:40
 * @Description:
 */
public class _05_numSquares_279 {
    public static int numSquares(int n) {
        int square = (int) Math.sqrt(n);
        int[] res = new int[square + 1];
        for (int i = 1; i <= square; i++) {
            res[i] = i * i;
        }

        int[] dp = new int[n + 1];
        //默认初始化为MAX_VALUE
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= square; j++) {
                if(i < res[j]) {
                    break;
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i - res[j]]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
