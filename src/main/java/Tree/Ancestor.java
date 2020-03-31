package Tree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Ancestor {

  public static void main(String[] args) {}

  /** 如果有父指针，从叶子节点回溯到根节点形成链表，判断两个链表最近的交集节点 */
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right == null ? root : root : root;
  }

  /** Binary Search Tree */
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

    return null;
  }
}
