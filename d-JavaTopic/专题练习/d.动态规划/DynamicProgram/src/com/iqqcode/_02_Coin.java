package com.iqqcode;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-07 08:57
 * @Description:硬币问题lt-322
 */
public class _02_Coin {
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        // 注意：因为要比较的是最小值，这个不可能的值就得赋值成为一个最大值
        for (int k = 1; k <= amount; k++) {
            //为第一行赋初值
            dp[0][k] = amount + 1;
        }
        dp[0][0] = 0;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                //状态转移方程
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //由于每种硬币是无限的，所以 1 + dp[i]【此处为i】[j-coins[i-1]]
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        return (dp[coins.length][amount] == amount + 1) ? -1 : dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int account = 6249;
        System.out.println(coinChange(coins, account));
    }
}
