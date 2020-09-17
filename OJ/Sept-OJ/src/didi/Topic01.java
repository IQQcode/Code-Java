package sept13.didi;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-09-14 09:53
 * @Description: 滴滴笔试题一
 *
 * 样例输入：
 * 2
 * gogogoout
 * <p>
 * 样例输出：
 * ogogoguot
 */
public class Topic01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int slen = in.nextInt();
        String str = in.next();
        int len = str.length();

        String tmp1 = solutionI(slen, str);
        System.out.println(tmp1);

        String tmp2 = solutionII(slen, str);
        System.out.println(tmp2);
    }

    //【方法一】: for循环处理
    private static String solutionI(int slen, String str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < str.length(); i += slen) {
            int cur = len - i;
            if (cur > slen) cur = slen;
            sb.append(reverse(str.substring(i, i + cur)));
        }
        return sb.toString();
    }

    //【方法二】: while循环处理
    private static String solutionII(int slen, String str) {
        StringBuilder sb = new StringBuilder();
        int start = 0, end = slen;
        String temp = null;
        while (start < str.length()) {
            if (end > str.length()) {
                end = str.length();
            }
            temp = reverse(str.substring(start, end));
            sb.append(temp);
            start = end;
            end += slen;
        }
        return sb.toString();
    }

    //字符串反转
    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int half = (int) Math.ceil(len / 2);
        for (int i = 0; i < half; i++) {
            chars[i] ^= chars[len - 1 - i];
            chars[len - 1 - i] ^= chars[i];
            chars[i] ^= chars[len - 1 - i];
        }
        return String.valueOf(chars);
    }
}
