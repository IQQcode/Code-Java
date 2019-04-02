package com.bittech.annotation;

/**
 * Author: secondriver
 * Created: 2019/3/31
 */
public class TestMyAnnotation {
    
    public static void main(String[] args) {
     MyAnnotation myAnnotation=   Member.class.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.getClass());
        System.out.println(myAnnotation.name());
        System.out.println(myAnnotation.age());
      
    }
}

@MyAnnotation
class Member{

}