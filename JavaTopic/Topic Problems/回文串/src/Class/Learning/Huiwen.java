package Class.Learning;

import java.util.Scanner;

/**
 * 利用StringBuilder中的 rever()字符串反转来判断是否为回文串
 */

public class Huiwen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串： ");
        String str = input.nextLine();
        System.out.println("该字符串是回文串吗？  ---"+ isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        String str1 = filter(str);
        //此处不能是StringBuilder类型，StringBuilder被赋值后将自己修改
        //String并没有修改
        String str2 = reverse(str1);
        return str2.equals(str1);
    }

    public static String filter(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        //一般情况进行字符串拼接用+就可以，系统内部会进行优化
        // 但是如果是循环拼接，则需要用StringBuilder的append来实现

        for(int i =0; i < str.length(); i++) {
            if(Character.isLetterOrDigit(str.charAt(i)))
                stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
