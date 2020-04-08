package iqqocde.leetcode;


import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-02 10:30
 * @Description:将数字转换为字符串处理
 * @Solution: 你再给我越界试试？
 */
public class MySolution {
    public static void main(String[] args) {
        int[] arr = new int[] {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9
                ,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6,7,2,8,5,0,9,1,2,9,5,
                3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,
                65,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,
                1,1,1,7,45,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,
                9,4,7,0,1,1,1,7,45,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,
                7,4,7,4,9,4,7,0,1,1,1,7,4};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        String s = "";
        for(int i = 0; i < digits.length; i++) {
            //拼接成字符串，最终放在变量s中
            s = s + digits[i];
        }
        BigInteger temp = new BigInteger(s);
        BigInteger num = new BigInteger("1");
        temp = temp.add(num);
        String msg = String.valueOf(temp);
        int nums[] = new int[msg.length()];
        for(int i = 0; i < msg.length(); i++){
            //逐个获取字符串中的字符
            char c = msg.charAt(i);
            //字符数字 - 字符0 就是实际的数字值
            nums[i] = (int)(c - '0');
        }
        return nums;
    }
}
