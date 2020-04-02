package DFSAndBFS;

import Tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/** https://leetcode-cn.com/problems/generate-parentheses/ */
public class Parenthesis {

  public static void main(String[] args) {
    List<String> resultList = new Parenthesis().generateParenthesis(3);
  }

  /** 局部不合法，就返回 used=n 可以将多种结果考虑成多叉树，通过深度优先搜索查找 */
  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    List<String> resultList = new ArrayList<>();
    String subList = "";
    generateParenthesis(resultList, "", n, n);
    return resultList;
  }

  private void generateParenthesis(List<String> resultList, String subList, int left, int right) {

    if (left > 0) {
      generateParenthesis(resultList, subList + "(", left - 1, right);
    }
    if (left < right && right > 0) {
      generateParenthesis(resultList, subList + ")", left, right - 1);
    }
    if (left == 0 && right == 0) {
      resultList.add(subList);
    }
  }

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
