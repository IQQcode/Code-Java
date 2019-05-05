package Input.Scanner;

import java.util.*;

public class INputMismatchExceptionDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;
        do {
           try {
               System.out.print("Enter an integer: ");
               int number = input.nextInt();
               System.out.println("*** The number is " + number);
               continueInput = false;
           } catch (InputMismatchException e) {
               System.out.println("Try again. (" + "Incorrent input: "
                       + "integer is required)");
               input.nextLine();  //清除键盘缓存，否则死循环
           }
        } while (continueInput);
    }
}
