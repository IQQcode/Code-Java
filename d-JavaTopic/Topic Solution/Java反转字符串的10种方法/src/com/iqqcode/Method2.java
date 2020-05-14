package com.iqqcode;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 21:53
 * @Description: 使用StringBuilder
 */
public class Method2 {
    public static void main(String[] args) {
        Method2 method2 = new Method2();
        String s = "ABCDE";
        System.out.println(" input :: " + s);
        System.out.println(" output :: " + method2.reverseWithStringBuilderMethod(s));
    }
    public String reverseWithStringBuilderMethod(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }
}
