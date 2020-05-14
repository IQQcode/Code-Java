package com.BlueBridge;

import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-07 23:11
 * @Description:Fibonacci数列的递推公式为：
 *              Fn=Fn-1+Fn-2，其中F1=F2=1
 */
public class Fibonacci {
    public static int fibonacci(int Fn) {
        if(Fn == 1 || Fn == 2) {
            return 1;
        }
        return fibonacci(Fn - 1) + fibonacci(Fn - 2);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = input.nextInt();
        System.out.println(fibonacci(sum));
    }
}

