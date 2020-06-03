package QueueAndStackAndArray;

import java.util.Arrays;

/** https://leetcode-cn.com/problems/next-permutation/ */
public class NextPermutation {
  public void nextPermutation(int[] nums) {
    for (int i = nums.length - 2; i >= 0; i++) {
      if (nums[i] < nums[i + 1]) {
        int j = nums.length - 1;
        for (; j > i; j--) {
          if (nums[j] > nums[i]) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            break;
          }
        }
        Arrays.sort(nums, i + 1, nums.length);
        return;
      }
    }
    Arrays.sort(nums);
  }
}
