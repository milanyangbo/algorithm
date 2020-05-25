package QueueAndStackAndArray;

/** https://leetcode-cn.com/problems/longest-valid-parentheses/ */
public class LongestValidParentheses {
  public static void main(String[] args) {
    new LongestValidParentheses().longestValidParentheses(")()())");
  }

  public int longestValidParentheses(String s) {
    int left = 0, right = 0, maxlength = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxlength = Math.max(maxlength, 2 * right);
      } else if (right >= left) {
        left = right = 0;
      }
    }
    left = right = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxlength = Math.max(maxlength, 2 * left);
      } else if (left >= right) {
        left = right = 0;
      }
    }
    return maxlength;
  }

  //  public int longestValidParentheses(String s) {
  //    int max = 0;
  //    for (int i = 0; i < s.length(); i++) {
  //      for (int j = s.length(); j > 0; j--) {
  //        if (i < j && (j - i) > max) {
  //          String s1 = s.substring(i, j);
  //          if (!s1.equals("") && isVaild(s1)) {
  //            max = Math.max(max, (j - i));
  //          }
  //        }
  //      }
  //    }
  //    return max;
  //  }
  //
  //  static Map<Character, Character> map = new HashMap<>();
  //
  //  static {
  //    map.put(')', '(');
  //  }
  //
  //  public boolean isVaild(String s) {
  //
  //    if (s == null || s == "" || s.length() == 1) {
  //      return false;
  //    }
  //
  //    Stack<Character> stack = new Stack<>();
  //
  //    for (int i = 0; i < s.length(); i++) {
  //      char c = s.charAt(i);
  //      if (map.containsKey(c)) {
  //        char c1 = stack.empty() ? '#' : stack.pop();
  //        if (!Objects.equals(c1, map.get(c))) {
  //          return false;
  //        }
  //      } else {
  //        stack.push(c);
  //      }
  //    }
  //
  //    return stack.empty();
  //  }
}
