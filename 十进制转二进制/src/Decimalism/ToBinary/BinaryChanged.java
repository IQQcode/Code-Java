package Decimalism.ToBinary;

import  java.util.Scanner;

public class BinaryChanged {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个十进制数： ");
        int num = input.nextInt();
        int[] arr = new int[10];
        int i = 0;
        while (num != 0) {
            int temp = num % 2;
            arr[i] = temp;
            num /= 2;
            i++;
        }
        System.out.print("转换成二进制数为： ");
        for(i--; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
