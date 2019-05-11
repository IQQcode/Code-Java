package javaSE.Object;

/**
 * 使用Object 接收所有类的对象
 */



class Student {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "姓名：" + this.name + " 年龄：" + this.age;
    } }
public class UnderStandObject {
    public static void main(String[] args) {
      Student stu1 = new Student("张三",20);
      Student stu2 = new Student("张三",20);
        System.out.println(stu1.equals(stu2));
    }
}


