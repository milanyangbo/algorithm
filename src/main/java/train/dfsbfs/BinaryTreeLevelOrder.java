package train.dfsbfs;

import train.tree.TreeNode;

import java.util.*;

/** https://leetcode-cn.com/problems/binary-tree-level-order-traversal/ */
public class BinaryTreeLevelOrder {

  public static void main(String[] args) {
    new BinaryTreeLevelOrder()
        .levelOrderBFS(
            TreeNode.of(new int[] {3, 9, 20, -Integer.MAX_VALUE, -Integer.MAX_VALUE, 15, 7}));
  }

  /** Batch Process */
  public List<List<Integer>> levelOrderBFS(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      List<TreeNode> nodes = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) {
          nodes.add(node.left);
        }
        if (node.right != null) {
          nodes.add(node.right);
        }
      }
      if (list.size() > 0) {
        res.add(list);
      }
      if (nodes.size() > 0) {
        queue.addAll(nodes);
      }
    }
    return res;
  }
}
