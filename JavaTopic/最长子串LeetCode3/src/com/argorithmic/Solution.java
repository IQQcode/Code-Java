package com.argorithmic;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-01 21:57
 * @Description:leetcode No.3
 *
 * 使用i从0到n−1,以及j从i+1到n这两个嵌套的循环,枚举出s的所有子字符串
 * 放入Set(不允许重复)
 *
 * @Time O(n^3)
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0;i < n;i++) {
            for(int j = i + 1;j < n;j++) {
                if(strUnique(s,i,j)) {
                    ans = Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }

    public static boolean strUnique(String s,int start,int end) {
        Set<Character> set = new HashSet<>();
        for (int k = start; k < end; k++) {
            Character ch = s.charAt(k);
            if(set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "pwwekw";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
