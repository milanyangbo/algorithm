package Tree;

/**
 * https://time.geekbang.org/column/article/68334 https://mp.weixin.qq.com/s/fOpVu5M_MXLz_9DBLzvCFA
 */
public class BinarySearchTree {
  private TreeNode tree;

  public TreeNode find(int data) {
    return null;
  }

  public void insert(int data) {
    return;
  }

  public void delete(int data) {
    return;
  }

  int maxDeath(TreeNode node) {
    return 1;
  }

  int getMinDepth(TreeNode root) {
    return 1;
  }

  int getMin(TreeNode root) {
    return 1;
  }

  boolean isBalanced(TreeNode node) {
    return false;
  }

  public static class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
      this.data = data;
    }
  }
}
