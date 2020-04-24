package Tree;

/** https://leetcode-cn.com/problems/invert-binary-tree/ */
public class ReverseTree {

  public TreeNode invertTree(TreeNode root) {
    invertTree1(root);
    return root;
  }

  public void invertTree1(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTree(root.left);
    invertTree(root.right);
  }
}
