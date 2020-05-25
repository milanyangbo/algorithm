package QueueAndStackAndArray;

import java.util.Deque;
import java.util.LinkedList;

/** https://leetcode-cn.com/problems/sliding-window-maximum/ */
public class MaxSlidingWindowwUsingDeque {

  public static void main(String[] args) {
    //    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    //    int k = 3;
    //    int[] res = maxSlidingWindow(nums, 3);

    int[] nums1 = {1, -1};
    int[] res1 = maxSlidingWindow(nums1, 1);
  }

  public static int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList();

    int[] res = new int[nums.length - (k - 1)];
    int resIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (i >= k) {
        if (deque.peekFirst() == nums[i - k]) {
          deque.removeFirst();
        }
      }

      while (!deque.isEmpty() && deque.peekLast() < num) {
        deque.removeLast();
      }

      deque.addLast(num);

      if (i >= (k - 1)) {
        res[resIndex++] = deque.peekFirst();
      }
    }

    return res;
  }
}
