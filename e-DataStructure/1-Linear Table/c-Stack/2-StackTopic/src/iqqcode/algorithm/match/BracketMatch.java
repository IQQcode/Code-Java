package iqqcode.algorithm.match;

import java.util.Stack;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-10 08:24
 * @Description:栈-括号匹配问题
 * @Solution:(abc(f())ws
 * 遍历字符串，左括号放入栈中，遇到右括号弹栈；
 * 如果弹出的左括号与右括号一一对应则匹配；
 * 如果栈中还有元素或者右括号数量大于栈中左括号则不匹配
 */
public class BracketMatch {
    /**
     * 判str中的括号是否匹配
     * @param str 要判断的字符串
     * @return 是否匹配
     */
    public static boolean isMatch(String str) {
        //创建栈，存储左括号
        Stack<String> stack = new Stack<>();
        //遍历字符串，左括号入栈
        for (int i = 0; i < str.length(); i++) {
            //为了方便比较，将字符转为字符串
            String msg = str.charAt(i) + "";
            //如果当前字符串为右括号，则从栈中弹出一个左括号
            if (msg.equals("(")) {
                stack.push(msg);
            }else if(msg.equals(")")) {
                //判断弹出的是否为 null，为 null则没有匹配的左括号
                String pop = stack.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        //遍历完毕时，判断栈中是否还有左括号，有则匹配失败
        if (stack.size() == 0) {
            return true;
        }else {
            return false;
        }
    }
}
