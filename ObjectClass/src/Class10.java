/**
 * 一、Object类
 * 二、包装类
 */

/*class Person {
    private String thing;
    private  int age;
    public Person(int age,String thing) {
        this. thing = thing;
        this.age = age;
    }

    //覆写String方法来输出对象内容,否则输出的是 Class类名称和地址
    public String toString() {
        return age + " 了" + thing;
    }
}

public class Class10 {
    public static void main(String[] args) {
       fun(new Person(20,"要好好学习！"));
    }

    public static void fun(Object obj) {
        System.out.println(obj.toString());
    }
}*/


/**
 * 1.1对象的比较
 */

/*
class Person {
    private  String name;
    private  int age;

    public  Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

*/
/*

     * @Override toString();
     * @return

*//*


    public String toSting() {
        return "姓名：" + name + ", 年龄：" + age;
    }

    @Override  //覆写equals方法
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        //判断地址是否相等，地址相同则自己和自己在比较
        if(this == obj) {
            return true;
        }

        //判断传入对象是否为Person()类对象，人与狗无可比性
        if(! (obj instanceof  Person)) {
            return false;
        }

        */
/*传入的对象为Person类对象并且地址不相等

         * 向下转型，将Object类还原为Person类的对象，比较属性值
         *//*


        Person per = (Person) obj;
        return per.name.equals(this.name) && per.age == this.age;  //this表示当前对象
    }
}

public class Class10 {
    public static void main(String[] args) {
        Person per = new Person("张三",20);
        Person per1 = new Person("张三",20);
        System.out.println(per.equals(per1));
    }
}
*/


/**
 * 1.2接收引用数据类型
 */

//1.2.I 使用Object来接收数组对象

/*public class Class10 {
    public static void main(String[] args) {
        //Object接收数组对象，向上转型
        Object obj = new int[] {1,2,3,4,5,6};

        //向下转型
        int[] data = (int[]) obj;
        for(int i: data) {
            System.out.print(i + "、");
        }
    }
}*/

//1.2.II 使用Object接收接口对象

interface IMessage {
        void getMessage();
}

class MessageImpl implements  IMessage {
    @Override
    public String toString() {
        return " I will be Succss!";
    }

    @Override
    public void getMessage() {
        System.out.println("现在不努力，毕业俩行泪……");
    }
}
public class Class10 {
    public static void main(String[] args) {
        IMessage msg = new MessageImpl();
        Object obj = msg;  //接口向Object转型
        System.out.println(obj);
        IMessage temp =(IMessage) obj;
        temp.getMessage();

    }
}

