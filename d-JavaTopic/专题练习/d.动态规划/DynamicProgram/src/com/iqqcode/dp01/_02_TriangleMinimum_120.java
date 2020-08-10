package com.iqqcode.dp01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: iqqcode
 * @Date: 2020-08-09 21:16
 * @Description:120-三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 */
public class _02_TriangleMinimum_120 {
    /**
     * [
        [2],
        [3,4],
        [6,5,7],
        [4,1,8,3]
       ]
     相邻结点：与(i, j) 点相邻的结点为 (i + 1, j) 和 (i + 1, j + 1)
          f(i, j) = min(f(i + 1, j), f(i + 1, j + 1)) + triangle[i][j]
     */


    /**
     * 递归 + 记忆化
     * @param triangle
     * @return
     */
    static int[][] memo;

    public static int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j) {
        //递归出口为当triangle中只有一个元素时，triangle.size() == i
        if(triangle.size() == i)
            return 0;

        if(memo[i][j] != 0)
            return memo[i][j];

        return memo[i][j] = Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j);
    }


    /**
     * DP
     * @param triangle
     * @return
     */
    public static int dp(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        //倒数第二行，倒数第二列
        for(int i = n - 1; i >= 0; i--) {
            for(int j = triangle.get(i).size() - 1; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


    /**
     * 空间压缩
     * @param triangle
     * @return
     */
    public static int dp_cps(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];
        //倒数第二行，倒数第二列
        for(int k = n - 1; k >= 0; k--) {
            for(int i = 0; i < triangle.get(k).size(); i++) {
                dp[i] = Math.min(dp[i], dp[i+1]) + triangle.get(k).get(i);
            }
        }
        return dp[0];
    }



    public static void main(String[] args) {
        //[[-1],[2,3],[1,-1,-3]]
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, -1);
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 2,3);
        List<Integer> list3 = new ArrayList<>();
        Collections.addAll(list3, 1,-1,3);
        List<Integer> list4 = new ArrayList<>();
        Collections.addAll(list4, 4,1,8,3);

        List<List<Integer>> triangles = new ArrayList<> ();
        Collections.addAll(triangles, list1, list2, list3);
        System.out.println(minimumTotal(triangles));
        System.out.println(dp(triangles));
        System.out.println(dp_cps(triangles));
    }
}