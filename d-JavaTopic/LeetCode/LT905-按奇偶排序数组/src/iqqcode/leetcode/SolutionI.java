package iqqcode.leetcode;


import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-31 22:11
 * @Description:双指针解法
 */
public class SolutionI {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }

    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            //首数为偶，尾数为奇
            if (A[i] % 2 > A[j] % 2) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            //调整子序列，首尾奇偶数调换，子元素奇偶个数调整
            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }
        return A;
    }
}
