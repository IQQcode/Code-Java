package com.inner.member;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-14 18:37
 * @Description:成员内部类---间接访问
 */
public class BodyI {
    private String name;

    //成员内部类
    public class Heart {

       //内部类方法
       public void beat() {
           System.out.println("内部类方法");
       }
    }

    //外部类的方法
    public void breathe() {
        new Heart().beat();
        System.out.println("外部类方法");
    }

    public static void main(String[] args) {
        BodyI body = new BodyI();
        //通过外部类的对象，调用外部类的方法，里面间接在使用内部类 Heart
        body.breathe();
    }
}
