
/**
   类中的组成：
               1.属性(变量，描述每个对象的具体特点)
               2.方法(操作的行为)
 */

/*
class Person {
    String name;
    int age;

    public void fun() {
        System.out.println(name + age + "在烤面筋");
    }
}

public class Class3 {
    public static void main(String[] args) {
        Person per = new Person();
        per.name = "马爸爸";
        per.age = 18;
        per.fun();
    }
}
*/






/**
     pribate
     */

class Person {
    private String name;
    private int salary;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSalary(int salary) {
        if(salary < 0 || salary > 10000) {
            System.out.println("余额数量非法！！！");
        } else {
            this.salary = salary;
        }
    }
    public int getSalary() {
        return salary;
    }

    public void fun() {
        System.out.println(name + "可以月入" + "$" +salary);
    }
}

public class Class3 {
    public static void main(String[] args) {
        Person per = new Person();
        per.setName("波澜哥");
        per.setSalary(-200);
        per.fun();
    }
}