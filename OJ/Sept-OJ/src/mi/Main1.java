package mi;

import java.util.*;

public class Main1 {
    /**
     * 字符串去除重复字符
     * <p>
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
        LinkedHashSet<String> set = new LinkedHashSet<>();
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


    /**
     * 若该字符的第一个索引位置和最后一个索引位置相同，则表示该字符只出现一次，将该字符存入sb中，
     * 比如‘a’；若该字符的第一个索引位置和最后一个索引位置不同，则表示该字符至少出现两次，
     * 比如‘b’，因为我们只要存第一个‘b’即可，所以当str.indexOf（c）==i时，将该字符存入sb中，否则不存储。
     * 字符’c’和字符‘d’操作同上。
     * @param str
     * @return
     */
    public static String removeDuplicatedChars(String str) {
        // write code here
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            //依次拿出每一个字符
            char c = str.charAt(i);
            //该字符的第一个索引位置和最后一个索引位置相同，表示只出现一次
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                sb.append(c);
            } else {//该字符的第一个索引位置和最后一个索引位置不同
                if (str.indexOf(c) == i) {
                    sb.append(c);
                }
            }
        }
        String result = new String(sb);
        return result;
    }


    public static void solution(String de) {
        char[] chars = de.toCharArray();
        List<String> str = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (str.contains(String.valueOf(chars[i]))) {
                continue;
            } else {
                str.add(String.valueOf(chars[i]));
                sb.append(String.valueOf(chars[i]));
            }
        }
        System.out.println(sb.toString());
        str.forEach(i -> System.out.println(i));
    }
}
