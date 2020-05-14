package com.Serialization;


import java.io.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-16 11:04
 * @Description:
 */
class TestSerializable implements Serializable {
    private transient Integer age;
    private String name;

    public TestSerializable(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestSerializable{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Serialization {
    public static void main(String[] args) throws Exception {
        TestSerializable msg = new TestSerializable(20,"Mr.Q");
        File file = new File("C:\\Users\\j2726\\Desktop\\" + "Serialization");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(msg);
        out.close();
    }
}
