package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:33
 * @Description:枚举实现单例模式
 */
enum Singleton {
    INSTANCE; //属性
    public void print() {
        System.out.println("枚举实现单例模式...");
    }
}

public class Enum08 {
    public static void main(String[] args) {
        Singleton single = Singleton.INSTANCE;
        Singleton single1 = Singleton.INSTANCE;
        System.out.println(single == single1);
        single.print();
    }
}
