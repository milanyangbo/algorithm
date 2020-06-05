package train.queuestackarray;

import java.util.Stack;

/** https://leetcode-cn.com/problems/reverse-words-in-a-string/ */
public class ReverseWords {
  public static void main(String[] args) {
    new ReverseWords().reverseWords("the sky is blue");
  }

  public String reverseWords(String s) {
    int left = 0, right = s.length() - 1;
    while (left <= right && s.charAt(left) == ' ') {
      ++left;
    }

    while (left <= right && s.charAt(right) == ' ') {
      --right;
    }

    int i = right;
    StringBuffer sb = new StringBuffer();
    Stack<Character> stack = new Stack<>();
    while (i >= left) {
      if (s.charAt(i) != ' ') {
        stack.push(s.charAt(i));
      }
      if (i == left || s.charAt(i) == ' ') {
        if (!stack.isEmpty()) {
          while (!stack.isEmpty()) {
            sb.append(stack.pop());
          }
          if (i != left) {
            sb.append(' ');
          }
        }
      }
      i--;
    }
    return sb.toString();
  }
}
