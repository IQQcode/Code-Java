package com.TestAnnotation;

public class MyTest {
    @MyAnnotation(hello="Mr.Q", world="Coding")
    @Deprecated
    @SuppressWarnings("all")

    public void print() {
        System.out.println("Hello world");
    }
}