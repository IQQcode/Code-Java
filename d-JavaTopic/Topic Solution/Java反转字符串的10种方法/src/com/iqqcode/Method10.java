package com.iqqcode;


/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 22:43
 * @Description: 使用递归
 */
public class Method10 {
    static int i = 0;
    private static void reverse(char[] str, int k) {
        if (k == str.length) {
            return;
        }
        reverse(str, k + 1);
        if (i <= k) {
            char temp = str[k];
            str[k] = str[i];
            str[i++] = temp;
        }
    }

    public static String reverse(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        char[] A = str.toCharArray();
        reverse(A, 0);
        return String.copyValueOf(A);
    }

    public static void main(String[] args) {
        String str = "ABCDE";
        System.out.println(" input :: " + str);
        System.out.println(" output :: " + reverse(str));
    }
}
