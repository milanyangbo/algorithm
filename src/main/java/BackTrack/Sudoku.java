package BackTrack;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/ https://leetcode-cn.com/problems/sudoku-solver/
 */
public class Sudoku {

  public static void main(String[] args) {
    char[][] board =
        new char[][] {
          {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

    new Sudoku().isValidSudoku1(board);
  }

  public boolean isValidSudoku1(char[][] board) {
    int row = 0;
    backtrack(board, row);
    return result;
  }

  boolean result = false;

  public void backtrack(char[][] board, int row) {
    int n = board.length;
    if (row == n) {
      result = true;
    } else {

      for (int col = 0; col < n; col++) {

        int row1 = 0;
        int col1 = 0;
        for (int i = 2; i < n; i += 3) {
          if (row <= i) {
            row1 = i;
            break;
          }
        }
        for (int j = 2; j < n; j += 3) {
          if (col <= j) {
            col1 = j;
            break;
          }
        }

        char val1 = '.';
        boolean isVaild = true;
        char charAt = board[row][col];
        if (charAt != '.') {
          for (int i = (row1 - 3 + 1); i <= row1; i++) {
            for (int j = (col1 - 3 + 1); j <= col1; j++) {
              if (i != row && j != col && board[i][j] == charAt) {
                isVaild = false;
                break;
              }
            }
          }
          if (!isVaild) {
            break;
          }
          continue;
        }

        for (int val = 1; val <= n; val++) {
          val1 = (char) (val + 48);

          for (int j = 0; j < n; j++) {
            if (j != col && board[row][j] == val1) {
              isVaild = false;
              break;
            }
          }

          for (int i = 0; i < n; i++) {
            if (i != row && board[i][col] == val1) {
              isVaild = false;
              break;
            }
          }

          for (int i = (row1 - 3 + 1); i <= row1; i++) {
            for (int j = (col1 - 3 + 1); j <= col1; j++) {
              if (i != row && j != col && board[i][j] == val1) {
                isVaild = false;
                break;
              }
            }
          }
          if (!isVaild) {
            isVaild = true;
            continue;
          } else {
            break;
          }
        }

        if (!isVaild) {
          continue;
        }

        board[row][col] = val1;
        backtrack(board, row + 1);
        board[row][col] = '.';
      }
    }
  }

  public boolean isValidSudoku(char[][] board) {
    // init data
    HashMap<Integer, Integer>[] rows = new HashMap[9];
    HashMap<Integer, Integer>[] columns = new HashMap[9];
    HashMap<Integer, Integer>[] boxes = new HashMap[9];
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashMap<Integer, Integer>();
      columns[i] = new HashMap<Integer, Integer>();
      boxes[i] = new HashMap<Integer, Integer>();
    }

    // validate a board
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char num = board[i][j];
        if (num != '.') {
          int n = (int) num;
          int box_index = (i / 3) * 3 + j / 3;

          // keep the current cell value
          rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
          columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
          boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

          // check if this value has been already seen before
          if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
            return false;
          }
        }
      }
    }

    return true;
  }
}
