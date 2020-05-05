package com.jzoffer;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-04 09:38
 * @Description:Integer.toBinaryString()，他的作用是把一个10进制数转为32位的2进制数。同时对负数，会用补码表示
 */
public class SolutionIII {
    public static int hammingWeight(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }
}
