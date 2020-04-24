package LinkedList;

/** https://leetcode-cn.com/problems/reverse-linked-list/ */
public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode headRecursion = new ReverseLinkedList().reverseListRecursion(ListNode.of());
    // ListNode headLoop = new ReverseLinkedList().reverseListLoop(ListNode.of());
  }

  public ListNode reverseListRecursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseListRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }

  public ListNode reverseListLoop(ListNode head) {
    if (head == null) {
      return null;
    }
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
