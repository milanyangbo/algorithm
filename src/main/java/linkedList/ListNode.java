package linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
    int val;
    ListNode next;

    public static ListNode of() {
        return new ListNode().setVal(1).setNext(new ListNode().setVal(2).setNext(new ListNode().setVal(3).setNext(new ListNode().setVal(4))));
    }

    public static ListNode ofLimit2() {
        return new ListNode().setVal(1).setNext(new ListNode().setVal(2));
    }
}
