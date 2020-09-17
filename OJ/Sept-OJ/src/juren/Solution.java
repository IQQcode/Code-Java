package juren;

import java.util.*;

public class Solution {
    /**
     * 逆时针旋转矩阵
     *
     * @param matrix int整型二维数组 输入矩阵
     * @return int整型二维数组
     * [0,1,2]
     * [3,4,5]
     * [6,7,8]
     *
     *
     * [2,5,8]
     * [1,4,7]
     * [0,3,6]
     */
    public static int[][] RotateMatrix(int[][] matrix) {
        // write code here
        int[][] temp = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp[i][j] = matrix[j][matrix[0].length - 1-i];
            }
        }
        return temp;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2},
                {3,4,5},
                {6,7,8}
        };

        RotateMatrix(matrix);
    }
}

