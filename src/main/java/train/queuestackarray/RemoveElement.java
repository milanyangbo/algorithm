package train.queuestackarray;

/** https://leetcode-cn.com/problems/remove-element/ */
public class RemoveElement {

  public static void main(String[] args) {
    new RemoveElement().removeElement(new int[] {3, 2, 2, 3}, 3);
  }

  public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }
}
