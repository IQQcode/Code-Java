package com.sad;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-06 22:59
 * @Description:第n项阶乘和 3!
 * First n-order factorial sum
 */
public class FactorialSum {

    public static int FactorialSum_fac(int num) {
        if(num == 0 || num == 1) {
            return 1;
        }else {
            return num * FactorialSum_fac(num -1);
        }
    }

    public static int FactorialSum_NOfac(int num) {
        int sum = 0;
        for(int i = 1;i <= num;i++) {
            sum *= i;
        }
        return sum;
    }

}
