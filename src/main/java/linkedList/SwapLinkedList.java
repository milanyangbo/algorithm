package linkedList;

public class SwapLinkedList {

    public static void main(String[] args) {
        ListNode headRecursion = swapListRecursion(ListNode.of());
        ListNode headLoop = swapListLoop(ListNode.of());
    }

    public static ListNode swapListRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = swapListRecursion(head.next);

        return p;

    }

    public static ListNode swapListLoop(ListNode head) {
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
