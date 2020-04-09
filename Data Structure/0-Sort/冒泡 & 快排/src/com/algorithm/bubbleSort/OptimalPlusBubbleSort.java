package com.algorithm.bubbleSort;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-28 23:03
 * @Description:
 */
public class OptimalPlusBubbleSort {
    public static void bubbleSortPlus(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            // sortBorder之后的元素一定有序
            int sortBorder = arr.length - 1;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 把无序数列的边界更新为最后一次交换元素的位置
                    sortBorder = j;
                    // 此趟排序没有进行数值交换
                    flag = true;
                }
            }
            // 在一趟排序中没有发生过交换
            if (!flag) {
                break;
            } else {
                // 重置flag,进行下次判断
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] { 3, 4, 2, 1, 5, 6, 7, 8 };
        bubbleSortPlus(array);
        System.out.println("The Bubble Sort is : " + Arrays.toString(array));
    }
}
