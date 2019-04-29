package www.Study;

/**
 * 递归无出口 StackOverFlowError
 *
 * JVM参数 -Xss108k
 */

public class TestStackOverFlowError {
    private int stackLength = 1;
    public void stackdemo() {
        stackLength++;
        stackdemo();
    }
    public static void main(String[] args) {
        TestStackOverFlowError test = new TestStackOverFlowError();
        try {
            test.stackdemo();
        }catch(Throwable e) {
            System.out.println("Stack Length: "+test.stackLength);
            throw e;
        }
    }
}
