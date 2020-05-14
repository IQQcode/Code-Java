/**
 * this关键字：
 * 1.this表示本类属性；
 * 2.this表示本类方法；
 * 3.this表示当前对象；
 */


/*class Person {
    public void fun() {
        //this表示当前对象
        //this表示当前调用fun()方法的对象
        System.out.println("当前对象：" + this);
    }
}

public class Class4 {
    public static void main(String[] args) {
        Person per1 = new Person();
        //此时this是per1
        per1.fun();
        System.out.println(per1);

        Person per2 = new Person();
        //此时this是per2
        per2.fun();
        System.out.println(per2);
    }
}*/


/**
 * static关键字：---均与类的实例化对象无关

 * I.static属性；——静态属性(类属性)，通过类名称直接调用，该类的所有对象共享此属性
 * ~~访问static属性应使用  类名称.属性名
 * ~~所有的非static属性必须在 对象实例化之后使用
 *
 * II.static方法；
 * 与对象无关，直接通过类名称调用
 *         描述工具方法时，一般使用静态方法-----java.util.Array.sort()--排序
 */

//static静态属性
/*
class Person {
    private String name;
    private int age;
    //static--静态属性(共享属性)
    public static String country;//静态属性一般用public修饰

    public Person (String name,int age) {
        //构造方法只给普通属性赋值
        this.name = name;
        this.age = age;
    }
    public void fun() {
        System.out.println(this.name + "今年" + age);
    }
}

public  class Class4 {
    public static void main(String[] args) {
        Person per1 = new Person("面筋哥",99);
        Person per2 = new Person("波澜哥",88);
        per1.fun();
        per2.fun();
        Person.country = "中国";   //直接通过类名称调用，与对象无关
    }
}*/



//static静态方法 ? 普通属性

/** a.静态方法能否调用普通属性？
 *           ---NO，静态方法与类的实例化对象无关，而普通属性与对象强相关
 *           class Person {
 *               private int test = 10;
 *               public static void fun() {
 *                   System.out.println(test);
 * --------堆栈上只有 fun()方法而没有 test属性，test属性只有在new<产生对象时>的时候才会产生
 *               }
 *           }
 *
 *  b.普通方法能否调用静态属性？
 *           ---YES，普通方法通过对象调用，而静态属性可以通过类名称直接调用，
 *                   无对象都可以调用，有对象当然也可以调用
 */




/**********   3.1普通代码块(变量重名问题)   ********/


/**********   3.2构造块   ********/

/**
 * 1.定义在类中的代码块(不加任何修饰符)
 * 构造快优先于构造方法执行，每当有对象产生就执行一次构造块
 */

/**********   3.3静态块   ********/

/**
 * 使用static修饰，并且定义在类中的代码块
 * I.定义在非主类中的静态块
 *              ---  静态块优先于构造块执行，并且无论有多少实例化对象参生，
 *                   只在类加载时执行一次
 *
 *
 * II.定义在主类中的静态块
 *              ----主类中的静态块优先于主方法执行
 */


       //继承

class Person {
}


