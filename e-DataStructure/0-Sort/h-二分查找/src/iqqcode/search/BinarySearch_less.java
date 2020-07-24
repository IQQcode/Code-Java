package iqqcode.search;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-20 09:46
 * @Description:基础二分查找 <
 */
public class BinarySearch_less {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(BinarySearch_less.binarySearch(nums, 6));
    }
}