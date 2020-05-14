package com.jzoffer.jump;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-02 19:05
 * @Description:递归求解
 */
public class FrogJump_recursive {
    public int numWays(int n) {
        int[] res = new int[n + 1];
        if(n >= 0)
            res[0] = 1;
        if(n >= 1)
            res[1] = 1;
        for(int i = 2;i <= n;i++){
            res[i] += (res[i - 1] + res[i - 2]) % 1000000007;
        }
        return res[n];
    }
}
