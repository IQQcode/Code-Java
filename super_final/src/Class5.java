
//  访问权限：private(仅限本类访问)< default(包访问权限) < public

/**
 *1.方法覆写
 *  方法覆写不能出现private权限
 * 方法重载  ？？ 方法重写
 */

/*
class Person {
    public void fun() {
        this.print();
    }
    private void print() {
        System.out.println("*** 1.父类·Person类 ***");
    }
}

class Student extends Person {
    public void print() {
        System.out.println("*** 2.被覆写后的Person类 ***");
    }
}

public class Class5 {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.fun();
    }
}
*/


/**
 * 2.final关键字
 */

        //final修饰属性
/*
class Person {
    public final Student stu = new Student();
    //引用传递，final修饰的是 stu所指向的堆内存的地址；但是里面存放的值可以被修改
}
class Student {
    private int test;
    public void setTest(int test) {
        this.test = test;
    }

    public int getTest() {
        return test;
    }
}

public class Class5 {
    public static void main(String[] args) {
        Person per = new Person();
        Student stu = per.stu;   //引用传递
        per.stu.setTest(10);
        stu.setTest(20);
        System.out.println(per.stu.getTest());
    }
}
*/


/**
 * 1.向上转型
 * 2.向下转型(先发生向上转型，否则会ClassCaseException类型转换异常)
 */




