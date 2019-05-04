泛型:发生类转型间的安全隐患(ClassCastException)

定义:类或方法在定义时类型不确定，使用时才确定类型

泛型类
class MyClass<T> {
	private T t;
}

泛型方法
class MyClass<T> {
	public <E> E fun(E t) {
		return t;
	}
}

通配符
问题:引入泛型后参数类型被确定，方法参数只能接收一种类型的泛型类。
public static void fun(MyClass<String> myClass)

1.?通配符。只能用在方法级别，表示指代任意类型的泛型
只能取得泛型对象中的值，无法通过类似setter方法设置值。
由于传入类型无法确定，因此无法设置具体值到相应对象中。

2.？extends 类.表示泛型上限.类与方法均可使用。
类:
class MyClass<T extends Number>
此时T必须是Number的子类，设定天花板
方法:
public void fun(MyClass<? extends Number> myClass)

?指代任意类型，但是此时必须传入Number及其子类MyClass对象
此时方法中依然不能设置值，只能取得值。
现在只能确定是父类，由于子类不确定。
此时发生向下转型存在不确定性因此无法设置具体值。

3.? super 类.表示泛型下限,只能用在方法级别
public void fun(MyClass<? super String> myClass) {
	
}
此时方法可以设置值，因为发生天然的向上转型。

总结:
1.只有上限通配符可以用在泛型类的声明上，T extends Number,此时T必须是Number及其子类、
2.只有下限通配符能在方法中修改泛型对象的内容。(天然的向上转型)

4.泛型接口
// 泛型接口
interface ISubject<T> {
    void fun(T t);
}
子类在实现接口时有两种实现方式:
a.在实现接口时就确定好接口的类型
// 子类实现接口时就确定好类型
class SubjectImpl implements ISubject<String> {
    @Override
    public void fun(String s) {

    }
}
b.子类实现接口时仍然保留泛型
// 子类实现接口时保留泛型,此时子类也是泛型类
class SubjectImpl<T> implements ISubject<T> {
    @Override
    public void fun(T t) {

    }
}

*****5.类型擦除(向下兼容)*****
泛型只存在于编译阶段，进入JVM之前，与泛型相关的信息会被完全擦除。
在JVM看来，根本就不存在泛型的概念。

泛型类在进行类型擦除时，若未指定泛型的上限，泛型相关信息会被擦除为Object类型。否则，擦除为相应的类型上限。
class MyClass<T,E extends Number> {
    public T t;
    public E e;
}
T -> Object
E -> Number

JDK1.5 泛型 枚举 注解

枚举:
单例&&多例

单例：
饿汉式单例
class Singleton {
	private static Singleton singleton = new Singleton();
	private Singleton(){}
	public static Singleton getInstance() {
		return singleton;
	}
}

枚举(实际上就是多例) enum
java中枚举使用enum来定义,enum并不是一个新的结构，
使用enum定义的枚举实际上默认继承Enum枚举类。
因此enum定义的枚举结构实际上就是一个多例类。

Enum常用的三个方法
ordinal():返回枚举对象下标，默认第一个对象编号为0
name():返回枚举对象名称，默认与对象名称保持一致。
values():返回所有枚举对象

枚举中支持定义其他结构，如构造方法、普通属性、普通方法等。
当枚举类中还包含有其他结构，枚举对象的定义必须放在首行

枚举可以实现接口,枚举中的对象成为接口对象

注解:@标识符 @Override @Controller @Data
JDK内置的三大注解
1.准确覆写@Override:
编译期检查当前覆写方法是否满足要求(方法名称是否正确、权限是否合理)

2.@Deprecated 过期声明
在早期版本的代码(方法)，表示该方法在当前版本中已经不推荐使用，但是使用了也不报错。
只是起一个警告提示作用⚠️

3.@SuppressWarnings 压制警告
压制警告信息，压制信息不再提示

JDK1.8 接口
早期版本的接口已经有很多子类实现了，此时发现接口中的方法需要改动甚至新增方法，
无法修改接口(全局常量+抽象方法)

将接口做了扩充:支持default定义的普通方法与静态方法

default定义的普通方法，通过子类对象调用，所有子类均拥有此方法。

static定义的静态方法，通过接口名称直接调用。

Lambda表达式:函数式编程




