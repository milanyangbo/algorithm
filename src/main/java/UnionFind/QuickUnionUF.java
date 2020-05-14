package UnionFind;

public class QuickUnionUF {
  int[] roots;
  int count;

  public QuickUnionUF() {}

  public QuickUnionUF(int N) {
    roots = new int[N];
    for (int i = 0; i < N; i++) {
      roots[i] = i;
      ++count;
    }
  }

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
    roots[qroot] = proot;
    if (qroot != proot) {
      --count;
    }
  }
}
