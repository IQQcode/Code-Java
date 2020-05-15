package com.inner.member;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-14 18:37
 * @Description:成员内部类---间接访问
 */
public class BodyII {
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
        //直接创建内部类对象来访问
        //外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();
        BodyII.Heart body = new BodyII().new Heart();
        body.beat();
    }
}
