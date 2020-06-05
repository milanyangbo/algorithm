package train.greedy;

/** https://leetcode-cn.com/problems/jump-game/ */
public class JumpGame {

  public boolean canJump(int[] nums) {
    int rightmost = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i <= rightmost) {
        rightmost = Math.max(rightmost, i + nums[i]);
        if (rightmost >= nums.length - 1) return true;
      }
    }
    return false;
  }
}
