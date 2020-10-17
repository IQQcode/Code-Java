package boss;

/**
 * @Author: iqqcode
 * @Date: 2020-10-15 18:30
 * @Description:
 */

import java.util.*;

/**
 * "While there is life, there is hope.",["hope", "here"]
 *
 * ["here","here","hope"]
 */
public class Solution2 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param content string字符串
     * @param sensitiveWords string字符串一维数组
     * @return string字符串ArrayList
     */
    public static ArrayList<String> filterSensitiveWords (String content, String[] sensitiveWords) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        int count = 0, index = 0;
        for (int i = 0; i < sensitiveWords.length; i++) {
            while((index = content.indexOf(sensitiveWords[i])) != -1) {
                list.add(sensitiveWords[i]);
                content = content.substring(index + sensitiveWords[i].length());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String str = "While there is life, there is hope.";
        String[] sub = {"hope", "here"};
        ArrayList<String> list = filterSensitiveWords(str, sub);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
