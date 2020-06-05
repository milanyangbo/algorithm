package train.linked;

/** https://leetcode-cn.com/problems/reverse-nodes-in-k-group/ */
public class ReverseKGroup {

  public static void main(String[] args) {
    ListNode head =
        new ListNode(1)
            .setNext(
                new ListNode(2)
                    .setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5)))));

    new ReverseKGroup().reverseKGroup(head, 3);
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode pos = new ListNode(-1);
    pos.next = head;
    ListNode prev = pos;
    ListNode next;
    ListNode cur = head;
    while (cur != null) {
      ListNode temp = prev;
      int i = 0;
      for (; i < k; i++) {
        if (cur != null) {
          temp.next = cur;
          temp = cur;
          cur = cur.next;
        } else {
          break;
        }
      }
      if (i == k) {
        next = temp.next;
        temp.next = null;

        ListNode node = prev.next;
        ListNode pre1 = null;
        ListNode cur1 = node;
        ListNode temp1;
        while (cur1 != null) {
          temp1 = cur1.next;
          cur1.next = pre1;
          pre1 = cur1;
          cur1 = temp1;
        }
        prev.next = pre1;
        node.next = next;
        prev = node;
      }
    }

    return pos.next;
  }
}
