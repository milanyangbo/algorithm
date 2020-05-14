package UnionFind;

/** https://leetcode-cn.com/problems/friend-circles/ */
public class FindCircleNum {
  public int findCircleNum(int[][] M) {
    if (M.length == 0) {
      return 0;
    }
    QuickUnionUF unionUF = new QuickUnionUF();
    unionUF.roots = new int[M.length];
    unionUF.count = M.length;
    for (int i = 0; i < M.length; i++) {
      unionUF.roots[i] = i;
    }

    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[i].length; j++) {
        if (M[i][j] == 1) {
          unionUF.union(i, j);
        }
      }
    }
    return unionUF.count;
  }
}
