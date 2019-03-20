package bit.Study;

/**
 * 匿名内部类---Lambda表达式
 */

/*
@FunctionalInterface // 是一个函数式编程接口，只允许有一个方法
interface ISubject {
    void test();
}

public class Lambda {
    public static void main(String[] args) {
        ISubject subject = new ISubject() {
            @Override
            public void test() {
                System.out.println("函数式编程");
            }
        };
        subject.test();

        //函数式编程,匿名内部类的简化实现
        // -> == impiements
        ISubject subject1 = () -> System.out.println("HeHe!");
        subject1.test();
    }
}
*/


@FunctionalInterface // 是一个函数式编程接口，只允许有一个方法
interface ISubject {
    int test(int a,int b);
}

public class Lambda {
    public static void main(String[] args) {

        //只有一行 return语句
        //ISubject subject = (num1  ,num2) -> num1 + num2;
        //System.out.println(subject.test(10,20));

        //有多行返回值
        ISubject subject = (num1  ,num2) -> {
            num1 = num1 + num2;
            num2 = num2 - num1;
            return num1 + num2;
        };
    }
}
