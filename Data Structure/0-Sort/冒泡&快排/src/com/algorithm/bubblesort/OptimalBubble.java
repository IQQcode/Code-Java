package com.algorithm.bubblesort;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-13 10:24
 * @Description:优化的冒泡排序,增加标志位,如果有序则不交换
 */
public class OptimalBubble {
    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr [j] > arr [j + 1]) {
                    int temp = arr [j];
                    arr [j] = arr [j+1];
                    arr [j+1] = temp;
                    //此趟排序没有进行数值交换
                    flag = true;
                }
            }
            //在一趟排序中没有发生过交换
            if(!flag) {
                break;
            }else {
                //重置flag,进行下次判断
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int [] {5, 8, 6, 3, 9, 2, 1, 7};
        bubbleSort(array);
        System.out.println("The Bubble Sort is : " + Arrays.toString(array));
    }
}
