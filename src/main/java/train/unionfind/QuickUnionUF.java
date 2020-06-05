package train.unionfind;

public class QuickUnionUF {
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
