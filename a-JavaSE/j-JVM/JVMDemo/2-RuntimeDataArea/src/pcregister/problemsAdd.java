package pcregister;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-26 17:53
 * @Description:i++和++i指令验证
 */
public class problemsAdd {
    public void test() {
        int i = 10;
        i = i++;

        int j = 20;
        j = ++j;
    }

    public void test1() {
        int j = 0;
        for (int i = 0; i < 10; i++) {
            j = (j++);
        }
        System.out.println(j);
    }

    public void test2() {
        int i = 10;
        int a = i++;
        int j = ++i;
    }


    public static void main(String[] args) {
        System.out.println();
    }
}