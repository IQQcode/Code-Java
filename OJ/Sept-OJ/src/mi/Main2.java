package mi;

import java.util.*;

public class Main2 {
    /**
     * ()[]{}
     * ([)]
     * {[]}
     * <p>
     * true
     * false
     * true
     */

    // '(' ,')','{','}','[',']'
    static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('}', '{');
        put(')', '(');
        put(']', '[');
    }};

    public static boolean isValid(String str) {
        if (str.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //String str = "()[]{}";
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            if (str.equals("")) {
                System.out.println("true");
            } else {
                System.out.println(isValid(str));
            }
        }
    }
}
