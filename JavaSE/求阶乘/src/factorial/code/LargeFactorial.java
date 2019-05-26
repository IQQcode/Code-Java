package factorial.code;
import java.math.*;
import java.util.Scanner;

public class LargeFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number: ");
        int num = input.nextShort();
        System.out.println(num + "! is : " + factorial(num));
    }

    public static BigInteger factorial(long n) {
        BigInteger result = BigInteger.ONE;
        for(int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger( i + ""));
            //将数字转换为字符串，防止溢出
        }
        return result;
    }
}
