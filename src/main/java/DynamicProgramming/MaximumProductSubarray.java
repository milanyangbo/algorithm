package DynamicProgramming;

/** https://leetcode-cn.com/problems/maximum-product-subarray/description/ */
public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE, imax = 1, imin = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        int temp = imax;
        imax = imin;
        imin = temp;
      }
      imax = Math.max(imax * nums[i], nums[i]);
      imin = Math.min(imin * nums[i], nums[i]);
      max = Math.max(max, imax);
    }
    return max;
  }
}
