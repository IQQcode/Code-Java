package com.jzoffer;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-04 09:38
 * @Description:(num&1)就是这个数最低位的二进制，然后把n右移一位可以求出倒数第二位的二进制，不断进行循环，直到求出n的最高位的二进制
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 */
public class SolutionI {
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
