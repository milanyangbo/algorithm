package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/** https://leetcode-cn.com/problems/merge-k-sorted-lists/ */
public class MergeKLists {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1).setNext(new ListNode(4).setNext(new ListNode(5)));
    ListNode node2 = new ListNode(1).setNext(new ListNode(3).setNext(new ListNode(4)));
    ListNode node3 = new ListNode(2).setNext(new ListNode(6));
    ListNode[] lists = new ListNode[] {node1, node2, node3};
    new MergeKLists().mergeKLists(new ListNode[] {});
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue =
        new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
    for (ListNode node : lists) {
      if (node != null) {
        queue.add(node);
      }
    }
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
