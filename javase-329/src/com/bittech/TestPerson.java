package com.bittech;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author: secondriver
 * Created: 2019/3/29
 */
public class TestPerson {
    public static void code1() {
        Person person = new Person();
        person.setName("Jack");
        person.setAge(22);
        
        //Class
        Class classz = person.getClass();
//        Method[] methods=classz.getMethods();
        Method[] methods = classz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
        
        System.out.println("-------------");
        
        
        try {
            Method toStringMethod = classz.getMethod("toString");
            Object returnValue = toStringMethod.invoke(person);
            System.out.println(returnValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        
        System.out.println("------------------");
        
        try {
            Method setNameMethod = classz.getMethod("setName", String.class);
            Object returnValue = setNameMethod.invoke(person, "Tom");
            System.out.println(returnValue);
            System.out.println(person);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        Student student = new Student();
        student.setName("Jack");
        student.setAge(22);
        student.setSchool("西科大");
        
        Class classz = student.getClass();
        
        /*
        System.out.println("--- getFields ---");
        for (Field field : classz.getFields()) {
            System.out.println(field.getName() + " " + field.getType().getName());
        }
        
        
        System.out.println("--- getDeclaredFields ---");
        for (Field field : classz.getDeclaredFields()) {
            System.out.println(field.getName() + " " + field.getType().getName());
        }
    */
        
        try {
            Field school = classz.getDeclaredField("school");
            System.out.println(school.getName() + " " + school.getType().getName());
            
            //私有属性通过反射直接无法获取的
            //通过setAccessible设置为true
            school.setAccessible(true);
            System.out.println(school.get(student));
            
            //Class getName   => 类的全限定名 包名+类名
            //Class getSimpleName  => 类名
            
            //com.bittech
            //com.github.secondriver
            
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


class Person {
    
    private String name;
    private Integer age;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    private String school;
    
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
}