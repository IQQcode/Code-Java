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
 * @泛型方法
 * @param <T>
 */
class MyClass<T>{
    private  T t;
    public <T> T testMethod(T t) {
        return t;
    }
}

/**
 * 泛型类中的类型参数与泛型方法中的类型参数是没有相应的联系的
 *                           泛型方法始终以自己定义的类型参数为准
 */

public class Gnericity {
    public static void main(String[] args) {
        MyClass<String> myClass = new MyClass<>();

        System.out.println(myClass.testMethod(123));
    }
}