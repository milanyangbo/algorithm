package QueueAndStackAndArray;

/** https://leetcode-cn.com/problems/design-circular-deque/ */
public class MyCircularDeque {

  public static void main(String[] args) {
//    MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
//    assertThat(circularDeque.insertLast(1)).isEqualTo(Boolean.TRUE); // 返回 true
//    assertThat(circularDeque.insertLast(2)).isEqualTo(Boolean.TRUE); // 返回 true
//    assertThat(circularDeque.insertFront(3)).isEqualTo(Boolean.TRUE); // 返回 true
//    assertThat(circularDeque.insertFront(4)).isEqualTo(Boolean.FALSE); // 已经满了，返回 false
//    assertThat(circularDeque.getRear()).isEqualTo(2); // 返回 2
//    assertThat(circularDeque.isFull()).isEqualTo(Boolean.TRUE); // 返回 true
//    assertThat(circularDeque.deleteLast()).isEqualTo(Boolean.TRUE); // 返回 true
//    assertThat(circularDeque.insertFront(4)).isEqualTo(Boolean.TRUE); // 返回 true
//    assertThat(circularDeque.getFront()).isEqualTo(4); // 返回 4

//    ["MyCircularDeque","insertFront","getFront","isEmpty","deleteFront","insertLast","getRear","insertLast","insertFront","deleteLast","insertLast","isEmpty"]
//[[8],[5],[],[],[],[3],[],[7],[7],[],[4],[]]
    MyCircularDeque circularDeque = new MyCircularDeque(8);
    circularDeque.insertFront(5);
    circularDeque.getFront();
    circularDeque.isEmpty();
    circularDeque.deleteFront();
    circularDeque.insertLast(3);
    circularDeque.getRear();
    circularDeque.insertLast(7);
    circularDeque.insertFront(7);
    circularDeque.deleteFront();
    circularDeque.insertLast(4);
    circularDeque.isEmpty();
  }

  public static class Node {
    int val;

    public Node(int val) {
      this.val = val;
    }

    public Node next;
    public Node prev;
  }

  private Node head;
  private Node tail;
  private int size = 0;
  private int capacity = 0;

  /** Initialize your data structure here. Set the size of the deque to be k. */
  public MyCircularDeque(int k) {
    this.head = new Node(-1);
    this.tail = new Node(-1);
    head.next = tail;
    tail.prev = head;
    this.capacity = k;
  }

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  public boolean insertFront(int value) {
    if (size == capacity) {
      return false;
    }
    Node newNode = new Node(value);
    Node node = head.next;
    head.next = newNode;
    newNode.prev = head;
    newNode.next = node;
    node.prev = newNode;
    size++;
    return true;
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  public boolean insertLast(int value) {
    if (size == capacity) {
      return false;
    }
    Node newNode = new Node(value);
    Node node = tail.prev;
    tail.prev = newNode;
    newNode.next = tail;
    newNode.prev = node;
    node.next = newNode;
    size++;
    return true;
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  public boolean deleteFront() {
    if (size == 0) {
      return false;
    }
    Node node = head.next;
    head.next = head.next.next;
    head.next.prev = head;
    node.prev = null;
    node.next = null;
    size--;
    return true;
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  public boolean deleteLast() {
    if (size == 0) {
      return false;
    }
    Node node = tail.prev;
    tail.prev = tail.prev.prev;
    tail.prev.next = tail;
    node.next = null;
    node.prev = null;
    size--;
    return true;
  }

  /** Get the front item from the deque. */
  public int getFront() {
    if (size == 0) {
      return -1;
    }
    return head.next.val;
  }

  /** Get the last item from the deque. */
  public int getRear() {
    if (size == 0) {
      return -1;
    }
    return tail.prev.val;
  }

  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return size == 0;
  }

  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
    return size == capacity;
  }
}
