package train.backtrack;

import java.util.*;

/** https://leetcode-cn.com/problems/n-queens/ */
public class Nqueens {
  public static void main(String[] args) {
    new Nqueens().solveNQueens(4);
  }

  /** https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/ */
  public List<List<String>> solveNQueens(int n) {
    int row = 0;
    char[][] bucket = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        bucket[i][j] = '.';
      }
    }
    backtrack(bucket, row);
    return resultList;
  }

  List<List<String>> resultList = new LinkedList<>();

  public void backtrack(char[][] bucket, int row) {
    if (row == bucket.length) {
      int n = bucket.length;
      List<String> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        char[] chars = bucket[i];
        list.add(new String(chars));
      }
      resultList.add(list);
    } else {
      int n = bucket[row].length;
      for (int col = 0; col < n; col++) {
        if (!isValid(bucket, row, col)) {
          continue;
        }
        bucket[row][col] = 'Q';
        backtrack(bucket, row + 1);
        bucket[row][col] = '.';
      }
    }
  }

  boolean isValid(char[][] bucket, int row, int col) {
    int n = bucket.length;
    // 检查列是否有皇后互相冲突
    for (int i = 0; i < n; i++) {
      if (bucket[i][col] == 'Q') {
        return false;
      }
    }
    // 检查右上方是否有皇后互相冲突
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
      if (bucket[i][j] == 'Q') {
        return false;
      }
    }
    // 检查左上方是否有皇后互相冲突
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (bucket[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }

}
