package meilaiwang;

/**
 * @Author: iqqcode
 * @Date: 2020-10-14 18:51
 * @Description:美莱网 样例输入
 * 1,2#3,4
 * <p>
 * 样例输出
 * 1,2,4,3
 */

import java.util.*;

public class Solution {
    public static void prt(int[][] arr) {

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        int len = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '#') {
//                break;
//            }
//            len++;
//        }
//        len = (int) Math.ceil(len >> 1);
//        len++;
        String[] ss = str.split("#");
        String regStrat = "^[ ]*";
        int[][] arr = new int[0][0];
        int num = 0, row = 0, col = 0;
        for (int i = 0; i < ss.length; i++) {
            ss[i].replaceAll(regStrat, "").replaceAll(" ", "");
            for (int j = 0; j < ss[i].length(); j++) {
                String[] res = ss[i].split(",");
                for (int k = 0; k < res.length; k++) {
                    int[] ro = new int[0];
                }
            }
//            num = Integer.parseInt(ss[i]);
//            row = i / 3;
//            col = i % 3;
//            arr[row][col] = num;
        }
        System.out.println(Arrays.toString(ss));

    }
}
