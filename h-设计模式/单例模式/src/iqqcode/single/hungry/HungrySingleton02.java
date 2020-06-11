package iqqcode.single.hungry;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:42
 * @Description:¶öººÊ½µ¥Àý---¾²Ì¬´úÂë¿é
 */
class Singleton02 {
    private static Singleton02 single;

    private Singleton02() { }

    static {
        single = new Singleton02();
    }

    public static Singleton02 getSingleton(){
        return single;
    }

    public void print() {
        System.out.println("¶öººÊ½µ¥Àý,¾²Ì¬´úÂë¿é·½Ê½");
    }
}

public class HungrySingleton02 {
    public static void main(String[] args) {
        Singleton02 single = Singleton02.getSingleton();
        Singleton02 single1 = Singleton02.getSingleton();
        System.out.println(single == single1);
        single.print();
    }
}