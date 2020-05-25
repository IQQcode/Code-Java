package com.argorithmic;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-09 16:12
 * @Description:
 */
public class Solution2 {
    public static int LongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0; int i = 0;  int j = 0;
        while(i < n && j < n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "pwwekw";
        System.out.println(LongestSubstring(str));
    }
}
