package com.jzoffer;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-02 09:14
 * @Description:二分查找
 */
public class BinarySearch {
    /**
     * @param arr 在数组中查找
     * @param key 要查找的数
     * @return 待查找元素索引
     */
    public static int binarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low <= high) {
            mid = low + ((high-low) >> 1);
            if(key == arr[mid]) {
                return mid;
            } else if(key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        //要查找的元素
        int key = 7;
        //第一个元素的下标
        int left = 0;
        //最后一个元素的下标
        int right = (arr.length - 1);
        //获取指定元素的下标
        int index = binarySearch(arr, key);
        if (index == -1) {
            System.out.println("不含有该元素"+ key);
        } else {
            System.out.println("含有该元素"+ key + "，下标为："+index);
        }
    }
}
