package com.iqqcode.dp01;

/**
 * @Author: iqqcode
 * @Date: 2020-08-10 12:05
 * @Description:
 */
public class _03_MinPathSum_64 {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];

        //初始化第一行
        for (int k = 1; k < row; k++) {
            dp[k][0] = dp[k - 1][0] + grid[k][0];
        }
        //初始化第一列
        for (int k = 1; k < col; k++) {
            dp[0][k] = dp[0][k - 1] + grid[0][k];
        }
        //非第一行第一列
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[row - 1][col - 1];
    }


    /**
     * 压缩为一维
     * @param grid
     * @return
     */
    public static int dp_space(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length, col = grid[0].length;

        //只要关心当前行即可，所以大小为col
        int[] dp = new int[col];

        dp[0] = grid[0][0];

        //初始化，grid的第一行，只能一直向右累加
        for (int k = 1; k < col; k++) {
            dp[k] = dp[k - 1] + grid[0][k];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    // dp[0]对应 grid的第一列，只能一直向下累加
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[col - 1];
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
        System.out.println(dp_space(grid));
    }
}
