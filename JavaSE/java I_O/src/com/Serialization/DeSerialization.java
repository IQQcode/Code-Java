package com.Serialization;


import java.io.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-16 11:04
 * @Description:
 */
public class DeSerialization {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\j2726\\Desktop\\" + "Serialization");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object test = in.readObject();
        System.out.println(test);
    }
}
