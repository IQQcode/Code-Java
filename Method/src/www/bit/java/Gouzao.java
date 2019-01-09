package www.bit.java;


class Person {
    private String name;
    private int age;

    public Person(String name,int age) {
        this.name = name;
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void personInfo() {
        System.out.println("姓名：" + name + "年龄：" + age);
    }
}
public class Gouzao {
    public static void main(String[] args) {
        Person per = new Person("马QQ",18);
//        Person per = new Perso();
//        per.setName("马QQ");
//        per.setAge(18);
        per.personInfo();
    }
}
