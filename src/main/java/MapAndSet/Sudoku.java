package MapAndSet;

import java.util.HashMap;

/** https://leetcode-cn.com/problems/valid-sudoku/ */
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

    new Sudoku().isValidSudoku(board);
  }

  public boolean isValidSudoku(char[][] board) {
    // init data
    HashMap<Integer, Integer>[] rows = new HashMap[9];
    HashMap<Integer, Integer>[] columns = new HashMap[9];
    HashMap<Integer, Integer>[] boxes = new HashMap[9];
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashMap<>();
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
