package JavaSE.Scanner_hasNext;

import java.util.Scanner;

public class ScannerKeyBoardTest {
    public static void main(String[] args) {
        System.out.println("请输入若干单词(字符串)，以空格作为分隔");
        Scanner input = new Scanner(System.in);
        while (input.hasNext())

        //while(input.hasNext("#"))指定输入的结束标志

        {
            System.out.println("键盘输入的内容是：" + input.next());
        }
        System.out.println("退出缓存区，执行完成...");
    }
}
