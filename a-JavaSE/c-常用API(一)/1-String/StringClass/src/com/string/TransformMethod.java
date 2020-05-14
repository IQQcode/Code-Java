package com.string;


import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-25 08:15
 * @Description:
 */
public class TransformMethod {
    public static void main(String[] args) {
        //byte[] getBytes
        String s = "520 Java";
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));  //ASCII

        //char[] toCharArray
        char[] chs = s.toCharArray();
        System.out.println(Arrays.toString(chs));

        //valueOf
        char[] cha = {'L','O','V','E'};
        String s1 = String.valueOf(cha);
        System.out.println(s1);

        //toLowerCase
        //toUpperCase
        String s2 = "Hello World";
        System.out.println(s2.toLowerCase());
        System.out.println(s2.toUpperCase());
    }
}
