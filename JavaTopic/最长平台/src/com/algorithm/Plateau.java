package com.algorithm;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-31 22:59
 * @Description:
 */
public class Plateau {
    public static int longest_plateau(int x[], int n) {
        int  length = 1;
        for (int i = 1; i < n; i++) {
            if (x[i] == x[i-length]) {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 3, 3, 4, 3, 3};
        int length = arr.length;
        longest_plateau(arr, length);
        for(int i = 0; i < length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(longest_plateau(arr,length));
    }
}
