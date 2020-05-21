package Tree;

/** https://leetcode-cn.com/problems/path-sum/submissions/ */
public class HasPathSum {

  public static void main(String[] args) {
    new HasPathSum().hasPathSum(null, 1);
  }

  int count = 0;

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    dfs(root, root.val, sum);
    return count > 0;
  }

  private void dfs(TreeNode root, int sum1, int sum) {
    if (root.left == null && root.right == null) {
      if (sum1 == sum) {
        count++;
      }
    }

    if (root.left != null) {
      dfs(root.left, sum1 + root.left.val, sum);
    }

    if (root.right != null) {
      dfs(root.right, sum1 + root.right.val, sum);
    }
  }
}
