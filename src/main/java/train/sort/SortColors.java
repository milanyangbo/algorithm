package train.sort;

/** https://leetcode-cn.com/problems/sort-colors/ */
public class SortColors {

  public static void main(String[] args) {
    int[] nums = new int[] {2, 0, 2, 1, 1, 0};
    new SortColors().sortColors(nums);
  }

  public void sortColors(int[] nums) {
    int p0 = 0, p1 = nums.length - 1, cur = 0;
    while (cur <= p1) {
      if (nums[cur] == 0) {
        int temp = nums[p0];
        nums[p0++] = nums[cur];
        nums[cur++] = temp;
      } else if (nums[cur] == 2) {
        int temp = nums[p1];
        nums[p1--] = nums[cur];
        nums[cur] = temp;
      } else cur++;
    }
  }
}
