package train.queuestackarray;

import java.util.Comparator;
import java.util.PriorityQueue;

/** https://leetcode-cn.com/problems/sliding-window-maximum/ */
public class MaxSlidingWindowwUsingPriorityQueue {

  public static void main(String[] args) {
    //    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    //    int k = 3;
    //    int[] res = maxSlidingWindow(nums, 3);

    int[] nums1 = {1, -1};
    int[] res1 = maxSlidingWindow(nums1, 1);
  }

  public static int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue =
        new PriorityQueue(k, (Comparator<Integer>) (i1, i2) -> i2 - i1);

    int[] res = new int[nums.length - (k - 1)];
    int resIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (i >= k) {
        priorityQueue.remove(nums[i - k]);
      }

      priorityQueue.add(num);

      if (i >= (k - 1)) {
        res[resIndex++] = priorityQueue.peek();
      }
    }
    return res;
  }
}
