package DataStruct.topic1;
import java.util.Stack;

public class ParenthesisMatch {
    public static void main(String[] args) {
        String str = "[{\1(1)}7]";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        char[] data = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : data) {
            if(c=='{' || c=='[' || c=='(') {
                stack.push(c);
            }else {
                if(stack.isEmpty()) {
                    return false;
                }else if(c=='}') {
                    if(stack.peek() == '{') {
                        stack.pop();
                        continue;
                    }else {
                        return false;
                    }
                }else if(c==']') {
                    if(stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }else {
                        return false;
                    }
                }else if(c==')') {
                    if(stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }else {
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
