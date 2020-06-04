package Greedy;

/** https://leetcode-cn.com/problems/jump-game-ii/ */
public class JumpGameII {

  public static void main(String[] args) {
    new JumpGameII().jump(new int[] {2, 3, 1, 1, 4});
  }

  public int jump(int[] nums) {
    int steps = 0;
    int maxPosition = 0;
    int end = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      maxPosition = Math.max(maxPosition, i + nums[i]);
      if (i == end) {
        end = maxPosition;
        steps++;
      }
    }

    return steps;
  }
}
