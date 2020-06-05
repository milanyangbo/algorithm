package train.tree;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  TreeNode(int x) {
    val = x;
  }

  public static void main(String[] args) {
    TreeNode treeNode = of(new int[] {2, 1, 3});
    TreeNode treeNode2 = of(new int[] {5, 1, 4, -1, -1, 3, 6});
  }

  public static TreeNode of(int[] nums) {
    if (nums == null) {
      return null;
    }
    if (nums.length == 1) {
      return new TreeNode(nums[0]);
    }
    TreeNode rootNode = new TreeNode(nums[0]);
    int curIndex = 0;
    of(rootNode, curIndex, nums);
    return rootNode;
  };

  private static TreeNode of(TreeNode node, int index, int[] nums) {
    int leftIndex = index * 2 + 1;
    int rightIndex = index * 2 + 2;

    if (leftIndex < nums.length && nums[leftIndex] != -Integer.MIN_VALUE) {
      node.left = new TreeNode(nums[leftIndex]);
      of(node.left, leftIndex, nums);
    }
    if (rightIndex < nums.length && nums[rightIndex] != -Integer.MIN_VALUE) {
      node.right = new TreeNode(nums[rightIndex]);
      of(node.right, rightIndex, nums);
    }

    return node;
  };
}
