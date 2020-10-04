package juren;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-09-25 21:34
 * @Description:[巨人网络]
 * 两个字符串的最长公共子串
 */
public class Main {
    public static void main(String[] args) {
        //"abccade","dgcadde"
        String s1 = "abccade";
        String s2 = "dgcadde";  //cadf
        System.out.println(GetCommon(s1, s2));
    }

    /**
     * 找出字符串中最大公共子字符串
     *
     * @param str1 string字符串 输入字符串1
     * @param str2 string字符串 输入字符串2
     * @return string字符串
     */
    public static String GetCommon(String str1, String str2) {
        if (str1 == null || str2 == null) return null;
        if (str1.length() == 0 || str2.length() == 0) return null;

        String max = null, min = null;
        if (str1.length() > str2.length()) {
            max = str1;
            min = str2;
        } else {
            max = str2;
            min = str1;
        }
        String temp = "";
        /**
         * 依次找到较短子串。 n-1, n-2, n-3
         * 看教长串中是否包含
         */
        for (int i = 0; i < min.length(); i++) {
            for (int begin = 0, end = min.length() - i; end <= min.length(); begin++, end++) {
                temp = min.substring(begin, end);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }

        return null;
    }

    /**
     * [解法二]：
     *  1. 分别以str1为行， str2为列构建二维矩阵
     *  2. 比较每个点对应的衡中坐标是否相同
     *  3. //找值为1的最长对角线
     */
}
