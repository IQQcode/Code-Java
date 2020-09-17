package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 8 3
     * 1 0 1
     * 0 1 0
     * 0 1 0
     * 1 0 1
     * 1 0 1
     * 0 1 0
     * 0 1 0
     * 1 0 1
     * @param arr
     */

    public static void start(int[][] arr) {
        int index = 0, count = 0;
        int i = 0, j = arr.length - 1;
        while(i < j) {
            if(Arrays.equals(arr[i],arr[j])) {
                i++;
                j--;
                count++;
            }
        }
        index = arr.length / count;
        for (int k = 0; k < index; k++) {
            for (int l = 0; l < arr[0].length; l++) {
                System.out.print(arr[k][l] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        start(arr);
    }
}
