package com.iqqcode.dp;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-06 10:20
 * @Description:0-1背包问题
 * 每类物品最多装一次
 */
public class _01_BackPackage {
    public static int backPack(int V, int N, int[] weight, int[] value) {
        //一个容量为V的背包, N件物品
        int[][] dp = new int[N + 1][V + 1];

        // 注意：因为要比较的是最大值，这个不可能的值就得赋值成为一个最小值，即数组默认值即可
        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                //由于value，weight定义的是原数组长度，而dp定义的是原数组长度+1
                //所以访问value，weight时index-1才能保证对应起来
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - weight[i-1]] + value[i - 1]);
                }
            }
        }
        int maxValue = dp[N][V];
        return maxValue;
    }

    public static void main(String[] args) {
        int capacity = 8;
        //物品编号 1 2 3 4
        int[] weight = {2, 3, 4, 5};
        int[] value =  {3, 4, 5, 8};
        //weight.length == value.length
        System.out.println(backPack(capacity, weight.length, weight, value));
    }
}
