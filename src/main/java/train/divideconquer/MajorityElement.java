package train.divideconquer;

/** https://leetcode-cn.com/problems/majority-element/ */
public class MajorityElement {

  public static void main(String[] args) {
    int[] nums = new int[] {2, 3, 1, 1, 1, 2, 2};
    double d = new MajorityElement().majorityElementRec(nums, 0, nums.length - 1);
  }

  /** 暴力 n平方 map n sort nlogn 分治 nlogn */
  private int majorityElementRec(int[] nums, int lo, int hi) {
    if (lo == hi) {
      return nums[lo];
    }

    // 取中间值关键方法
    int mid = (hi - lo) / 2 + lo;
    int left = majorityElementRec(nums, lo, mid);
    int right = majorityElementRec(nums, mid + 1, hi);

    if (left == right) {
      return left;
    }

    int leftCount = countInRange(nums, left, lo, hi);
    int rightCount = countInRange(nums, right, lo, hi);

    return leftCount > rightCount ? left : right;
  }

  private int countInRange(int[] nums, int num, int lo, int hi) {
    int count = 0;
    for (int i = lo; i <= hi; i++) {
      if (nums[i] == num) {
        count++;
      }
    }
    return count;
  }
}
