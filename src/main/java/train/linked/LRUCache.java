package train.linked;

import java.util.HashMap;
import java.util.Map;

/** https://leetcode-cn.com/problems/lru-cache/#/ */
public class LRUCache {

  private Map<Integer, Node> map;
  private DeList list;
  private int capacity;

  public LRUCache(int capacity) {
    this.map = new HashMap<>(capacity);
    this.list = new DeList();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      list.remove(node);
      list.addFirst(node);
      return node.val;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      list.remove(node);
      map.remove(key);
      Node newNode = new Node(key, value);
      list.addFirst(newNode);
      map.put(key, newNode);
    } else {
      if (list.size == capacity) {
        Node last = list.removeLast();
        map.remove(last.key);
      }
      Node newNode = new Node(key, value);
      list.addFirst(newNode);
      map.put(key, newNode);
    }
  }

  public static class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public static class DeList {
    private Node head;
    private Node tail;
    private int size;

    public DeList() {
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
      size = 0;
    }

    public void addFirst(Node node) {
      Node headNext = head.next;
      head.next = node;
      node.prev = head;
      node.next = headNext;
      headNext.prev = node;
      size++;
    }

    public void remove(Node node) {
      Node prev = node.prev;
      Node next = node.next;
      prev.next = next;
      next.prev = prev;
      node.prev = null;
      node.next = null;
      size--;
    }

    public Node removeLast() {
      if (tail.prev == head) return null;
      Node last = tail.prev;
      remove(last);
      return last;
    }
  }
}
