package com.iqqcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 22:37
 * @Description: 使用Collections reverse()方法
 */
public class Method7 {
    public static String reverse(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        List< Character > list = new ArrayList< Character >();
        for (char c: str.toCharArray()) {
            list.add(c);
        }
        Collections.reverse(list);
        StringBuilder builder = new StringBuilder(list.size());
        for (Character c: list) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "ABCDE";
        System.out.println(" input :: " + str);
        System.out.println(" output :: " + reverse(str));
    }
}
