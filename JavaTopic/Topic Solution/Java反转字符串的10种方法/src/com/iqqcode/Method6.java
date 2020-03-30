package com.iqqcode;

import java.util.Stack;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 22:31
 * @Description: 使用栈
 */
public class Method6 {
    public static String reverse(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        Stack<Character> stack = new Stack <Character> ();
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            stack.push(ch[i]);
        }
        int k = 0;
        while (!stack.isEmpty()) {
            ch[k++] = stack.pop();
        }
        return String.copyValueOf(ch);
    }

    public static void main(String[] args) {
        String str = "ABCDE";
        System.out.println(" input :: " + str);
        System.out.println(" output :: " + reverse(str));
    }
}
