package iqqcode.leetcode;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-01 15:35
 * @Description:
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 */
public class MySolution {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0; int stmp = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] + 2 * stmp == sum) {
                return j;
            }
            stmp += nums[j];
        }
        return  -1;
    }
}
