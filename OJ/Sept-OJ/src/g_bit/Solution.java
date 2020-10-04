package g_bit;

import java.util.*;
/**
 * @Author: iqqcode
 * @Date: 2020-09-25 21:34
 * @Description:[吉比特]
 *   求质因数
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int factor = 2;
        int count = 0;
        while(factor <= num) {
            if(num % factor == 0) {
                num = num / factor;
                count++;
            } else {
                factor++;
            }
        }
        System.out.println(count);
    }
}
