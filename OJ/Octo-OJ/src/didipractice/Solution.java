package didipractice;

/**
 * @Author: iqqcode
 * @Date: 2020-10-16 17:17
 * @Description:滴滴实习
 */

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(random(20, 4));
    }

    public static int random(int m, int n) {
        int k = new Random().nextInt();
        int max = n - 1;
        while (k < m) {
            k = k * n + new Random().nextInt();
            max = max * n + n - 1;
        }
        return k / (max / n);
    }
}