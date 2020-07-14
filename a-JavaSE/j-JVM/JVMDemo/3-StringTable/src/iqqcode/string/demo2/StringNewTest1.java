package iqqcode.string.demo2;

import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-12 18:14
 * @Description: new String("1") + new String("1");在字符串常量池中是否存在
 */
public class StringNewTest1 {
    @Test
    public void test1() {
        String s1 = new String("1");
        s1.intern(); //调用此方法前，字符串常量池中已经存在了"1"
        String s2 = "1";
        System.out.println(s1 == s2); // JDK6--false  JDk7及之后--false
        String s3 = new String("1") + new String("1");
        s3.intern(); //字符串常量池中不存在"11"
        String s4 = "11";
        System.out.println(s3 == s4); // JDK6--false  JDk7及之后--true
    }

    @Test
    public void test2() {
        String s1 = new String("1") + new String("1");
        String s2 = "11";
        String s3 = s1.intern();

        System.out.println(s1 == s2); //false
        System.out.println(s2 == s3); //true
    }
}
