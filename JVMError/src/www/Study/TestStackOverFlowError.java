package www.Study;
import  java.util.Scanner;

/**
 * 递归无出口 StackOverFlowError
 *
 * JVM参数 -Xss108k
 */

/*

public class TestStackOverFlowError {
    private int stackLength = 1;
    public void stackdemo() {
        stackLength++;
        stackdemo();
    }
    public static void main(String[] args) {
        TestStackOverFlowError test = new TestStackOverFlowError();
        try {
            test.stackdemo();
        }catch(Throwable e) {
            System.out.println("Stack Length: "+test.stackLength);
            throw e;
        }
    }
}
*/


/**
 * Fibonacci 栈溢出
 *
 * 递归无出口
 */

public class TestStackOverFlowError {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the num: ");
        int num = input.nextInt();
        System.out.print("The result is : " +  Fibonacci(num));
    }

    public static int Fibonacci(int num) {
        /*if(num <= 2) {
            return 1;
        }else {
            return Fibonacci(num-1) + Fibonacci(num-2);
        }*/

        //栈溢出
        return Fibonacci(num-1) + Fibonacci(num-2);
    }
}

