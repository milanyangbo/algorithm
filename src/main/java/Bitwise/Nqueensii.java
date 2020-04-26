package Bitwise;

/** https://leetcode-cn.com/problems/n-queens-ii/ */
public class Nqueensii {
  public static void main(String[] args) {
    new Nqueensii().totalNQueens(4);
  }

  int res = 0;

  public int totalNQueens(int n) {
    dfs(n, 0, 0, 0, 0);

    return res;
  }

  void dfs(int n, int row, int col, int ld, int rd) {
    if (row >= n) {
      res++;
      return;
    }

    // 将所有能放置 Q 的位置由 0 变成 1，以便进行后续的位遍历
    // ~(col | ld | rd)这里的三个变量分别代表了列以及两个斜线的放置情况。这里的1表示的是不能放置皇后
    // (1 << n) - 1 这个语句实际上生成了n个1  16=10000 15=1111
    // 因此bits = ~(col | ld | rd) & ((1 << n) - 1)表示的是考虑了相应列、斜线后能放置皇后的位置。
    // 举个例子：n=4时，初始化为1111，表示此时4个位置都可以放皇后，但是和~(col | ld | rd)按位与后变为了0110，表示此时只有第2个和第3个位置是可以放皇后的
    int bits = ~(col | ld | rd) & ((1 << n) - 1);
    while (bits > 0) {
      // 这里的pick就是取出了最后一位1 假设bits为0110，取出最后一位1后，就变为0100
      int pick = bits & -bits; // 注: x & -x
      dfs(n, row + 1, col | pick, (ld | pick) << 1, (rd | pick) >> 1);
      bits &= bits - 1; // 注: x & (x - 1)
    }
  }
}
