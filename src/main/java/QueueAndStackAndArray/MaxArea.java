package QueueAndStackAndArray;

/** https://leetcode-cn.com/problems/container-with-most-water/ */
public class MaxArea {

  public static void main(String[] args) {
    new MaxArea().maxArea(new int[] {1, 1});
  }

  public int maxArea(int[] height) {
    if (height == null || height.length == 1) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    for (int i = height.length - 1; i >= 0; i--) {
      for (int j = 0; j < height.length - 1; j++) {
        if (j < i) {
          int right = height[i], left = height[j];
          max = Math.max(max, Math.min(right, left) * (i - j));
        }
      }
    }
    return max;
  }
}
