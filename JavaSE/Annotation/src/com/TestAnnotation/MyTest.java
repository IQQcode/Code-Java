package com.TestAnnotation;

public class MyTest {
    @MyAnnotation(hello="Mr.Q", world="Coding")
    @Deprecated
    @SuppressWarnings("unchecked")

    public void print() {
        System.out.println("Hello world");
    }
}