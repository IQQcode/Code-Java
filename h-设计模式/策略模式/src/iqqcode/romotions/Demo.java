package iqqcode.romotions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: iqqcode
 * @Date: 2020-12-22 12:39
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        Integer[] nums = {4, 5, 1, 3, 9, 7, 5};
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // [9, 7, 5, 5, 4, 3, 1]
    }
}
