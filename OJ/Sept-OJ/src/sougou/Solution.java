package sougou;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     *
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     * <p>
     * ["1101","1010","1111","1110"],
     * ["ABCD","EFGH","IJKL","MNPQ"]
     * <p>
     * <p>
     * "CFHQGLMPAIKNBDEJ"
     */
    public static String rotatePassword(String[] s1, String[] s2) {
        // write code here
        int[][] check = new int[s1.length][s1[0].length()];
        String temp = null;
        for (int i = 0; i < s1.length; i++) {
            temp = s1[i];
            for (int j = 0; j < s1[i].length(); j++) {
                check[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }

        String[][] pass = new String[s2.length][s2[0].length()];
        String ans = null;
        for (int i = 0; i < s2.length; i++) {
            ans = s2[i];
            for (int j = 0; j < s2[i].length(); j++) {
                pass[i][j] = ans.substring(j, j + 1);
            }
        }

//        for (int i = 0; i < pass.length; i++) {
//            for (int j = 0; j < pass[0].length; j++) {
//                System.out.print(pass[i][j] + " ");
//            }
//            System.out.println();
//        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < check.length; i++) {
                for (int j = 0; j < check[i].length; j++) {
                    if(check[i][j] == 0) {
                        sb.append(pass[i][j]);
                    }
                }
            }
            rotate(check);
        }
        return sb.toString();
    }


    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //对左上-右下对角线翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //一中轴对称线翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        rotate(arr);
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        String[] s1 = {"1101","1010","1111","1110"};
        String[] s2 = {"ABCD","EFGH","IJKL","MNPQ"};
        System.out.println(rotatePassword(s1, s2));
    }
}
