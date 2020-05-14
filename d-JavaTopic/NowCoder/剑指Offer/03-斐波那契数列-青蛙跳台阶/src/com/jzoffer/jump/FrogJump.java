package com.jzoffer.jump;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-02 19:01
 * @Description:青蛙跳台阶
 */
public class FrogJump {
    public int numWays(int n) {
        int sum = 0;
        if(n <= 1) {
            return 1;
        }else if(n == 2) {
            return 2;
        }else {
            int fab1 = 1;
            int fab2 = 2;
            for(int i = 3; i <= n; i++) {
                sum = fab1 + fab2;
                fab1 = fab2 % 1000000007;
                fab2 = sum % 1000000007;
            }
        }
        return sum % 1000000007;
    }
}
