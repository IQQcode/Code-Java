/**
 * 内部类放到类外部，实现访问外部类的私有域
 */

/*class Outter {
    private String msg = "Hellow World";
    public String getMsg() {
        return this.msg;
    }

    public void fun() {    //3. out对象调用fun()方法;
        Inner in = new Inner(this);//4.this表示当前对象
        in.print();  //7.调用方法
    }
}

class Inner {
    private Outter out;
    public Inner(Outter out) {  //5.
        this.out = out;       //6.引用传递
    }
    public void print() {     //8.执行方法
        System.out.println(out.getMsg());
    }
}

public class Class6 {
    public static void main(String[] args) {
        Outter out = new Outter();  //1.实例化Outter类对象
        out.fun();                 //2.调用Outter类方法
    }
}*/


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

/*
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
}*/


/**
 * a.成员内部类
 */

/*class Outter {
    class Inner {
        public void fun() {
            Inner in = new Inner();
        }
    }
}

public class Class6 {
    public static void main(String[] args) {
        Outter out = new Outter();
        Outter.Inner in = new Outter().new Inner();
        in.fun();
    }
}*/

/**
 * b.静态内部类
 * # # # 成员内部类不能拥有静态域，但可以访问外部类的静态域
 *  # # # 静态内部类能拥有普通属性，但不能访问外部类的普通属性
 */

/*class Outter {
    private static String msg = "Hellow Java!"; //静态内部类不能访问外部类的普通属性

    static class Inner {    //定义静态内部类
        public  void print() {
            System.out.println(msg);
        }
    }
    //**********************在外部类中定义一个方法，负责产生内部类对象并且调用print()方法
    public void fun() {
        Inner in = new Inner();
        in.print();
    }
}

public class Class6 {
    public static void main(String[] args) {
        Outter.Inner in = new Outter.Inner();
        in.print();
    }
}*/

/**
 * 方法内部类
 */
/*
class Outter {
    private int num = 18;
    public void test(int temp) {
        class Inner {        //方法内部类,不加修饰符
            private void fun() {
                num++;
                System.out.println(num);

            }
        }
        new Inner().fun();
    }
}
public class Class6 {
    public static void main(String[] args) {
        Outter out = new Outter();
        out.test(20);
    }
}
*/
