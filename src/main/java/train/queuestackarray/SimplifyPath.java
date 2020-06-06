package train.queuestackarray;

import java.util.Stack;

/** https://leetcode-cn.com/problems/simplify-path/ */
public class SimplifyPath {

  public static void main(String[] args) {
    new SimplifyPath().simplifyPath("/a//b////c/d//././/..");
  }

  public String simplifyPath(String path) {
    String[] paths = path.split("/");
    Stack<String> stack = new Stack();
    for (String p : paths) {
      if (p.equals("..")) {
        if (!stack.empty()) stack.pop();
      } else if (!p.equals(".") && !p.equals("")) stack.push(p);
    }

    if (stack.empty()) return "/";

    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < stack.size(); i++) {
      ans.append("/" + stack.get(i));
    }
    return ans.toString();
  }
}
