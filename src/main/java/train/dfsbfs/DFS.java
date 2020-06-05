package train.dfsbfs;

import train.tree.TreeNode;
import org.junit.Test;

import java.util.*;

public class DFS {

  @Test
  public void DFSLoop() {
    TreeNode root = TreeNode.of(new int[] {1, 2, 3, 4, 5, 6, 7});
    Stack<TreeNode> stack = new Stack<>();
    Set<TreeNode> visited = new HashSet<>();
    stack.push(root);

    List<Integer> res = new ArrayList<>();
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();

      visited.add(root);
      res.add(node.val);

      if (node.right != null && !visited.contains(node.right)) {
        stack.push(node.right);
      }
      if (node.left != null && !visited.contains(node.left)) {
        stack.push(node.left);
      }
    }
  }

  @Test
  public void DFSRecursion() {
    TreeNode root = TreeNode.of(new int[] {1, 2, 3, 4, 5, 6, 7});
    Set<TreeNode> visited = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    DFSRecursion(root, visited, res);
  }

  private void DFSRecursion(TreeNode node, Set<TreeNode> visited, List<Integer> list) {
    list.add(node.val);
    visited.add(node);
    if (node.left != null && !visited.contains(node.left)) {
      DFSRecursion(node.left, visited, list);
    }
    if (node.right != null && !visited.contains(node.right)) {
      DFSRecursion(node.right, visited, list);
    }
  }
}
