package xunlei;

/**
 * @Author: iqqcode
 * @Date: 2020-10-19 18:52
 * @Description:迅雷笔试-2 杨氏矩阵元素由小到大有序输出
 * [case]:
 * 4 3 // 4行3列
 * 1 2 3
 * 2 3 4
 * 4 5 6
 * 6 7 8
 */

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        youngExtract(arr);
    }

    public static void youngExtract(int[][] arr) {
        int min = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                min = arr[0][0];
                if (min != Integer.MAX_VALUE) {
                    System.out.println(min);
                }
                arr[0][0] = arr[i][j];
                arr[i][j] = Integer.MAX_VALUE;
                youngHeapify(arr, 0, 0);
            }
        }
    }


    public static void youngHeapify(int[][] arr, int row, int col) {
        int N = arr.length;
        int M = arr[0].length;
        int min_i = row;
        int min_j = col;
        if (min_j < M - 1 && arr[row][col + 1] != Integer.MAX_VALUE && arr[min_i][min_j] > arr[row][col + 1]) {
            min_i = row;
            min_j = col + 1;
        }

        if (min_i < N - 1 && arr[row + 1][col] != Integer.MAX_VALUE && arr[min_i][min_j] > arr[row + 1][col]) {
            min_i = row + 1;
            min_j = col;
        }

        if (min_i != row || min_j != col) {
            int tmp = arr[min_i][min_j];
            arr[min_i][min_j] = arr[row][col];
            arr[row][col] = tmp;
            youngHeapify(arr, min_i, min_j);
        }
    }
}


