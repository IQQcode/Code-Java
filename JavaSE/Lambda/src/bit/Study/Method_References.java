package bit.Study;

/**
 * @方法引用的类型有
 * 四种形式：
 * 1. 引用静态方法：类名称::static 方法名称 ；
 * 2. 引用某个对象的方法：实例化对象 :: 普通方法 ；
 * 3. 引用某个特定类的方法： 类名称 :: 普通方法 ；
 * 4. 引用构造方法： 类名称 :: new 。
 */

/**
 * 1.构造方法引用
 */

/*
class Person {
    private String name;
    private int age;
    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
@FunctionalInterface
interface ILambda<R,PU,PI> {
    R createPerson(PU pu,PI pi);
}

public class Method_References {
    public static void main(String[] args) {
        ILambda<Person,String,Integer> lambda = Person :: new;
        //等同于 new Person("张三",20);
        Person per = lambda.createPerson("张三",20);
        System.out.println(per);
    }
}
*/

/**
 * 2.引用静态方法
 * @param <P>
 * @param <R>
 */

/*
interface  ILambda<P,R>{  //为返回类型，P为参数
    R switchPara (P p);
}

public class Method_References {
    public static void main(String[] args) {
        ILambda<Integer,String> stringILambda = String :: valueOf;
        //等同于 String.valueOf(20);
        System.out.println(stringILambda.switchPara(20));
    }
}*/

/**
 * 3.引用对象方法
 * @param <R>
 */
/*
@FunctionalInterface
interface  ILambda<R>{  //为返回类型，P为参数
    R switchPara ();
}

public class Method_References {
    public static void main(String[] args) {
        ILambda<String> stringILambda = "引用对象方法" :: toUpperCase;
        //等同于 String.valueOf(20);
        System.out.println(stringILambda.switchPara());
    }
}*/


/**
 * 引用普通类型
 * @param <R>
 * @param <P>
 */
@FunctionalInterface
interface  ILambda<R,P>{  //为返回类型，P为参数
    R compare (P p1,P p2);
}
//compareTo()
//java中的compareto方法，返回参与比较的前后两个字符串的asc码的差值,
//如果两个字符串首字母不同，则该方法返回首字母的asc码的差值；
//参与比较的两个字符串如果首字符相同，则比较下一个字符，直到有不同的为止;


public class Method_References {
    public static void main(String[] args) {
        ILambda<Integer,String> stringILambda = String :: compareTo;
        //等同于 String.valueOf(20);
        System.out.println(stringILambda.compare("贾","慧"));
    }
}
