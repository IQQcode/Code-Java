/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 19:07
 * @Description:LT917-仅仅反转字母
 * @solve:双指针
 * 输入："ab-cd"
 * 输出："dc-ba"

 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"

 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 */

public class LT917 {
    public static void main(String[] args) {
        String str = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(str));
    }

    public static String reverseOnlyLetters(String S) {
        char[] chs = S.toCharArray();
        int left = 0;
        int right = S.length()-1;
        while (left < right) {
            //'-'则跳过
            while(!Character.isLetter(chs[left])) {
                left++;
                if(left > right) {
                    break;
                }
            }
            if(left > right) {
                break;
            }
            while(!Character.isLetter(chs[right])) {
                right--;
            }
            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chs);
    }
}
