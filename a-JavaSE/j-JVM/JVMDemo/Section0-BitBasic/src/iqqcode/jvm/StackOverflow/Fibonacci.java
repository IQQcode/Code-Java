package iqqcode.jvm.StackOverflow;

import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-09-05 15:35
 * @Description:Fibonacci递归无出口
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the num: ");
        int num = input.nextInt();
        System.out.print("The result is : " +  fibonacci(num));
    }

    public static int fibonacci(int num) {
        //正常执行
        /*if(num <= 2) {
            return 1;
        }else {
            return fibonacci(num-1) + fibonacci(num-2);
        }*/

        //栈溢出
        return fibonacci(num-1) + fibonacci(num-2);
    }
}
