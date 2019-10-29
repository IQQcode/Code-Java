package com.algorithm.quickSort;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-13 10:07
 * @Description:基础快排
 */
public class quickSort {
        public static void main(String[] args) {
            int[] arr = new int[] {6,1,2,7,9,3,4,5,10,8};
            System.out.print("数组元素为：" + Arrays.toString(arr));
            QuickSort(arr,0,arr.length - 1);
            System.out.print("\n排序结果为：" + Arrays.toString(arr));
        }

        public static void QuickSort(int[] arr,int left,int right) {
            if (left < right) {
                int temp = arr[left]; //左边界基准数
                //int temp = arr[left + (right - left) / 2]; //中轴值
                int i = left;
                int j = right;
                while (i < j) {
                    while(i < j && arr[j] > temp) {
                        // 从右向左找第一个小于x的数
                        j--;
                    }
                    if(i < j) {
                        arr[i++] = arr[j];
                    }
                    while(i < j && arr[i] < temp) {
                        // 从左向右找第一个大于x的数
                        i++;
                    }
                    if(i < j) {
                        arr[j--] = arr[i];
                    }
                }
                arr[i] = temp;
                QuickSort(arr, left, i-1);
                QuickSort(arr, i+1, right);
            }
        }
}
