package iqqocde.leetcode;


import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-02 15:00
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[] {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9
                ,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6,7,2,8,5,0,9,1,2,9,5,
                3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,
                65,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,
                1,1,1,7,45,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,
                9,4,7,0,1,1,1,7,45,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,
                7,4,7,4,9,4,7,0,0,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
