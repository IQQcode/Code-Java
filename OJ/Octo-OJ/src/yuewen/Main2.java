package yuewen;

/**
 * @Author: iqqcode
 * @Date: 2020-10-21 18:48
 * @Description:阅文集团-2
 */

import java.util.*;

public class Main2 {
    /**
     *
     * @param str string字符串
     * @return int整型
     */
    public static int palindromeCount (String str) {
        // write code here
        int n = str.length();
        int res = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2, right = i / 2 + i % 2;
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
