package com.jzoffer;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-04 09:38
 * @Description:
 */
public class SolutionII {
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
