package train.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** https://leetcode-cn.com/problems/n-queens-ii/ */
public class Nqueensii {
  public static void main(String[] args) {
    new Nqueensii().totalNQueens(4);
  }

  public int totalNQueens(int n) {
    int row = 0;
    char[][] bucket = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        bucket[i][j] = '.';
      }
    }
    backtrack(bucket, row);
    return resultList.size();
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
