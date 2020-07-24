package iqqcode.search;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-20 09:46
 * @Description:基础二分查找 <=
 */
public class BinarySearch_equals {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(BinarySearch_equals.binarySearch(nums, 6));
    }
}

/**
 * >>>表示不带符号向右移动二进制数，移动后前面统统补0；两个箭头表示带符号移动，
 * <p>
 * 没有<<<这种运算符，因为左移都是补零，没有正负数的区别。
 * <p>
 * 如 -12 的二进制为：1111  1111  1111  1111  1111  1111  1111  0100；
 * <p>
 * -12 >> 3 即带符号右移3位，结果是：1111  1111  1111  1111  1111  1111  1111  1110，十进制为： -2；
 * <p>
 * -12 >>> 3 就是右移三位，前面补零，为：0001  1111  1111  1111  1111  1111  1111  1110，十进制为：536870910。
 * ————————————————
 * 版权声明：本文为CSDN博主「s-_-s」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/yuqilin520/article/details/82886969
 */
