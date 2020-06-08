package train.queuestackarray;

import java.util.PriorityQueue;

/** https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/ */
public class KthLargestElementInAStream {

  public static void main(String[] args) {
    int k = 3;
    int[] nums = {4, 5, 8, 2};

    KthLargestElementInAStream kthLargestElementInAStream = new KthLargestElementInAStream(k, nums);
    kthLargestElementInAStream.add(3);
    kthLargestElementInAStream.add(5);
    kthLargestElementInAStream.add(10);
    kthLargestElementInAStream.add(9);
    kthLargestElementInAStream.add(4);
  }

  private PriorityQueue<Integer> priorityQueue;
  private int k;

  public KthLargestElementInAStream(int k, int[] nums) {
    priorityQueue = new PriorityQueue<>(k);
    this.k = k;
    if (nums != null) {
      for (int num : nums) {
        add1(num);
      }
    }
  }

  public int add(int val) {
    add1(val);
    return priorityQueue.peek();
  }

  private void add1(int val) {
    if (priorityQueue.size() < k) {
      priorityQueue.add(val);
    } else {
      if (priorityQueue.peek() < val) {
        priorityQueue.poll();
        priorityQueue.add(val);
      }
    }
  }
}
