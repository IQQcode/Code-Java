package com.bittech;

import java.lang.reflect.Field;

/**
 * Author: secondriver
 * Created: 2019/3/29
 */
public class BeanCopy {
    
    /**
     * 将源对象中与目的对象相同属性，源对象的属性值copy赋值给目的对象
     * <p>
     * source:
     * name
     * age
     * birthday
     * <p>
     * target:
     * name
     * age
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copy(Object source, Object target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Parameter source or target must be not null.");
        }
        //source -> class -> Fields
        //target -> class -> Fields
        //1.获取对象的Class对象
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();
        //2.获取Class对象中的属性
        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        //3.sourceFields 找 targetFields  属性名称
        for (Field s : sourceFields) {
            for (Field t : targetFields) {
                t.toString();
                if (s.getName().equals(t.getName())) {
                    //source getter =>  target setter
                    //field get set ✔
                    //4. 属性赋值
                    //完善：如果target的某个属性是final，不能赋值
                    s.setAccessible(true);
                    t.setAccessible(true);
                    try {
                        Object value = s.get(source);
                        t.set(target, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        Teacher teacher = new Teacher();//三个属性都是有值
        teacher.setName("Peter");
        teacher.setGender(true);
        teacher.setSkill("C,C++");
        
        User user = new User();//三个属性值都是null
        
        //调用用户自定义的属性值复制方法
        //Spring BeanUtils
        BeanCopy.copy(teacher, user);
        
        System.out.println(teacher);
        System.out.println(user);
        
    }
}

class Teacher {
    private String name;
    private String skill;
    private Boolean gender;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSkill() {
        return skill;
    }
    
    public void setSkill(String skill) {
        this.skill = skill;
    }
    
    public Boolean getGender() {
        return gender;
    }
    
    public void setGender(Boolean gender) {
        this.gender = gender;
        
    }
    
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", gender=" + gender +
                '}';
    }
}


class User {
    
    private String name;
    private String password;
    private Boolean gender;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public Boolean getGender() {
        return gender;
    }
    
    public void setGender(Boolean gender) {
        this.gender = gender;
        
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }
}