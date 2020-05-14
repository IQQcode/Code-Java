package iqqcode.leetcode;


import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-31 22:11
 * @Description:双指针解法
 */
public class MySolution {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }

    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 != 0 && A[j] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 != 0) j--;
        }
        return A;
    }
}
