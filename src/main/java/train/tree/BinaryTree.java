package train.tree;

import java.util.Stack;

/** https://leetcode-cn.com/problems/validate-binary-search-tree/ */
public class BinaryTree {

  public static void main(String[] args) {
    // new BinaryTree().isValidBSTLoop(of(new int[] {2, 1, 3}));
    // new BinaryTree().isValidBSTLoop(of(new int[] {5, 1, 4, -Integer.MIN_VALUE,
    // -Integer.MIN_VALUE, 3, 6}));
    // new BinaryTree().isValidBSTLoop(of(new int[] {1, 2, 3, 4, 5, 6, 7}));
    // new BinaryTree().isValidBSTInOrder(of(new int[] {5, 1, 4, -Integer.MIN_VALUE,
    // -Integer.MIN_VALUE, 3, 6}));
    // new BinaryTree().isValidBSTInOrder(of(new int[] {1, 2, 3, 4, 5, 6, 7}));
    // new BinaryTree().isValidBSTInOrder(of(new int[] {0, -1}));
  }

  public boolean isValidBSTLoop(TreeNode root) {
    if (root == null) {
      return false;
    }

    return validRecursive(root, null, null);
  }

  private boolean validRecursive(TreeNode node, Integer lower, Integer upper) {
    if (node == null) {
      return true;
    }

    int val = node.val;
    if (lower != null && val <= lower) {
      return false;
    }
    if (upper != null && val >= upper) {
      return false;
    }

    if (!validRecursive(node.right, val, upper)) {
      return false;
    }
    if (!validRecursive(node.left, lower, val)) {
      return false;
    }
    return true;
  }

  public static boolean isValidBSTDFS(TreeNode root) {
    if (root == null) {
      return false;
    }

    return false;
  }

  public boolean isValidBSTInOrder(TreeNode root) {
    if (root == null) {
      return true;
    }
    double min = -Double.MAX_VALUE;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        TreeNode tem = stack.pop();
        if (tem.val <= min) {
          return false;
        }
        node = tem.right;
        min = tem.val;
      }
    }
    return true;
  }
}
