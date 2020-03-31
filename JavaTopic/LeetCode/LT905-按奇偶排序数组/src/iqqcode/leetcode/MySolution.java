package iqqcode.leetcode;


import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-31 19:56
 * @Description:只能算出偶数个数，我也不知道怎么肥四
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 */
public class MySolution {
    public static void main(String[] args) {
        int[] A = new int[] {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }

    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < A.length / 2) {
            if (A[i] % 2 != 0 ) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;  j--;
            }else {
                break;
            }
        }
        return A;
    }
}
