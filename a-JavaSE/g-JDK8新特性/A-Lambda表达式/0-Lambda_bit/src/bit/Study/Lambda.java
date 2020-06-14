package bit.Study;

/**
 * 匿名内部类---Lambda表达式
 */

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

        ISubject subject1 = () -> System.out.println("HeHe!");
        subject1.test();
    }
}
