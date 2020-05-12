package iqqcode.algorithm.expression;
import	java.util.Stack;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-10 09:15
 * @Description:逆波兰表达式
 * @Solution:栈--来存储操作数
 * 1.遍历表达式，遇到操作数压栈
 * 2.遇到运算符，则弹出两个操作数与该运算符做运算得出计算结果，将结果再次压栈
 * 3.到达字符串末尾，将最终的计算结果弹栈返回
 */
public class PolishExpression {
    /**
     * @param str 逆波兰表达式
     * @return 逆波兰表达式计算结果
     */
    public static int polish(String[] str) {
        //定义栈，来存放表达式中的操作数
        Stack<Integer> stack = new Stack<Integer> ();
        for (int i = 0; i < str.length; i++) {
            String curr = str[i];
            int num1 = 0, num2 = 0, result = 0;
            switch (curr) {
                //如为运算符，则从栈中弹出两个操作数，完成运算，再将运算结果压栈
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num2 + num1;
                    stack.push(result);
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num2 - num1;
                    stack.push(result);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num2 * num1;
                    stack.push(result);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num2 / num1;
                    stack.push(result);
                    break;
                //遍历表达式，如为操作数则入栈
                default:
                    stack.push(Integer.parseInt(curr));
                    break;
            }
        }
        //表达式便利完成，弹出栈中最终计算结果
        return stack.pop();
    }
}
