package LinkedList;

/** https://leetcode-cn.com/problems/reverse-linked-list/ */
public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode headRecursion = reverseListRecursion(ListNode.of());
    ListNode headLoop = reverseListLoop(ListNode.of());
  }

  public static ListNode reverseListRecursion(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseListRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }

  public static ListNode reverseListLoop(ListNode head) {
    if (head == null) return head;
    ListNode pre = null;
    ListNode cur = head;
    ListNode temp;
    while (cur != null) {
      temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    return pre;
  }
}
