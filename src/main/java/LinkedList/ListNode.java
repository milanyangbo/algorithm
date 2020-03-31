package LinkedList;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ListNode {
  int val;
  ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public static ListNode of() {
    return new ListNode()
        .setVal(1)
        .setNext(
            new ListNode()
                .setVal(2)
                .setNext(new ListNode().setVal(3).setNext(new ListNode().setVal(4))));
  }

  public static ListNode ofLimit2() {
    return new ListNode().setVal(1).setNext(new ListNode().setVal(2));
  }
}
