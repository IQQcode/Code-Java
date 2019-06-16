package javaSe.EverydayTest;

import java.util.*;

/**
 * 题目描述
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 测试样例：
 * "（（）（））"，6返回：true测试样例：
 * "（）a（）（）"，7返回：false测试样例：
 * "（）（（）（）"，7 false
 */


public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here

        Stack<Character> left = new Stack<>();
        if(A == null || A.length() != n) {
            return false;
        }
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '(') {
                left.push(A.charAt(i));
            }else if(A.charAt(i) == ')') {
                if (left.empty())
                    return false;
                left.pop();
            }else {
                if(left.empty())
                    return true;
            }
        }
        if(!left.empty()) {
            return false;
        }else {
            return true;
        }
    }
}
