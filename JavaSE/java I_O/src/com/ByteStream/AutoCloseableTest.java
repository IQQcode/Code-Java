package com.ByteStream;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-13 09:04
 * @Description:自动关闭流 --> JDK1.7
 * AutoCloseable[自动关闭接口],此接口必须使用try-catch代码块才会自动调用
 */

class CloseTest implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("自动调用close方法");
    }
    public void fun() {
        System.out.println("显示调用");
    }
}

public  class AutoCloseableTest {
    public static void main(String[] args) {
        // AutoCloseable接口必须在try代码块中才会自动调用close()
        try(CloseTest closeTest = new CloseTest()) {
            closeTest.fun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

