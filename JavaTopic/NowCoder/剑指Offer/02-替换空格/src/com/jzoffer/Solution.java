package com.jzoffer;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-02 15:19
 * @Description:
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Solution {
    public static String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
