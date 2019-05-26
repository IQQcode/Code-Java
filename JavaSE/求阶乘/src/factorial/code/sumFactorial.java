package factorial.code;

import java.util.Scanner;

public class sumFactorial {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number: ");
        int num = input.nextInt();
        int temp = 1; int sum = 0;
        for(int i = 1; i <= num; i++) {
            temp *= i;
            sum += temp;
        }
        System.out.print("The result is : " );
        for(int i = 1; i <= num; i++) {
            System.out.print(i + "! ");
        }
        System.out.println("result is " + sum) ;
    }
}
