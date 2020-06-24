package train.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author <a href="mailto:yangbo2@wljs.com">yangbo2</a>
 * @date 2020/6/24 15:01
 */
public class BPlusTree<K extends Comparable<? super K>, V> {

  @Test
  public void test() {
    BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>(4);
    bpt.insert(0, "a");
    bpt.insert(1, "b");
    bpt.insert(2, "c");
    bpt.insert(3, "d");
    bpt.insert(4, "e");
    bpt.insert(5, "f");
    bpt.insert(6, "g");
    bpt.insert(7, "h");
    bpt.insert(8, "i");
    bpt.insert(9, "j");
    bpt.delete(1);
    bpt.delete(3);
    bpt.delete(5);
    bpt.delete(7);
    bpt.delete(9);
    Assert.assertEquals(bpt.search(0), "a");
    Assert.assertEquals(bpt.search(1), null);
    Assert.assertEquals(bpt.search(2), "c");
    Assert.assertEquals(bpt.search(3), null);
    Assert.assertEquals(bpt.search(4), "e");
    Assert.assertEquals(bpt.search(5), null);
    Assert.assertEquals(bpt.search(6), "g");
    Assert.assertEquals(bpt.search(7), null);
    Assert.assertEquals(bpt.search(8), "i");
    Assert.assertEquals(bpt.search(9), null);
  }

  @Test
  public void testSearchRange() {
    BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>(4);
    bpt.insert(0, "a");
    bpt.insert(1, "b");
    bpt.insert(2, "c");
    bpt.insert(3, "d");
    bpt.insert(4, "e");
    bpt.insert(5, "f");
    bpt.insert(6, "g");
    bpt.insert(7, "h");
    bpt.insert(8, "i");
    bpt.insert(9, "j");
    Assert.assertArrayEquals(
        bpt.searchRange(3, RangePolicy.EXCLUSIVE, 7, RangePolicy.EXCLUSIVE).toArray(),
        new String[] {"e", "f", "g"});
    Assert.assertArrayEquals(
        bpt.searchRange(3, RangePolicy.INCLUSIVE, 7, RangePolicy.EXCLUSIVE).toArray(),
        new String[] {"d", "e", "f", "g"});
    Assert.assertArrayEquals(
        bpt.searchRange(3, RangePolicy.EXCLUSIVE, 7, RangePolicy.INCLUSIVE).toArray(),
        new String[] {"e", "f", "g", "h"});
    Assert.assertArrayEquals(
        bpt.searchRange(3, RangePolicy.INCLUSIVE, 7, RangePolicy.INCLUSIVE).toArray(),
        new String[] {"d", "e", "f", "g", "h"});
  }

  public static enum RangePolicy {
    EXCLUSIVE,
    INCLUSIVE
  }

  public static final int DEFAULT_BRANCHING_FACTOR = 128;

  private int branchingFactor;

  private Node root;

  public BPlusTree() {
    this(DEFAULT_BRANCHING_FACTOR);
  }

  public BPlusTree(int branchingFactor) {
    if (branchingFactor <= 2)
      throw new IllegalArgumentException("Illegal branching factor: " + branchingFactor);
    this.branchingFactor = branchingFactor;
    root = new LeafNode();
  }

  public V search(K key) {
    return root.getValue(key);
  }

  public List<V> searchRange(K key1, RangePolicy policy1, K key2, RangePolicy policy2) {
    return root.getRange(key1, policy1, key2, policy2);
  }

  public void insert(K key, V value) {
    root.insertValue(key, value);
  }

  public void delete(K key) {
    root.deleteValue(key);
  }

  public String toString() {
    Queue<List<Node>> queue = new LinkedList<>();
    queue.add(Arrays.asList(root));
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      Queue<List<Node>> nextQueue = new LinkedList<>();
      while (!queue.isEmpty()) {
        List<Node> nodes = queue.remove();
        sb.append('{');
        Iterator<Node> it = nodes.iterator();
        while (it.hasNext()) {
          Node node = it.next();
          sb.append(node.toString());
          if (it.hasNext()) {
            sb.append(",");
          }
          if (node instanceof BPlusTree.InternalNode) {
            nextQueue.add(((InternalNode) node).children);
          }
        }
        sb.append('}');
        if (!queue.isEmpty()) {
          sb.append(',');
        } else {
          sb.append('\n');
        }
      }
      queue = nextQueue;
    }
    return sb.toString();
  }

  private abstract class Node {
    List<K> keys;

    int keyNumber() {
      return keys.size();
    }

    abstract V getValue(K key);

    abstract void deleteValue(K key);

    abstract void insertValue(K key, V value);

    abstract K getFirstLeafKey();

    abstract List<V> getRange(K key1, RangePolicy policy1, K key2, RangePolicy policy2);

    abstract void merge(Node sibling);

    abstract Node split();

    abstract boolean isOverflow();

    abstract boolean isUnderflow();

    public String toString() {
      return keys.toString();
    }
  }

  private class InternalNode extends Node {
    List<Node> children;

    InternalNode() {
      this.keys = new ArrayList<>();
      this.children = new ArrayList<>();
    }

    @Override
    V getValue(K key) {
      return getChild(key).getValue(key);
    }

    @Override
    void deleteValue(K key) {
      Node child = getChild(key);
      child.deleteValue(key);
      if (child.isUnderflow()) {
        Node childLeftSibling = getChildLeftSibling(key);
        Node childRightSibling = getChildRightSibling(key);
        Node left = childLeftSibling != null ? childLeftSibling : child;
        Node right = childLeftSibling != null ? child : childRightSibling;
        left.merge(right);
        deleteChild(right.getFirstLeafKey());
        if (left.isOverflow()) {
          Node sibling = left.split();
          insertChild(sibling.getFirstLeafKey(), sibling);
        }
        if (root.keyNumber() == 0) root = left;
      }
    }

    @Override
    void insertValue(K key, V value) {
      Node child = getChild(key);
      child.insertValue(key, value);
      if (child.isOverflow()) {
        Node sibling = child.split();
        insertChild(sibling.getFirstLeafKey(), sibling);
      }
      if (root.isOverflow()) {
        Node sibling = split();
        InternalNode newRoot = new InternalNode();
        newRoot.keys.add(sibling.getFirstLeafKey());
        newRoot.children.add(this);
        newRoot.children.add(sibling);
        root = newRoot;
      }
    }

    @Override
    K getFirstLeafKey() {
      return children.get(0).getFirstLeafKey();
    }

    @Override
    List<V> getRange(K key1, RangePolicy policy1, K key2, RangePolicy policy2) {
      return getChild(key1).getRange(key1, policy1, key2, policy2);
    }

    @Override
    void merge(Node sibling) {
      InternalNode node = (InternalNode) sibling;
      keys.add(node.getFirstLeafKey());
      keys.addAll(node.keys);
      children.addAll(node.children);
    }

    @Override
    Node split() {
      int from = keyNumber() / 2 + 1, to = keyNumber();
      InternalNode sibling = new InternalNode();
      sibling.keys.addAll(keys.subList(from, to));
      sibling.children.addAll(children.subList(from, to + 1));

      keys.subList(from - 1, to).clear();
      children.subList(from, to + 1).clear();

      return sibling;
    }

    @Override
    boolean isOverflow() {
      return children.size() > branchingFactor;
    }

    @Override
    boolean isUnderflow() {
      return children.size() < (branchingFactor + 1) / 2;
    }

    Node getChild(K key) {
      int loc = Collections.binarySearch(keys, key);
      int childIndex = loc >= 0 ? loc + 1 : -loc - 1;
      return children.get(childIndex);
    }

    void deleteChild(K key) {
      int loc = Collections.binarySearch(keys, key);
      if (loc >= 0) {
        keys.remove(loc);
        children.remove(loc + 1);
      }
    }

    void insertChild(K key, Node child) {
      int loc = Collections.binarySearch(keys, key);
      int childIndex = loc >= 0 ? loc + 1 : -loc - 1;
      if (loc >= 0) {
        children.set(childIndex, child);
      } else {
        keys.add(childIndex, key);
        children.add(childIndex + 1, child);
      }
    }

    Node getChildLeftSibling(K key) {
      int loc = Collections.binarySearch(keys, key);
      int childIndex = loc >= 0 ? loc + 1 : -loc - 1;
      if (childIndex > 0) return children.get(childIndex - 1);

      return null;
    }

    Node getChildRightSibling(K key) {
      int loc = Collections.binarySearch(keys, key);
      int childIndex = loc >= 0 ? loc + 1 : -loc - 1;
      if (childIndex < keyNumber()) return children.get(childIndex + 1);

      return null;
    }
  }

  private class LeafNode extends Node {
    List<V> values;
    LeafNode next;

    LeafNode() {
      keys = new ArrayList<K>();
      values = new ArrayList<V>();
    }

    @Override
    V getValue(K key) {
      int loc = Collections.binarySearch(keys, key);
      return loc >= 0 ? values.get(loc) : null;
    }

    @Override
    void deleteValue(K key) {
      int loc = Collections.binarySearch(keys, key);
      if (loc >= 0) {
        keys.remove(loc);
        values.remove(loc);
      }
    }

    @Override
    void insertValue(K key, V value) {
      int loc = Collections.binarySearch(keys, key);
      int valueIndex = loc >= 0 ? loc : -loc - 1;
      if (loc >= 0) {
        values.set(valueIndex, value);
      } else {
        keys.add(valueIndex, key);
        values.add(valueIndex, value);
      }
      if (root.isOverflow()) {
        Node sibling = split();
        InternalNode newRoot = new InternalNode();
        newRoot.keys.add(sibling.getFirstLeafKey());
        newRoot.children.add(this);
        newRoot.children.add(sibling);
        root = newRoot;
      }
    }

    @Override
    K getFirstLeafKey() {
      return keys.get(0);
    }

    @Override
    List<V> getRange(K key1, RangePolicy policy1, K key2, RangePolicy policy2) {
      List<V> result = new LinkedList<V>();
      LeafNode node = this;
      while (node != null) {
        Iterator<K> kIt = node.keys.iterator();
        Iterator<V> vIt = node.values.iterator();
        while (kIt.hasNext()) {
          K key = kIt.next();
          V value = vIt.next();
          int cmp1 = key.compareTo(key1);
          int cmp2 = key.compareTo(key2);
          if (((policy1 == RangePolicy.EXCLUSIVE && cmp1 > 0)
                  || (policy1 == RangePolicy.INCLUSIVE && cmp1 >= 0))
              && ((policy2 == RangePolicy.EXCLUSIVE && cmp2 < 0)
                  || (policy2 == RangePolicy.INCLUSIVE && cmp2 <= 0))) {
            result.add(value);
          } else if ((policy2 == RangePolicy.EXCLUSIVE && cmp2 >= 0)
              || (policy2 == RangePolicy.INCLUSIVE && cmp2 > 0)) {
            return result;
          }
        }
        node = node.next;
      }
      return result;
    }

    @Override
    void merge(Node sibling) {
      LeafNode node = (LeafNode) sibling;
      keys.addAll(node.keys);
      values.addAll(node.values);
      next = node.next;
    }

    @Override
    Node split() {
      LeafNode sibling = new LeafNode();
      int from = (keyNumber() + 1) / 2, to = keyNumber();
      sibling.keys.addAll(keys.subList(from, to));
      sibling.values.addAll(values.subList(from, to));

      keys.subList(from, to).clear();
      values.subList(from, to).clear();

      sibling.next = next;
      next = sibling;
      return sibling;
    }

    @Override
    boolean isOverflow() {
      return values.size() > branchingFactor - 1;
    }

    @Override
    boolean isUnderflow() {
      return values.size() < branchingFactor / 2;
    }
  }
}
