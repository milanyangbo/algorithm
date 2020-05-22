package LinkedList;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Comparator;
import java.util.PriorityQueue;

/** https://leetcode-cn.com/problems/merge-k-sorted-lists/ */
public class MergeKLists {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1).setNext(new ListNode(4).setNext(new ListNode(5)));
    ListNode node2 = new ListNode(1).setNext(new ListNode(3).setNext(new ListNode(4)));
    ListNode node3 = new ListNode(2).setNext(new ListNode(6));
    ListNode[] lists = new ListNode[] {node1, node2, node3};
    new MergeKLists().mergeKLists(lists);
  }

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    for (ListNode node : lists) {
      while (node != null) {
        queue.add(node);
        node = node.next;
      }
    }
    ListNode head = new ListNode(-1);
    ListNode cur = head;
    while (!queue.isEmpty()) {
      ListNode node = queue.poll();
      cur.next = node;
      cur = node;
    }
    cur.next = null;
    return head.next;
  }

  @Data
  @Accessors(chain = true)
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
