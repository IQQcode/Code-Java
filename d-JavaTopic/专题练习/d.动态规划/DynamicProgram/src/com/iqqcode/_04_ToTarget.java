package com.iqqcode;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-07 09:03
 * @Description:在已知数列中,元素能否凑齐目标值
 * [3, 34, 4, 12, 5, 2]
 *     target = 12 ---> true
 *     target = 13 ---> false
 */
public class _04_ToTarget {
    public static boolean rec_subSet(int[] arr, int i, int target) {
        if (target == 0) {
            // 满足元素和为target
            return true;
        } else if (i == 0) {
            // 只剩一个元素时，arr[0]恰好等于(target-subset)
            return arr[0] == target;
        } else if (arr[i] > target) {
            //arr[i] > (target-subset),不做选择的情况;  subset( {arr[3] = 12} , 9)--不选择
            return rec_subSet(arr, i - 1, target);
        } else {
            boolean yes = rec_subSet(arr, i - 1, target - arr[i]);
            boolean no = rec_subSet(arr, i - 1, target);
            //两边只要有一遍成立即可
            return yes || no;
        }
    }

    public static boolean dp_subSet(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for (int k = 1; k <= target; k++) {
            //为第一行赋初值
            dp[0][k] = false;
        }
        for (int k = 1; k <= arr.length; k++) {
            //为第一列赋初值
            dp[k][0] = true;
        }
        dp[0][0] = true;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] > j) {
                    //arr[i] > (target-subset),不做选择,继续向前的情况;
                    // subset( {arr[3] = 12} , 9)--不选择
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[arr.length][target];
    }


    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        //System.out.println(rec_subSet(arr, arr.length-1, 9));
        System.out.println(dp_subSet(arr, 13));
    }
}
