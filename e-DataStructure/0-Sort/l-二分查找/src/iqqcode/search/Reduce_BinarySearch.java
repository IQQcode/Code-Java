package iqqcode.search;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-22 10:10
 * @Description:减治思想
 */
public class Reduce_BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 选择中位数时下取整
            int mid = (left + right) >>> 1;
            // check(mid)
            if(target > nums[mid]) {
                // 下一轮搜索区间是 [mid + 1, right]
                left  = mid + 1;
            } else {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        // 退出循环的时候，程序只剩下一个元素没有看到 (left = right指向的元素)
        // 视情况，是否需要单独判断 left（或者 right）这个下标的元素是否符合题意
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(nums, 9));
    }
}
