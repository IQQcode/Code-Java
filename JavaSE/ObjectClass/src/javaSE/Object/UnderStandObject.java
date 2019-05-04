package javaSE.Object;

/**
 * 使用Object 接收所有类的对象
 */

class Person1 { }
class Student2 { }
public class UnderStandObject {
    public static void main(String[] args) {
        // 等价于Object obj = new Object();
        fun(new Person1());
        fun(new Student2());
    }
    public static void fun(Object obj) {
        System.out.println(obj);
    }
}
