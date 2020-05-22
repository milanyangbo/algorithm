package QueueAndStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/** https://leetcode-cn.com/problems/valid-parentheses/description/ */
public class BracketIsValid {

  public static void main(String[] args) {
//    System.out.println(new BracketIsValid().isVaild("(("));
//    System.out.println(new BracketIsValid().isVaild("()"));
//    System.out.println(new BracketIsValid().isVaild("()[]{}"));
//    System.out.println(new BracketIsValid().isVaild("(]"));
//    System.out.println(new BracketIsValid().isVaild("([)]"));
//    System.out.println(new BracketIsValid().isVaild("{[]}"));
    System.out.println(new BracketIsValid().isVaild("(((()())()()))()(())"));
  }

  // '('，')'，'{'，'}'，'['，']'

  static Map<Character, Character> map = new HashMap<>();

  static {
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
  }

  public boolean isVaild(String s) {

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
