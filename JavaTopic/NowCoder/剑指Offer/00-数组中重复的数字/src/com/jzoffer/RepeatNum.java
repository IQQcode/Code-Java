package com.jzoffer;


import java.util.Arrays;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-01 17:49
 * @Description:
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 */
public class RepeatNum {
    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int repeat = 0;
        int i = 1;
        while (true) {
            if (nums[i] == nums[i-1]) {
                repeat = nums[i];
                break;
            }
            i++;
        }
        return repeat;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));
    }
}
