package train.dfsbfs;

import train.tree.TreeNode;

import static train.tree.TreeNode.of;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Ancestor {

  public static void main(String[] args) {
    TreeNode root = of(new int[] {1, 2, 3, 4, 5, 6, 7});
    TreeNode p = root.left.left;
    TreeNode q = root.right.right;
    TreeNode n = new Ancestor().lowestCommonAncestor(root, p, q);
  }

  /**
   * 1 --> 2 --> 4 --> 8 回溯 8 --> 4 4 --> 9（找到一个节点，返回 true ） 回溯 9 --> 4 --> 2 2 --> 5 --> 10 回溯 10
   * --> 5 5 --> 11（找到另一个节点，返回 true ） 回溯 --> 5 --> 2
   *
   * <p>在节点 2 这里出现 left = true 且 right = true，因此节点 2 是它们的最近公共祖先
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    return root;
  }

  /** Binary Search Tree */
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root == p || root == q) {
      return root;
    }

    if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    }

    if (p.val > root.val && q.val > root.val) {
      return lowestCommonAncestor(root.right, p, q);
    }

    return root;
  }
}
