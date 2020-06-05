package train.linked;

import java.util.Comparator;
import java.util.PriorityQueue;

/** https://leetcode-cn.com/problems/merge-two-sorted-lists/ */
public class MergeTwoLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }

    PriorityQueue<ListNode> queue = new PriorityQueue<>(2, Comparator.comparingInt(o -> o.val));
    if (l1 != null) queue.add(l1);
    if (l2 != null) queue.add(l2);
    ListNode head = new ListNode(-1);
    ListNode cur = head;
    while (!queue.isEmpty()) {
      ListNode node = queue.poll();
      if (node.next != null) {
        queue.offer(node.next);
      }
      cur.next = node;
      cur = node;
    }
    cur.next = null;
    return head.next;
  }
}
