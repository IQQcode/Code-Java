package com.array;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-19 23:25
 * @Description:二位有序数组查找
 */
public class Solution {
    public static boolean Find(int target, int [][] array) {
        for(int i = 0; i < array.length;i++) {
            int low = 0;
            int high = array[i].length-1;
            while(low <= high) {
                int mid = low + (high - low)/2;
                if(target > array[i][mid]) {
                    low = mid + 1;
                } else if(target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Find(100,arr));
    }
}
