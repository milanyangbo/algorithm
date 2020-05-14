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

  public static class QuickUnionUF {
    int[] roots;
    int count;

    public QuickUnionUF() {}

    private int findRoot(int i) {
      int root = i;
      while (root != roots[root]) {
        root = roots[root];
      }
      while (i != roots[root]) {
        int temp = roots[i];
        roots[i] = root;
        i = temp;
      }
      return root;
    }

    public boolean connected(int p, int q) {
      return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
      int qroot = findRoot(q);
      int proot = findRoot(p);
      roots[proot] = qroot;
      if (qroot != proot) {
        --count;
      }
    }
  }
}
