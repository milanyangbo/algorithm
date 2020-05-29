package QueueAndStackAndArray;

import java.util.Arrays;

/** https://leetcode-cn.com/problems/3sum-closest/ */
public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ans = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length; i++) {
      int start = i + 1, end = nums.length - 1;
      while (start < end) {
        int val = nums[i] + nums[start] + nums[end];
        if (Math.abs(val - target) < Math.abs(ans - target)) {
          ans = val;
        }
        if (val < target) {
          start++;
        } else if (val > target) {
          end--;
        } else {
          return ans;
        }
      }
    }
    return ans;
  }
}
