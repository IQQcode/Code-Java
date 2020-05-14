package com.iqqcode;


/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 21:58
 * @Description: 使用String--charAt()
 */
public class Method3 {
    public static void main(String[] args) {
        Method3 method3 = new Method3();
        String s = "ABCDE";
        System.out.println(" input :: " + s);
        System.out.println(" output :: " + method3.reverseWithStringChatAt(s));
    }

    private String reverseWithStringChatAt(String s) {
        StringBuilder builder = new StringBuilder();
        int len = s.length() - 1;
        for (int i = len; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
