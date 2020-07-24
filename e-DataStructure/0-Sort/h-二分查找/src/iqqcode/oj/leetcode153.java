package iqqcode.oj;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-20 15:04
 * @Description:
 */
public class leetcode153 {
    public static int findMin(int[] nums) {
        if (nums.length == 0 || nums == null) return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        //int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
        System.out.println(findMin(nums));
    }
}
