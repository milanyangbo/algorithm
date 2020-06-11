package train.tree;

public class BinarySearchTree {

  public static void main(String[] args) {
    BinarySearchTree searchTree =
        new BinarySearchTree(
            TreeNode.of(
                new int[] {
                  50,
                  30,
                  80,
                  20,
                  35,
                  70,
                  100,
                  -Integer.MIN_VALUE,
                  -Integer.MIN_VALUE,
                  34,
                  40,
                  75
                }));

    searchTree.delete(30);
  }

  TreeNode tree;

  public BinarySearchTree(TreeNode tree) {
    this.tree = tree;
  }

  public TreeNode find(int data) {
    TreeNode p = tree;
    while (p != null) {
      if (data < p.val) p = p.left;
      else if (data > p.val) p = p.right;
      return p;
    }
    return null;
  }

  public void insert(int data) {
    if (tree == null) {
      tree = new TreeNode(data);
      return;
    }
    TreeNode p = tree;
    while (p != null) {
      if (data > p.val) {
        if (p.right == null) {
          p.right = new TreeNode(data);
          return;
        }
        p = p.right;
      } else {
        if (p.left == null) {
          p.left = new TreeNode(data);
          return;
        }
        p = p.left;
      }
    }
  }

  public void delete(int data) {
    TreeNode p = tree;
    TreeNode pp = null; // pp记录的是p的父节点
    while (p != null && p.val != data) {
      pp = p;
      if (data > p.val) p = p.right;
      else p = p.left;
    }
    if (p == null) return;
    if (p.left != null
        && p.right != null) { // 中序遍历的后继节点满足比当前节点的所有左节点都大，比当前节点的右节点都小（比当前节点大的节点中最小的节点）,后继节点存在右节点
      TreeNode minP = p.right;
      TreeNode minPP = p;
      while (minP.left != null) {
        minPP = minP;
        minP = minP.left;
      }
      p.val = minP.val;
      p = minP;
      pp = minPP;
    }

    TreeNode child;
    if (p.left != null) child = p.left;
    else if (p.right != null) child = p.right;
    else child = null;

    if (pp == null) tree = child;
    else if (pp.left == p) pp.left = child;
    else pp.right = child;
  }
}
