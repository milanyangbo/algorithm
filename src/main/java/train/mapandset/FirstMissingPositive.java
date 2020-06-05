package train.mapandset;

/** https://leetcode-cn.com/problems/first-missing-positive/solution/ */
public class FirstMissingPositive {

  public static void main(String[] args) {
    int result = new FirstMissingPositive().firstMissingPositive(new int[] {7, 8, 9, 11, 12});
  }

  /**
   * 检查 1 是否存在于数组中。如果没有，则已经完成，1 即为答案。 如果 nums = [1]，答案即为 2 。 将负数，零，和大于 n 的数替换为 1 。 遍历数组。当读到数字 a
   * 时，替换第 a 个元素的符号。 注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。 再次遍历数组。返回第一个正数元素的下标。 如果 nums[0]
   * > 0，则返回 n 。 如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1。
   */
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    int count = 0;
    for (int i = 0; i < n; ++i) {
      if (nums[i] == 1) {
        count++;
      }
    }
    if (count == 0) {
      return 1;
    }

    if (n == 1) {
      return 2;
    }

    boolean[] nums1 = new boolean[n];
    for (int i = 0; i < n; ++i) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = 1;
      }
      int num = nums[i] - 1;
      nums1[num] = true;
    }

    for (int i = 1; i < n; ++i) {
      if (!nums1[i]) {
        return i + 1;
      }
    }

    return n + 1;
  }
}
