package Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class IsValid {

    public static void main(String[] args) {
        System.out.println(isVaild("(("));
        System.out.println(isVaild("()"));
        System.out.println(isVaild("()[]{}"));
        System.out.println(isVaild("(]"));
        System.out.println(isVaild("([)]"));
        System.out.println(isVaild("{[]}"));
    }

    //'('，')'，'{'，'}'，'['，']'

    static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static boolean isVaild(String s) {

        if (s == null || s == "" || s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char c1 = stack.empty() ? '#' : stack.pop();
                if (!Objects.equals(c1, map.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }


        return stack.empty();
    }
}
