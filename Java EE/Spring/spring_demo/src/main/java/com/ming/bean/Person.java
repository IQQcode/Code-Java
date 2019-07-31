package com.ming.bean;

/**
 * you would be have default way if you were useage the spring framework
 * setter way is must be required
 */

public class Person {

    //how to injection from spring framework?
    private String pName;
//    private String pName2;
//    private String pName3;
//    private String pName4;
//    private  int pAge1;




    /**
     * Construction
     */
    public Person(){

    }

    public Person(String name){
        this.pName = name;
    }


    public String getpName() {
        return pName;
    }

    //setter
    public void setpName(String pName) {
        this.pName = pName;
    }

    public String sayHello(String message){
        return "arvin" + message;
    }


}
