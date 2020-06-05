package train.linked;

/** https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/ */
public class RemoveNthFromEnd {
  public static void main(String[] args) {
    //    ListNode head =
    //        new ListNode(1)
    //            .setNext(
    //                new ListNode(2)
    //                    .setNext(new ListNode(3).setNext(new ListNode(4).setNext(new
    // ListNode(5)))));
    ListNode head = new ListNode(1);
    new RemoveNthFromEnd().removeNthFromEnd(head, 1);
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode prev = new ListNode(-1);
    prev.next = head;
    ListNode fast = prev;
    ListNode slow = prev;

    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return prev.next;
  }
}
