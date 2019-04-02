package com.bittech.file;

/**
 * Author: secondriver
 * Created: 2019/3/31
 */
public class SimpleMessage implements AutoCloseable {
    
    public void print() {
        System.out.println("SimpleMessage print方法调用");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("AutoCloseable  close 方法调用");
    }
    
    public static void main(String[] args) {
//        SimpleMessage message = null;
//        try {
//            message = new SimpleMessage();
//            message.print();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (message != null) {
//                try {
//                    message.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        
        //JDK7 try-with-resources
        try (SimpleMessage message = new SimpleMessage()) {
            message.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
