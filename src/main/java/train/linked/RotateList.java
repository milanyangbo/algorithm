package train.linked;

/** https://leetcode-cn.com/problems/rotate-list/ */
public class RotateList {

  public static void main(String[] args) {
    //    new RotateList()
    //        .rotateRight(
    //            new ListNode(1)
    //                .setNext(
    //                    new ListNode(2)
    //                        .setNext(
    //                            new ListNode(3).setNext(new ListNode(4).setNext(new
    // ListNode(5))))),
    //            2);
    new RotateList().rotateRight(new ListNode(1).setNext(new ListNode(2)), 1);
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head;

    int num = 0;
    ListNode cur = head;
    while (cur != null) {
      num++;
      if (cur.next == null) {
        cur.next = head;
        break;
      }
      cur = cur.next;
    }

    k = num - k % num - 1;

    cur = head;
    for (int i = 0; i < k; i++) {
      cur = cur.next;
    }

    head = cur.next;
    cur.next = null;

    return head;
  }
}
