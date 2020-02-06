package com.iqqcode;


import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-06 11:24
 * @Description:Link:https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
 */

class Leetcode88_1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}

