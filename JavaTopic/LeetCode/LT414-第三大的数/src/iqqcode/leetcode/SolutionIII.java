package iqqcode.leetcode;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-02 21:34
 * @Description:数值交换 O(1)
 *     1. 用三个变量来存放第一大，第二大，第三大的元素的变量，分别为one, two, three；
 *     2. 遍历数组，若该元素比one大则往后顺移一个元素，比two大则往往后顺移一个元素，比three大则赋值个three；
 *     3. 最后得到第三大的元素，若没有则返回第一大的元素。
 */
public class SolutionIII {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 2, 3, 5, -2147483648};
        System.out.println(thirdMax(arr));
    }

    private static long MIN = Long.MIN_VALUE;    // MIN代表没有在值

    public static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("nums is null or length of 0");
        }
        int n = nums.length;

        int one = nums[0];
        long two = MIN;
        long three = MIN;

        for (int i = 1; i <  n; i++) {
            int now = nums[i];
            if (now == one || now == two || now == three) {
                continue;    // 如果存在过就跳过不看
            }
            if (now > one) {
                three = two;
                two = one;
                one = now;
            } else if (now > two) {
                three = two;
                two = now;
            } else if (now > three) {
                three = now;
            }
        }

        if (three == MIN) {
            return one;  // 没有第三大的元素，就返回最大值
        }
        return (int)three;
    }
}
