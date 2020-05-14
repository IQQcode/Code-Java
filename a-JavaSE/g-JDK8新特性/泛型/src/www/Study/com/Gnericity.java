package www.Study.com;

/**
 * 1.方法法的可变参数--数组
 */

/*
public class Gnericity {
    public static void main(String[] args) {
        System.out.println(add("Hold on!"));
        System.out.println(add("Hold on!",1,2,3,4));
        System.out.println(add("Hold on!",new int[] {1,2,3,4,5,6}));
    }

    public static int add(String msg,int...data) {
        int sum = 0;
        for(int i = 0;i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }
}
*/

/**
 * 泛型类: 在定义时类型不确定(啥类型都可以)，只有在具体使用时才能确定类型。
 */


/*
class MyClass<T> {  //<>里放的是任意的数据类型，不包含基本数据类型(泛型只能是类，Integer)
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}

public  class Gnericity {
    public static void main(String[] args) {
        MyClass<String> point = new MyClass<String>();
        point.setX("180度经线");
        point.setY("赤道0度纬线");
        // 取出数据
        String x = point.getX() ; // 避免了向下转型
        String y = point.getY() ;
        System.out.println("x = " +x+", y = " + y);

    }
}*/

/**
 * 泛型方法
 * @param <T>
 */
/*
class MyClass<T>{
    private  T t;
    public <T> T testMethod(T t) {
        return t;
    }
}

*/
/**
 * 泛型类中的类型参数与泛型方法中的类型参数是没有相应的联系的
 *                           泛型方法始终以自己定义的类型参数为准
 *//*


public class Gnericity {
    public static void main(String[] args) {
        MyClass<String> myClass = new MyClass<>();
        MyClass<Integer>myClass1 = new MyClass<>();
        System.out.println(myClass.testMethod("你好！"));
        System.out.println(myClass1.testMethod(20));
    }
}*/

/**
 * 3.通配符
 * extends,super---看关键字后面的类
 * @param <T>
 */


/*
class Message<T extends  String> {
    private T message;

    public  T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}

public  class  Gnericity{
    public static void main(String[] args) {
        Message<String> message = new Message<>();
        message.setMessage("Hellow");
        fun(message);
    }

    //  ? extends String(此时的子类必须是Number类型的)
    //此时方法中依然不能设置值，只能取得值。
    //现在只能确定是父类，由于子类不确定。此时发生向下转型存在不确定性因此无法设置具体值。

    // ? super String 天然的向上转型
    //Object obj = new String("java!");
    public static void fun(Message<? super String> temp) {
        temp.setMessage("java!");
        System.out.println(temp.getMessage());
    }
}*/

/**
 * 4.泛型接口
 * @param <T>
 */

/*
interface IMessage<T> {
    void print(T t);
}


class MessageImpl<T> implements IMessage<T> {

//class MessageImpl<T> implements IMessage<T> {

    @Override
    public void print(T t) {
        System.out.print(t);
    }
}

public  class Gnericity {
    public static void main(String[] args) {
        IMessage<String> msg = new MessageImpl();
        msg.print("在子类定义时继续使用泛型");

        //msg.print("在子类实现接口的时候明确给出具体类型");
    }
}
*/




