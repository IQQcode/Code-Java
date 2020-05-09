package com.topic.joseph;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-08 18:00
 * @Description:数学方法求解
 */
public class MathSolution {
    public static int joseph(int n, int ans) {
        if(n <= 0 || ans < 2){
            return -1;
        }

        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = (temp + ans) % i;
        }
        return temp + 1;
    }
}
