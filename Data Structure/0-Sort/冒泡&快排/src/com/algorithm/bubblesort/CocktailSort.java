package com.algorithm.bubblesort;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-28 23:34
 * @Description:鸡尾酒排序---钟摆冒泡
 * 适合于大部分有序的数列
 */
public class CocktailSort {
    public static void cocktailSort(int[] arr) {
        boolean flag = false;
        for(int i = 0; i < arr.length / 2; i++) {
            //奇数轮,从左向右比较交换
            for(int j = 0; j < arr.length - 1; j++) {
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

            //偶数轮,从右向左比较交换
            for(int j = arr.length - 1; j > i;j--) {
                if(arr [j] < arr [j - 1]) {
                    int temp = arr [j];
                    arr [j] = arr [j-1];
                    arr [j-1] = temp;
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
        int[] array = new int [] {2, 3, 4, 5, 6, 7, 8, 1};
        cocktailSort(array);
        System.out.println("The Bubble Sort is : " + Arrays.toString(array));
    }
}
