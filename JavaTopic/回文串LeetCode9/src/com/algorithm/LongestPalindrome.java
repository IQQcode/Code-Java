package com.algorithm;

import java.util.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-14 19:12
 * @Description:最长回文子串
 */
public class LongestPalindrome {
    public static String isLongestPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        int n = s.length();
        int ans = 0; int i = 0;  int j = 0;
        while(i < n && j < n) {
            if(list.contains(s.charAt(j))) {
                list.add(s.charAt(j++));
                ans = j;
                return s;
            }else {
                list.remove(s.charAt(i++));
            }
        }
        return "No";

    }

    public static void main(String[] args) {
        System.out.print("请输入字符串： ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(isLongestPalindrome(str));
    }
}
