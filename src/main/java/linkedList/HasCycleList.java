package linkedList;

import java.util.Objects;

public class HasCycleList {

  public static void main(String[] args) {}

  public static boolean HasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (Objects.equals(slow, fast)) {
        return true;
      }
    }
    return false;
  }
}
