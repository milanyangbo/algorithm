package QueueAndStackAndArray;

import java.util.Stack;

/** https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/submissions/ */
public class EvalRPN {

  public static void main(String[] args) {
    int reslut = new EvalRPN().evalRPN(new String[] {"4", "13", "5", "/", "+"});
  }

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      switch (token) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;
        case "-":
          stack.push(-stack.pop() + stack.pop());
          break;
        case "*":
          stack.push(stack.pop() * stack.pop());
          break;
        case "/":
          int num1 = stack.pop();
          stack.push(stack.pop() / num1);
          break;
        default:
          stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }
}
