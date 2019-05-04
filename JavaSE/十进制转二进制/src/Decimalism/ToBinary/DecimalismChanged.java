package Decimalism.ToBinary;

import  java.util.Scanner;

public class DecimalismChanged {
    public static void main(String[] args) {
        while(true) {
            System.out.print("请输入一个二进制数： ");
            Scanner input = new Scanner(System.in);
            int binary = input.nextInt();
            int out = BianaryToDecimal(binary);
            System.out.println("转换成十进制数为: " + out);
            System.out.println("输入 0 结束，输入 1 继续");
            input = new Scanner(System.in);
            if (input.nextInt() == 0) {
                break;
            }
        }
    }

    /**
     * @parseInt()用法:
     * a.将字符串转为整数。parseInt('123') // 123
     *
     * b.如果字符串头部有空格，空格会被自动去除。parseInt('   81') // 81
     *
     * c.如果parseInt的参数不是字符串，则会先转为字符串再转换。***这个很重要
     *
     * d.字符串转为整数的时候，是一个个字符依次转换，如果遇到不能转为数字的字符，就不再进行下去，返回已经转好的部分。
     *
     * e.如果字符串的第一个字符不能转化为数字（后面跟着数字的正负号除外），返回NaN。
     *
     * f.如果字符串以0x或0X开头，parseInt会将其按照十六进制数解析。parseInt('0x10') // 16
     *
     * @字符串函数subString()的用法:
     *  I.str＝str.substring(int beginIndex);
     *  截取掉str从首字母起长度为beginIndex的字符串，将剩余字符串赋值给str；
     *   String s1 ="1234567890abcdefgh";
     *   s1 = s1.substring(10);
     *   //运行结果：abcdefgh
     *
     * II.str＝str.substring(int beginIndex，int endIndex);
     * 截取str中从beginIndex开始至endIndex结束时的字符串，并将其赋值给str;
     *   String s1 ="1234567890abcdefgh";
     *   s1 = s1.substring(0,9);
     *   //运行结果：123456789
     *
     *
     * @param binary
     * @return sum;
     */

    public static int BianaryToDecimal(int binary) {
        String binStr = binary + "";
        int sum = 0;
        int len = binStr.length();
        for (int i=1; i <= len; i++) {
            //第i位 的数字为：

            int dt = Integer.parseInt(binStr.substring(i-1 , i));
            sum += (int)Math.pow(2,len-i) * dt;
        }
        return  sum;
    }
}
