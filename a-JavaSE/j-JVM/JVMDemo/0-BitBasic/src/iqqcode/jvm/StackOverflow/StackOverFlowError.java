package iqqcode.jvm.StackOverflow;

/**
 * @Author: Mr.Q
 * @Date: 2019-09-05 15:35
 * @Description: * 递归无出口StackOverFlowError
 * JVM参数 -Xss108k
 */
public class StackOverFlowError {
    private int stackLength = 1;
    public void stackDemo() {
        stackLength++;
        stackDemo();
    }
    public static void main(String[] args) {
        StackOverFlowError stack = new StackOverFlowError();
        try {
            stack.stackDemo();
        }catch(Throwable e) {
            System.out.println("Stack Length: "+ stack.stackLength);
            System.err.println("栈溢出...");
            throw e;
        }
    }
}



