package com.string;


/**
 * @Author: Mr.Q
 * @Date: 2019-11-25 08:25
 * @Description:
 */
public class OtherMethod {
    public static void main(String[] args) {
        //replace
        String s = "Hello world Ha";
        System.out.println(s.replace('l','L'));
        System.out.println(s.replace("Ha","Hate"));

        //split
        String str = "Every thing will be fine";
        String[] result = str.split(" ");
        for(String s1 : result) {
            System.out.println(s1);
        }

        String str1 = "192.168.0.1" ;
        String[] ips = str1.split("\\.") ;
        for(String s2 : ips) {
            System.out.println(s2);
        }

        String str2 = "name:Mr.Q|age:21" ;
        String[] msg = str2.split("\\|") ;
        for (int i = 0; i < msg.length; i++) {
            String[] temp = msg[i].split(":") ;
            System.out.println(temp[0]+" = "+ temp[1]);
        }

        //compareTo
        String s3 = "abc";
        String s4 = "Abc";
        String s5 = "acc";
        System.out.println(s3.compareTo(s4));
        System.out.println(s3.compareTo(s5));
        //compareToIgnoreCase
        System.out.println(s3.compareToIgnoreCase(s4));
    }
}
