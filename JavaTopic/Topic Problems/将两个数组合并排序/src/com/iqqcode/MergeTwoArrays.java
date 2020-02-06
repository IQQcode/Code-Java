package com.iqqcode;


import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-06 10:57
 * @Description:
 */
public class MergeTwoArrays {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        int[] num = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            num[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            num[k++] = nums2[j++];
        }
        System.out.println(Arrays.toString(num));
    }
}
