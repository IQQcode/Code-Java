package tw;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-11-04 10:20
 * @Description: 求区间内(正或负) 只能被1和自身相除的数 的和
 * [12, 18] --> 13, 17
 * [-12, -18] --> -13, -17
 * [-12, 18] -->
 */

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = in.nextInt();
        int end = in.nextInt();
        List<Integer> list = new ArrayList<>();
        int startTemp = 0;
        int endTemp = 0;

        if (start <= 0 && end > 0) {
            endTemp = Math.abs(start);
            for (int i = 0; i <= endTemp; i++) {
                if (isPrimes(i)) {
                    list.add(-i);
                }
            }
            for (int i = 0; i <= end; i++) {
                if (isPrimes(i)) {
                    list.add(i);
                }
            }
        } else if (start <= 0 && end <= 0) {
            startTemp = Math.abs(end);
            endTemp = Math.abs(start);
            for (int i = startTemp; i <= endTemp; i++) {
                if (isPrimes(i)) {
                    list.add(-i);
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                if (isPrimes(i)) {
                    list.add(i);
                }
            }
        }
        System.out.println(list);
    }

    public static boolean isPrimes(int num) {
        boolean flag = true;
        if (num == 1) {
            flag = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
