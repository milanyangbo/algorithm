package train.linked;

/** https://leetcode-cn.com/problems/add-two-numbers/ */
public class AddTwoNumbers {

  public static void main(String[] args) {
    //    ListNode l1 = new ListNode(2).setNext(new ListNode(4).setNext(new ListNode(3)));
    //    ListNode l2 = new ListNode(5).setNext(new ListNode(6).setNext(new ListNode(4)));
    //    ListNode l1 = new ListNode(5);
    //    ListNode l2 = new ListNode(5);
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(9).setNext(new ListNode(9));
    new AddTwoNumbers().addTwoNumbers(l1, l2);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode head = new ListNode(-1);
    ListNode cur = head;
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    while (cur1 != null || cur2 != null) {
      int x1 = cur1 == null ? 0 : cur1.val;
      cur1 = cur1 == null ? null : cur1.next;

      int x2 = cur2 == null ? 0 : cur2.val;
      cur2 = cur2 == null ? null : cur2.next;

      int x = x1 + x2 + (cur.next == null ? 0 : cur.next.val);

      int c = x % 10;
      int u = x / 10;

      ListNode newNode = new ListNode(c);

      if (u == 1) {
        newNode.next = new ListNode(u);
      }

      cur.next = newNode;
      cur = newNode;
    }

    return head.next;
  }
}
