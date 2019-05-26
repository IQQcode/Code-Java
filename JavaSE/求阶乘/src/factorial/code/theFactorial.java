package factorial.code;

import java.util.Scanner;

public class theFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number: ");
        int num = input.nextInt();
        int temp = 1; int sum = 0;
        for(int i = 1; i <= num; i++) {
            temp *= i;
        }
        System.out.println("The " + num + "! is : " + temp);
    }
}