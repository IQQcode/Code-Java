package iqqcode.leetcode;


import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-31 22:11
 * @Description:双指针解法
 */
public class SolutionII {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }

    public static int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int t = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0)
                B[t++] = A[i];
        }
        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 1)
                B[t++] = A[i];
        }
        return B;
    }
}
