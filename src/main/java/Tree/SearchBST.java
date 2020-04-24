package Tree;

/** https://leetcode-cn.com/problems/search-in-a-binary-search-tree/ */
public class SearchBST {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }

    TreeNode left = null;
    TreeNode right = null;
    if (val < root.val) {
      left = searchBST(root.left, val);
    } else {
      right = searchBST(root.right, val);
    }

    if (left != null) {
      return left;
    }
    if (right != null) {
      return right;
    }
    return null;
  }
}
