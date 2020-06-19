package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:33
 * @Description:枚举实现单例模式
 */
enum Singleton {
    INSTANCE; //属性

    public static Singleton getInstance() {
        return Singleton.INSTANCE;
    }
}

public class Enum07 {
    public static void main(String[] args) {
        Singleton single = Singleton.getInstance();
        Singleton single1 = Singleton.getInstance();
        System.out.println(single == single1);
    }
}
