package QueueAndStack;

import java.util.Stack;

/** https://leetcode-cn.com/problems/implement-queue-using-stacks/description/ */
public class UsingStackToQueue {

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();

    queue.push(1);
    queue.push(2);
    int i = queue.peek(); // 返回 1
    int i1 = queue.pop(); // 返回 1
    queue.empty(); // 返回 false
  }

  public static class MyQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
      pushStack = new Stack<>();
      popStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
      pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      if (popStack.empty()) {
        while (!pushStack.empty()) {
          popStack.push(pushStack.pop());
        }
      }
      return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
      if (popStack.empty()) {
        while (!pushStack.empty()) {
          popStack.push(pushStack.pop());
        }
      }
      return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return pushStack.empty() && popStack.empty();
    }
  }
}
