/**
 * @异常与捕获
 */

/*
public class Class12 {
    public static void main(String[] args) {
        System.out.println("1.数学计算开始了……");
        try {
            System.out.println("2.计算：" + (10 / 0));
        }catch (ArithmeticException e){
            //输出错误堆栈信息
            e.printStackTrace();
        }finally {
            System.out.println("[Finally]无论是否产生异常，都会执行此语句");
        }
        System.out.println("3.数学计算结束！");
    }
}
*/




/**
 * finally
 * finally()代码块无论如何都会被执行
 *     若 try或 catch块中都有return 语句，则在return语句执行之前一定会执行finally代码块
 */

public class Class12 {
    public static void main(String[] args) {
        System.out.println("输出执行块：" + test());
    }

    public static int test() {
        try {
            System.out.println("10 / 2 = " + (10 / 2));
            return 1;
        }catch (Exception error){
            error.printStackTrace();
            return 2;
        }finally {
            return 3;
        }
    }
}


