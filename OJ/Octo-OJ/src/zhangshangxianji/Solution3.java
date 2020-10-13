package zhangshangxianji;

/**
 * @Author: iqqcode
 * @Date: 2020-10-13 19:49
 * @Description:掌上先机
 * 按要求反转字符串
 * 只翻转单词，如果单词含有非字母字符，则不做处理
 * [case]:
 *      a hello1 abc good!
 *      a hello1 cba good!
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] ss = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            if(isLeagle(ss[i])) {
                ss[i] = reverse(ss[i]);
            } else {
                continue;
            }
        }

        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static String reverse(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length - 1;
        int half = (int) Math.floor(len / 2);
        for (int i = 0; i < half; i++) {
            ch[i] ^= ch[len - i];
            ch[len - i] ^= ch[i];
            ch[i] ^= ch[len - i];
        }
        return String.valueOf(ch);
    }

    // 不用正则只能循环走一遍
    private static boolean isLeagle(String s) {
        Pattern p = Pattern.compile("[a-zA-Z]{1,}");
        Matcher m = p.matcher(s);
        return m.matches();
    }
}
