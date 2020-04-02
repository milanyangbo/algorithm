package DFSAndBFS;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class BinaryTreeMaxAndMinDeep {

  public static void main(String[] args) {
    new BinaryTreeMaxAndMinDeep()
        .maxDepthBFS(
            TreeNode.of(new int[] {3, 9, 20, -Integer.MAX_VALUE, -Integer.MAX_VALUE, 15, 7}));
  }

  public int maxDepthBFS(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
      List<TreeNode> nodes = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          nodes.add(node.left);
        }
        if (node.right != null) {
          nodes.add(node.right);
        }
      }
      queue.addAll(nodes);
      level += 1;
    }
    return level;
  }

  /** 判断第一个出现的leafnode */
  public int minDepthBFS(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
      List<TreeNode> nodes = new ArrayList<>();
      boolean isLeafNode = false;
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          nodes.add(node.left);
        }
        if (node.right != null) {
          nodes.add(node.right);
        }
        if (node.left == null && node.right == null) {
          isLeafNode = true;
          break;
        }
      }
      queue.addAll(nodes);
      level += 1;
      if (isLeafNode) {
        break;
      }
    }
    return level;
  }
}
