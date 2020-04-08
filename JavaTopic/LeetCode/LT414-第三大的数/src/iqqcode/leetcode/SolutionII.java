package iqqcode.leetcode;

import java.util.TreeSet;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-02 21:34
 * @Description:借用TreeSet（红黑树） O(n)
 *      Set集合为有序且无重复
 *     1. 维护一个只有3个元素的TreeSet，如果大于三个元素就就把Set中的最小最小值remove掉。
 *     2. 最后如果Set中元素小于3就返回Set最大值，否则返回最小值。
 */
public class SolutionII {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 2, 3, 5, -2147483648};
        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("error");
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        // set.last() 里面最大的元素
        return set.size() < 3 ? set.last() : set.first();
    }
}

