package linkedList;

/** https://leetcode-cn.com/problems/swap-nodes-in-pairs/ */
public class SwapLinkedList {

  public static void main(String[] args) {
    // ListNode headRecursion = swapListRecursion(ListNode.of());
    ListNode headLoop = swapListLoop(ListNode.of());
  }

  public static ListNode swapListRecursion(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = swapListRecursion(head.next);

    return p;
  }

  public static ListNode swapListLoop(ListNode head) {
    if (head == null) return head;
    if (head.next == null) return head;
    ListNode pre = new ListNode(0);
    pre.next = head;
    ListNode temp = pre;
    while (temp.next != null && temp.next.next != null) {
      ListNode start = temp.next;
      ListNode end = temp.next.next;
      temp.next = end;
      start.next = end.next;
      end.next = start;
      temp = start;
    }
    return pre.next;
  }
}
