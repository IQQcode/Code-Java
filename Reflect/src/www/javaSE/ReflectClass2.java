package www.javaSE;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * 反射调用普通方法
 * @public Object invoke(Object obj, Object... args)
 *       前面传Object，知道类的对象是谁，因为所有的普通方法通过对象调用
 * obj 类的实例化对象
 * args 普通方法参数
 */

/*
class Person1 {
    private String name;

    public String getName()  { return name; }

    public void setName(String name)  { this.name = name; }
}

public class ReflectClass2 {
    public static void main(String[] args) throws Exception {
        //正向处理
        //Person1 per = new Person1();
        //per.setName("张三");
        //System.out.println(per.getName());




        //反射处理
        //1.取得 Class对象
        Class<Person1> cls = Person1.class;

        //2.组装方法名称
        String setMethodName = "set" + initCap(args[0]);
        String getMethodName = "get" + initCap(args[0]);

        //3.取得 Method对象
        Method setMethod = cls.getMethod(setMethodName,String.class);//传入一个参数
        Method getMethod = cls.getMethod(getMethodName);

        //4.取得 Person类实例化对象后调用方法
        Person1 per = cls.newInstance();
        setMethod.invoke(per,"张三");
        System.out.println(getMethod.invoke(per));
    }
    //首字母大写方法名称
    private static String initCap (String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}*/


/**
 * 反射与普通属性(field)
 *
 * 在Class类中提供有两组取得属性的方法:
 * 1. 第一组（父类中）-取得类中全部属性:
 *                                 public Field[] getFields()
 * 2. 第一组(父类中)-取得类中指定名称属性:
 *                                 public Field getField(String name)
 * 3. 第二组(􀀀本类中)-取得类中全部属性:
 *                  public Field[] getDeclaredFields()
 * 4. 第二组(􀀀本类中)-取得类中指定名称属性 :
 *                  public Method getDeclaredMethod(String name, Class<?>... parameterTypes)
 *
 * @field类提供的设置与取得值方法
 *
 * I. public void set(Object obj,Object value)
 * *设置属性值
 * object类的实例化对象
 * value 要设置的值
 *
 *
 * II.  public void get(Object obj)
 * *取得属性值
 * obj 类的实例化对象
 *
 *
 * III. public Class<?> getType()
 * *取得属性类型
 */

class Person2 {
    public Integer age;
}

public class ReflectClass2 {
    public static void main(String[] args) throws  Exception{
        //反射取Class对象
        Class<Person2> cls = Person2.class;

        //取得Field对象
        Field field = cls.getField("age");

        //取得 Person实例化对象
        Person2 per = cls.newInstance();

        //set & get
        field.set(per,20);

        System.out.println(field.get(per));//哪个对象的 age属性
        System.out.println(field.getType());
    }
}