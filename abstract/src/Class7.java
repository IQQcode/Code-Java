//抽象类
/*abstract class Person {
    //抽象方法
    public abstract void print();
}
class Student extends Person {
    public void print() {
        System.out.println("抽象类的子类必须覆写抽象类的所有抽象方法");
    }
}
public class Class7 {
    public static void main(String[] args) {
        Person per = new Student();
        per.print();
    }
}*/

/**
 * 上述代码在开发时会遇到的另一种形式
 */

/*
abstract class Person {
    //抽象方法
    public abstract void print();
    //抽象类中 静态的普通方法
    public static Person getInstance() {

        class Student extends Person {  //方法内部类
            public void print() {
                System.out.println("抽象类的子类必须覆写抽象类的所有抽象方法");
            }
        }
        return new Student();  //抽象类的内部提供了实例化好的子类
    }
}
public class Class7 {
    public static void main(String[] args) {
        Person per = Person.getInstance();
        per.print();
    }
}
*/



/*abstract class Person {
    public Person() {    //--2
        this.print();    //--3 调用print()方法,this在本类中找同名方法
    }
    public abstract void print();   //--4 抽象类没有具体实现，返回子类
}

class Student extends Person {
    private int num = 100;

    public Student(int num) {   //--1 :抽象类允许提供构造方法，实例化子类时，先调用父类的构造方法
        //super();  super回父类中找同名的print方法
        //还在父类的构造方法中，父类的print方法执行完，才进入到子类里
        //int num = 100;****** 还未执行到这一步
        this.num = num;
    }
     public void print() {     //--5
        System.out.println(this.num);  //--6  还在父类的构造方法中，还没到子类
     }
}

public class Class7 {
    public static void main(String[] args) {
        new Student(30);//--1
        //new Student(30).print();
    }
}*/


abstract class Person {
    public abstract void test1();

    abstract class Inner {
        public abstract void test2();
    }
}
class Student extends Person {
    @Override
    public void test1() { }

    class Overreal extends Inner {
        public void test2() { }

    }

}

public class Class7 {
    public static void main(String[] args) {
        new Student();
    }
}