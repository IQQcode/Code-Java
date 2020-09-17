package meituan;

import java.util.Scanner;

/**
 * @Author: iqqcode
 * @Date: 2020-09-13 11:39
 * @Description:
 */
public class Test {
    public static int buy(int n, int m, int k, int[] arr) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
//            int low = i, high = i + m - 1;
//            while(low < high) {
//                if(arr[low] < k) {
//                    flag = true;
//                    break;
//                }
//            }
            for (int j = i; j < i + m - 1; j++) {
                if (arr[j] < k) {
                    flag = true;
                    break;
                }
            }
            if(!flag)  count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(buy(n, m, k, arr));
    }
}
