package com.iqqcode;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-07 09:00
 * @Description:不相邻的数相加求得和最大
 * [1, 2, 4, 1, 7, 8, 3] 取{1, 4, 7, 3}时和最大
 */
public class _03_ToSum {
    //递归
    public static int dp_rec(int[] arr, int from, int to) {
        if (to - from == 0) {
            return arr[0];
        } else if (to - from == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            int yes = dp_rec(arr, from, to - 2) + arr[to];
            int no = dp_rec(arr, from, to - 1);
            return Math.max(yes, no);
        }
    }

    //迭代
    public static int dp(int[] arr, int from, int to) {
        //备忘录数组
        int[] memo = new int[arr.length];
        memo[0] = arr[0];
        memo[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int yes = memo[i - 2] + arr[i];
            int no = memo[i - 1];
            memo[i] = Math.max(yes, no);
        }
        return memo[arr.length - 1];
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        int from = 0, to = 0;
        System.out.println(dp(arr, 0, 6));
    }
}
