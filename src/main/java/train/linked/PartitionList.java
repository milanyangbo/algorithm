package train.linked;

/** https://leetcode-cn.com/problems/partition-list/ */
public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode prev = new ListNode(0 - 1);
    prev.next = head;
    ListNode cur = head;
    ListNode pre = prev;
    while (cur != null) {

      cur = cur.next;
    }
    return prev.next;
  }
}
