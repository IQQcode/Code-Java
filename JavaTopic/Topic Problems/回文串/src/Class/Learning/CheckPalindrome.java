package Class.Learning;

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入字符串： ");
        String s = input.nextLine();
        if(isPalindrome(s)) {
            System.out.println(s + "是一个回文串...");
        }else {
            System.out.println(s + "不是回文串！！");
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return  true;
    }
}
