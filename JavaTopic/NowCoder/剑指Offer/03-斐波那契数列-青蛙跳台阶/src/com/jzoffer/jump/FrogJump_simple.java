package com.jzoffer.jump;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-02 19:03
 * @Description:动态规划求解
 */
public class FrogJump_simple {
    public int numWays(int n) {

         int a = 1,b = 1,sum;
         for(int i = 0;i < n;i++){
             sum = (a + b) % 1000000007;
             a = b;
             b = sum;
         }
         return a;
    }
}
