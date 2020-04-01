package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class Traverse {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    preorderTraversal(root, list);
    return list;
  }

  private void preorderTraversal(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }
    list.add(node.val);
    preorderTraversal(node.left, list);
    preorderTraversal(node.right, list);
  }

  public List<Integer> preorderTraversalLoop(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        list.add(root.val);
        stack.push(root);
        root = root.left;
      } else {
        TreeNode temp = stack.pop();
        root = temp.right;
      }
    }
    return list;
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inorderTraversal(root, list);
    return list;
  }

  private void inorderTraversal(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }
    inorderTraversal(node.left, list);
    list.add(node.val);
    inorderTraversal(node.right, list);
  }

  public List<Integer> inorderTraversalLoop(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode temp = stack.pop();
        list.add(temp.val);
        root = temp.right;
      }
    }
    return list;
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    postorderTraversal(root, list);
    return list;
  }

  private void postorderTraversal(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }
    postorderTraversal(node.left, list);
    postorderTraversal(node.right, list);
    list.add(node.val);
  }

  public static void main(String[] args) {
    //    List<Integer> lis =
    //        new Traverse().postorderTraversalLoop1(TreeNode.of(new int[] {0, 1, 2, 3, 4, 5, 6}));
    List<Integer> lis =
        new Traverse().postorderTraversalLoop2(TreeNode.of(new int[] {0, 1, 2, 3, 4, 5, 6}));
  }

  /** 后序遍历 左右根 采用根右左的遍历方法，最后再将结果翻转 */
  public List<Integer> postorderTraversalLoop1(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        list.add(root.val);
        stack.push(root);
        root = root.right;
      } else {
        TreeNode temp = stack.pop();
        root = temp.left;
      }
    }
    Collections.reverse(list);
    return list;
  }

  /** 建立一个指向前一节点的指针，标记右孩子是否被访问 */
  public List<Integer> postorderTraversalLoop2(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        // peek关键点
        TreeNode temp = stack.peek();
        if (temp.right == null || temp.right == pre) {
          list.add(temp.val);
          stack.pop();
          pre = temp;
          root = null;
        } else {
          root = temp.right;
        }
      }
    }
    return list;
  }
}
