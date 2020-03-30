package Decimalism.ToBinary;

import java.util.Scanner;

public class StringChanged {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("请输入一个十进制数： ");
            while(input.hasNext()) {
                int num=input.nextInt();
                System.out.print("转换成二进制数为： ");
                System.out.println(toBinary(num));
            }
        }

        public static String toBinary(int num){
            //定义一个String用于返回得到的二进制
            String binary="";
            //判断接收的数是否为零，是零直接返回零
            if(num==0){
                return "0";
            }
            //判断移位后的数是否为零，为零结束
            while(num!=0){
                //获取每一位
                int bit=num&1;
                //将获取的位添加到字符串
                binary=binary+bit;
                //向右移一位
                num=num>>1;
            }
            //我们获得的二进制是反向的所以通过Stringbuffer工具类把字符串反转
            return new StringBuffer(binary).reverse().toString();

        }

    //数学方式
    public static String mathToBinary(int num){
        String binary="";
        if(num==0){
            return "0";
        }
        while(num!=0){
            int bit=num%2;
            binary=binary+bit;
            num=num/2;

        }
        return new StringBuffer(binary).reverse().toString();
    }
}
