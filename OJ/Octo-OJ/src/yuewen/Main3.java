package yuewen;

/**
 * @Author: iqqcode
 * @Date: 2020-10-21 18:48
 * @Description:阅文集团-3 矩阵乘法
 * [case]
 * m p n
 * <p>
 * 2,3,2
 * 1,0,-1
 * 1,1,-3
 * 0,3
 * 1,2
 * 3,1
 * <p>
 * A: m * p的矩阵
 * B: p * n的矩阵
 * <p>
 * >>>
 * -3,2
 * -8,2
 */

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String[] ss = str.split(",");
        int m = Integer.parseInt(ss[0]);
        int p = Integer.parseInt(ss[1]);
        int n = Integer.parseInt(ss[2]);

        in.nextLine();
        String[] aa = new String[m];
        for (int i = 0; i < m; i++) {
            aa[i] = in.next();
        }

        int[][] A = new int[m][p];
        String[] tempA = null;
        for (int i = 0; i < m; i++) {
            tempA = aa[i].split(",");
            for (int j = 0; j < tempA.length; j++) {
                A[i][j] = Integer.parseInt(tempA[j]);
            }
        }

        in.nextLine();
        String[] bb = new String[p];
        for (int i = 0; i < p; i++) {
            bb[i] = in.next();
        }
        int[][] B = new int[p][n];
        String[] tempB = null;
        for (int i = 0; i < p; i++) {
            tempB = bb[i].split(",");
            for (int j = 0; j < tempB.length; j++) {
                B[i][j] = Integer.parseInt(tempB[j]);
            }
        }


        int[][] res = new int[m][n];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.print(res[i][j]);
                } else {
                    System.out.print(res[i][j] + ",");
                }
            }
            System.out.println();
        }


//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < p; j++) {
//                if(i == m - 1 && j == p - 1) {
//                    System.out.print(A[i][j]);
//                } else {
//
//                    System.out.print(A[i][j] + ",");
//                }
//            }
//        }
//
//        for (int i = 0; i < p; i++) {
//            for (int j = 0; j < n; j++) {
//                if(i == p - 1 && j == n - 1) {
//                    System.out.print(B[i][j]);
//                } else {
//
//                    System.out.print(B[i][j] + ",");
//                }
//            }
//        }

    }
}
