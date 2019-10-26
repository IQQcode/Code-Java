package com.algorithm.BubbleSort;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-13 10:24
 * @Description:优化的冒泡排序,如果有序则不交换
 */
public class optimalBubble {
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr [j] > arr [j + 1]) {
                    int temp = arr [j];
                    arr [j] = arr [j+1];
                    arr [j+1] = temp;
                    //此趟排序没有进行数值交换
                    flag = true;
                }
                //在一趟排序中没有发生过交换
                if(!flag) {
                    break;
                }else {
                    flag = false;  //重置flag,进行下次判断
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int [] {1, 2, 3, 4, 5, 6, 7, 8};
        bubbleSort(array);
        System.out.println("The Bubble Sort is : " + Arrays.toString(array));
    }
}
