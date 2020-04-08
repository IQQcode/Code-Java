package iqqcode.leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-02 17:43
 * @Description:给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数
 * @Tag 题目要求是O(n)，所有sort(复杂度O(nlgn))、优先队列(复杂度O(nlg3))的算法都是不正确的
 * 要求算法时间复杂度必须是O(n)
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 *
 * @Error: 逻辑没有问题。天长数组的测试用例，不通过，我哭了
 */
public class MySolution {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 2, 3, 5, -2147483648};
        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] nums) {
        //去重,且有序
        //实例化一个set集合
        Set set = new HashSet();
        //遍历数组并存入集合,如果元素已存在则不会重复存入
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //返回Set集合的数组形式
        Object[] arr = set.toArray();
        System.out.println(Arrays.toString(arr));
        //通过循环来找数
        int temp = 0;
        if(arr.length > 2) {
            return (int) arr[arr.length - 3];
        }else {
            return (int) arr[arr.length -1];
        }
    }
}
