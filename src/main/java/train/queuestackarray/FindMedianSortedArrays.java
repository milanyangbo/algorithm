package train.queuestackarray;

/** https://leetcode-cn.com/problems/median-of-two-sorted-arrays/ */
public class FindMedianSortedArrays {

  public static void main(String[] args) {
    new FindMedianSortedArrays().findMedianSortedArrays(new int[] {1, 3}, new int[] {2});
  }

  /** 时间O(m+n) 空间O(m+n) */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    return 0;
  }

  //  /** 时间O(m+n) 空间O(m+n) */
  //  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
  //    int max = nums1.length + nums2.length;
  //    PriorityQueue<Integer> queue = new PriorityQueue<>();
  //    offer(queue, nums1);
  //    offer(queue, nums2);
  //    return 0;
  //  }
  //
  //  private void offer(PriorityQueue<Integer> queue, int[] nums) {
  //    for (int num : nums) {
  //      queue.offer(num);
  //    }
  //  }
}
