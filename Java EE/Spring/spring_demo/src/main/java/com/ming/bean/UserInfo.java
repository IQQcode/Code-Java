package com.ming.bean;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * defined javabean
 */
public class UserInfo {

    private String username;

    private Person person;

    public UserInfo(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //解耦
    public static void main(String[] args) {
        Person p = new Person();//relevant---yourself
        String result = p.sayHello(" you are friend of mine");
        System.out.println("result = " + result);
    }
}
