package iqqcode.string.demo1;

import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-11 16:51
 * @Description:
 */
public class StringDemo {
    @Test
    public void test1() {
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    @Test
    public void test2() {
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + "world";
        String s6 = "hello" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); //true
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6); //false
        System.out.println(s3 == s7); //false
        System.out.println(s5 == s6); //false
        System.out.println(s5 == s7); //false
        System.out.println(s6 == s7); //false

        String s8 = s6.intern();
        System.out.println(s3 == s8); //true
    }

    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
    }

    @Test
    public void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
    }

    @Test
    public void test5() {
        String s1 = "helloworld";
        String s2 = "world";
        String s3 = "hello" + s2;
        System.out.println(s1 == s3); //false

        final String s4 = "hello";
        String s5 = s4 + "world";
        System.out.println(s1 == s5); //true
    }

    /**
     * 测试字符串拼接
     */
    @Test
    public void testStringBUilder_String() {
        long start = System.currentTimeMillis();
        //test_StringBuilder(); //2
        test_String(); //8897
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start));
    }

    private void test_String() {
        String str = "";
        //每次循环都会创建StringBuilder和String
        for (int i = 0; i < 100000; i++) {
            str = str + "w";
        }
    }

    private void test_StringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("w");
        }
    }
}
