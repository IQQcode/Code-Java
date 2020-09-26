package sougou;

import java.util.*;

/**
 * 3,3,"ABC","ABC"
 * <p>
 * [3,3]
 */
public class Solution2 {

    public static class Interval {
        int start;
        int end;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回Interval类，start代表汪仔最少做对了多少道题，end代表汪仔最多做对了多少道题。
     *
     * @param n    int整型 选择题总数
     * @param k    int整型 朋友做对的题数
     * @param str1 string字符串 长度为n只包含ABCD的字符串，其中第i个代表汪仔第i题做出的选择
     * @param str2 string字符串 长度为n只包含ABCD的字符串，其中第i个代表朋友第i题做出的选择
     * @return Interval类
     */
    public static Interval solve(int n, int k, String str1, String str2) {
        // write code here
        Interval itv = new Interval();
        String[] s1 = str2.split("");
        String[] s2 = str2.split("");
        if(n == k) {
            itv.start = n;
            itv.end = k;
        }
        return itv;
    }

    public static void main(String[] args) {
        String str1 = "ABC";
        String str2 = "ABC";
        Interval res = solve(3, 3, str1, str2);
        System.out.println(res.start);
        System.out.println(res.end);
    }
}
