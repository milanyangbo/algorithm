package train.linked;

/** https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/ */
public class RemoveDuplicatesFromSortedList {
  public static void main(String[] args) {}

  public ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;
    while (cur != null) {
      if (cur.next != null && cur.val == cur.next.val) cur.next = cur.next.next;
      else cur = cur.next;
    }
    return head;
  }
}
