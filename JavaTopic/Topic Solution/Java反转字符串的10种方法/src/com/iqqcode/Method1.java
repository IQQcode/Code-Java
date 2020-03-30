package com.iqqcode;


/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 21:37
 * @Description: 使用 + (String连接) 操作符
 * @Link: https://www.jb51.net/article/162542.htm
 */
public class Method1 {
    public static void main(String[] args) {
        Method1 concat = new Method1();
        String str = "ABCDE";
        System.out.println(" input :: " + str);
        System.out.println(" output :: " + concat.reverseWithStringConcat(str));
    }

    private String reverseWithStringConcat(String s) {
        String msg = "";
        int len = s.length() - 1;
        //反向遍历字符串重新赋值给新字符串
        for (int i = len; i >= 0; i--) {
            msg += (s.charAt(i));
        }
        return msg;
    }
}
