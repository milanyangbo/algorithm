package AlphaBeta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** https://leetcode-cn.com/problems/n-queens/ https://leetcode-cn.com/problems/n-queens-ii/ */
public class Nqueens {
  public static void main(String[] args) {
    new Nqueens().solveNQueens(4);
  }

  /** 深度搜索 [i,j] col[j] pie[i + j] na[i - j] */
  public List<List<String>> solveNQueens(int n) {
    int row = n;
    Set<Integer> cols = new HashSet<>();
    Set<Integer> pies = new HashSet<>();
    Set<Integer> nas = new HashSet<>();

    List<List<String>> resultList = new ArrayList<>();
    String[][] bucket = new String[n][n];
    solveNQueens(resultList, bucket, row, n, cols, pies, nas);
    return resultList;
  }

  public void solveNQueens(
      List<List<String>> resultList,
      String[][] bucket,
      int row,
      int n,
      Set<Integer> cols,
      Set<Integer> pies,
      Set<Integer> nas) {
    if (row <= 0) {
      resultList = resultList;
      return;
    } else {
      for (int col = 0; col < n; col++) {
        int pie = row + col;
        int na = row - col;
        if (!cols.contains(col) && !pies.contains(pie) && !nas.contains(na)) {
          bucket[row - 1][col] = "q";
          cols.add(col);
          pie = (row - 1) + col;
          na = (row - 1) - col;
          pies.clear();
          nas.clear();
          pies.add(pie);
          nas.add(na);
          row = row - 1;

          solveNQueens(resultList, bucket, row, n, cols, pies, nas);
        } else {
          cols.remove(col);
          pies.clear();
          nas.clear();
        }
      }
    }
  }

  public int totalNQueens(int n) {
    return 0;
  }
}
