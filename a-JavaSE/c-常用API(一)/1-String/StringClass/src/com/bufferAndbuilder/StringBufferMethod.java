package com.bufferAndbuilder;


/**
 * @Author: Mr.Q
 * @Date: 2019-11-25 21:36
 * @Description:
 */
public class StringBufferMethod {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" World!");
        sb.insert(6,"Hehe ");
        System.out.println(sb);
        System.out.println(sb.reverse());
    }
}
