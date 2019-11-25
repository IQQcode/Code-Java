package com.string;


/**
 * @Author: Mr.Q
 * @Date: 2019-11-25 07:58
 * @Description:
 */
public class ObtainMethod {
    public static void main(String[] args) {
        //length()
        String s = "Hello World";
        System.out.println(s.length());

        //charAt
        String s1 = "Hello World";
        System.out.println(s1.charAt(6));

        //indexOf
        String s2 = "Tomorrow will fine";
        System.out.println(s2.indexOf("o"));
        System.out.println(s2.indexOf("will"));
        //indexOf(int ch, int fromIndex)
        System.out.println(s2.indexOf('o',3));
        //index(lastIndexOf)
        System.out.println(s2.lastIndexOf('i'));

        //substring
        String s3 = "Every Thing will be Fine";
        System.out.println(s3.substring(6,11));
    }
}
