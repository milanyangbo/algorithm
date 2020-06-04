package QueueAndStackAndArray;

import java.util.Stack;

/** https://leetcode-cn.com/problems/trapping-rain-water/ */
public class TrappingRainWater {

  public static void main(String[] args) {
    new TrappingRainWater().trap(new int[] {2, 0, 2});
  }

  public int trap(int[] height) {
    if (height == null || height.length == 1) return 0;

    Stack<Integer> stack = new Stack<>();
    int ans = 0;
    for (int i = 0; i <= height.length - 1; i++) {
      while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
        int cur = stack.pop();
        while (!stack.isEmpty() && height[stack.peek()] == height[cur]) {
          stack.pop();
        }
        if (!stack.isEmpty()) {
          int lo = stack.peek();
          ans += (Math.min(height[lo], height[i]) - height[cur]) * (i - lo - 1);
        }
      }
      stack.push(i);
    }
    return ans;
  }
}
