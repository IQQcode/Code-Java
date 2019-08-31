package com.iterator;


import java.util.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-31 10:15
 * @Description:
 */
public class Test_Enumeration {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Today");
        vector.add("is");
        vector.add("My");
        vector.add("21th");
        vector.add("Birthday...");
        Enumeration<String> enumeration = vector.elements();
        //迭代输出
        while(enumeration.hasMoreElements()) {
            String str = enumeration.nextElement();
            System.out.print(str + " ");
        }

    }
}
