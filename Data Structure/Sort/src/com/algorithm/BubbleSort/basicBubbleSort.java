package com.algorithm.BubbleSort;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-13 09:25
 * @Description:基础冒泡排序
 */
public class basicBubbleSort {
    /**
     * 自上往下冒泡
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr [j] > arr [j + 1]) {
                    int temp = arr [j];
                    arr [j] = arr [j+1];
                    arr [j+1] = temp;
                }
            }
        }
    }

    /**
     * 自下往上冒泡
     * @param arr
     */
    public static void bubbleSort_A(int[] arr) {
        for(int i = arr.length - 1 ; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr [j] > arr [j + 1]) {
                    int temp = arr [j];
                    arr [j] = arr [j+1];
                    arr [j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int [] {0, 20, 1, 80, 3, 2};
        bubbleSort(array);
        System.out.println("The Bubble Sort is : " + Arrays.toString(array));
    }
}
