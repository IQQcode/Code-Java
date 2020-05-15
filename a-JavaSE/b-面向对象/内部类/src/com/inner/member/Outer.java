package com.inner.member;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-14 20:41
 * @Description:内部类重名变量的访问
 */
public class Outer {
     //外部类名称.this.外部类成员变量名
     int num = 10;
     public class Inner {
         int num = 20;
         public void innerMethod() {
             int num = 30;
             System.out.println(num); //局部变量，就近原则
             System.out.println(this.num);  //内部类的成员变量
             System.out.println(Outer.this.num);  //外部类的成员变量
         }
     }

    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.innerMethod();
    }
}
