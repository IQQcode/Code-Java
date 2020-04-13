package iqqocde.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 21:58
 * @Description:希尔排序
 */
public class ShellSort {
    public static void shellSort(Integer[] arr) {
        //根据数组长度，确定增长量ans
        int ans = 1;
        while (ans < arr.length/2) {
            ans = 2 * ans + 1;
        }
        while (ans >= 1) {
            //找到待插入的元素
            for (int i = ans; i < arr.length; i++) {
                //待插入的元素插入到分组的有序序列中
                for (int j = i; j >= ans; j-=ans) {
                    //待插入的元素时arr[j],比较arr[j-ans]
                    if(arr[j] < arr[j-ans]) {
                        int temp = arr[j];
                        arr[j] = arr[j-ans];
                        arr[j-ans] = temp;
                    }else {
                        //待插入元素在分组中已有序
                        break;
                    }
                }
            }
            //减小ans的值
            ans = ans / 2;
        }
    }
}