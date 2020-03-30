package QueueAndStack;

import java.util.PriorityQueue;

public class KthLargest {

  public static void main(String[] args) {
    int k = 3;
    int[] nums = {4, 5, 8, 2};

    KthLargest kthLargest = new KthLargest(k, nums);
    kthLargest.add(3);
    kthLargest.add(5);
    kthLargest.add(10);
    kthLargest.add(9);
    kthLargest.add(4);
  }

  private PriorityQueue<Integer> priorityQueue;
  private int k;

  public KthLargest(int k, int[] nums) {
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
