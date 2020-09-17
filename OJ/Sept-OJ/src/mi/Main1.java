package mi;

import java.util.*;

public class Main1 {
    /**
     * hello, welcome to xiaomi
     * <p>
     * helo, wcmtxia
     *
     * @param args
     */

    public static void main(String[] args) {
        //String str = "hello, welcome to xiaomi";
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder sb = new StringBuilder();
        LinkedHashSet set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            int first = str.indexOf(c);
//            if(first == i) {
//                sb.append(c);
//            }
            set.add(str.substring(i, i + 1));
        }
        for (Object o : set) {
            sb.append(o);
        }

        //System.out.println(set.iterator().next());
        System.out.println(sb.toString());
    }
}
