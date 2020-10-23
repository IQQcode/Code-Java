package yuewen;

/**
 * @Author: iqqcode
 * @Date: 2020-10-21 18:48
 * @Description:阅文集团-1
 *
 * 4
 * 1,2,3,4
 * 5,6,7,8
 * 9,10,11,12
 * 13,14,15,16
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] ss = new String[N];
        for (int i = 0; i < N; i++) {
            ss[i] = in.next();
        }
        int[][] matrix = new int[N][N];
        String[] temp = null;
        for (int i = 0; i < N; i++) {
            temp = ss[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                matrix[i][j] = Integer.parseInt(temp[j]);
            }
        }

        rotate(matrix);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == N - 1 && j == N - 1) {
                    System.out.print(matrix[i][j]);
                } else {

                    System.out.print(matrix[i][j] + ",");
                }
            }
        }
    }

    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        for (int i = 0; i < row - 1; i++) {
            for (int j = i + 1; j < row; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int mid = row >>> 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][row - 1 - j];
                matrix[i][row - 1 - j] = temp;
            }
        }
    }
}
