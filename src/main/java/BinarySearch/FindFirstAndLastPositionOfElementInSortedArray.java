package BinarySearch;

/** https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/ */
public class FindFirstAndLastPositionOfElementInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[] {-1, -1};
    int left = bSearch(nums, target, true);
    if (left == -1) return res;
    if (left == nums.length - 1) return new int[] {left, left};
    int right = bSearch(nums, target, false);
    return new int[] {left, right};
  }

  public int bSearch(int[] nums, int target, boolean left) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      if (nums[mid] < target) lo = mid + 1;
      else if (nums[mid] > target) hi = mid - 1;
      else if (nums[mid] == target) {
        if (left) {
          if (mid == 0 || nums[mid - 1] != target) return mid;
          else hi = mid - 1;
        } else {
          if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
          else lo = mid + 1;
        }
      }
    }
    return -1;
  }
}
