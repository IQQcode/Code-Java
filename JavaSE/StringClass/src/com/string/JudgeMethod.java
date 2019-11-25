package com.string;


/**
 * @Author: Mr.Q
 * @Date: 2019-11-23 16:29
 * @Description:
 */
public class JudgeMethod {
    public static void main(String[] args) {

        //contains
        String str = "I Love you";
        System.out.println(str.contains("y"));
        System.out.println(str.contains("Love"));

        //startsWith
        //endsWith
        String str1 = "Lucky";
        System.out.println(str1.startsWith("L"));
        System.out.println(str1.startsWith("u"));
        System.out.println(str1.endsWith("y"));

        //isEmpty
        String str2 = "";
        System.out.println(str2.isEmpty());
    }
}
