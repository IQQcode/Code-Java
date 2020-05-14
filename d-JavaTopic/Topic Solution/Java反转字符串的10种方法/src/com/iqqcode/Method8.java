package com.iqqcode;


/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 22:39
 * @Description: 使用Byte数组
 */
public class Method8 {
    public static String reverse(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        byte[] bytes = str.getBytes();
        //字节数组双指针
        for (int l = 0, h = str.length() - 1; l < h; l++, h--) {
            byte temp = bytes[l];
            bytes[l] = bytes[h];
            bytes[h] = temp;
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
        String str = "ABCDE";
        System.out.println(" input :: " + str);
        System.out.println(" output :: " + reverse(str));
    }
}
