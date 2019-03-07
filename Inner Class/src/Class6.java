/**
 * 1.内部类定义
 */

/*
class Outer {
    private String msg = "Hellow Word";

    //------------------------------
    //表示Inner类只能在Outter类中使用
    private class Inner {
        public void fun() {
            System.out.println(msg);
        }
    }
    //------------------------------
    public void test() {
        Inner in = new Inner();
        in.fun();
    }
}

public class Class6 {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.test();
    }
}
*/

/**
 * 2.内部类与外部类的私有属性的访问
 */

class Outter {
    private String msg = "外部类的私有属性";

    //*******************************
    class Inner {
        private String acm = "内部类的私有属性";
        public void fun() {
            //内部类可以只能接访问外部类的私有属性
            System.out.println(msg);
        }
    }
    //*******************************

    //外部类通过对象间接访问内部类私有属性
    public void test() {
        Inner in = new Inner();
        System.out.println(in.acm);
    }
}

public class Class6 {
    public static void main(String[] args) {
        Outter out = new Outter();
        out.test();
    }
}