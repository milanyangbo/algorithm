package train.binarysearch;

/** https://leetcode-cn.com/problems/search-insert-position/ */
public class SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;
    int mid = 0;
    while (lo <= hi) {
      mid = lo + ((hi - lo) >> 1);
      if (nums[mid] < target) lo = mid + 1;
      else if (nums[mid] > target) hi = mid - 1;
      else if (nums[mid] == target) {
        if (mid == 0 || nums[mid - 1] != target) return mid;
        else hi = mid - 1;
      }
    }
    return lo;
  }
}
