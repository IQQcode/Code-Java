package iqqcode.search;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-22 10:10
 * @Description:减治思想
 */
public class Reduce_right {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        //因为要搜索左右侧边界，所以索引最大位置必须大于数组长度，搜索的区间为[left, right)
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                left = mid + 1;
            } else if (target > nums[mid]) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left, mid)
                right = mid;
            }
        }
        return nums[left-1] == target ? left-1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 5};
        System.out.println(binarySearch(nums, 5));
    }
}
