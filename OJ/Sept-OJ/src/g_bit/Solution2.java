package g_bit;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-09-25 21:43
 * @Description:
 * abccba onetwothreethreetwoone
 * 1
 *
 * ab abab
 * 2
 *
 * abcabc iusdkfjl
 * 0
 */
public class Solution2 {
    public static int match(String str, String che) {
        //求str最长子串
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(i < str.length() && j < str.length()) {
            if(!set.contains(str.charAt(j))) {
                set.add(str.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(str.charAt(i++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }
        String res = sb.toString();
        return str.length() / res.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] ss  = str.split(" ");
        String res = ss[0];
        String che = ss[1];
        System.out.println(match(res, che));
    }
}
