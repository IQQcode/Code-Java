package iqqcode.string.demo1;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-11 12:33
 * @Description:
 */
public class StringTest {
    String str = new String("Hello");
    char[] ch = {'t', 'e', 's', 't'};

    public static void change(String str, char[] ch) {
        str = "Better"; //String的不可变性,此处理解为形参出了此方法就被销毁了
        System.out.println(str); //Better
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest st = new StringTest();
        st.change(st.str, st.ch);
        System.out.println(st.str); //Hello
        System.out.println(st.ch);  //best
    }
}
