package train.backtrack;

/** https://leetcode-cn.com/problems/sudoku-solver/ */
public class Sudokuii {
  public static void main(String[] args) {

    char[][] board =
        new char[][] {
          {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
          {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
          {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
          {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
          {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
          {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
          {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
          {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
          {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };

    new Sudokuii().solveSudoku(board);
  }

  static char[] chars = new char[9];

  static {
    chars[0] = '1';
    chars[1] = '2';
    chars[2] = '3';
    chars[3] = '4';
    chars[4] = '5';
    chars[5] = '6';
    chars[6] = '7';
    chars[7] = '8';
    chars[8] = '9';
  }

  public void solveSudoku(char[][] board) {

    boolean[][] rows = new boolean[9][10];
    boolean[][] columns = new boolean[9][10];
    boolean[][] boxes = new boolean[9][10];

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board.length; col++) {
        char num = board[row][col];
        if (num != '.') {
          int idx = (row / 3) * 3 + col / 3;
          int d = Character.getNumericValue(num);
          rows[row][d] = true;
          columns[col][d] = true;
          boxes[idx][d] = true;
        }
      }
    }

    int row = 0;
    int col = 0;
    backtrack(board, row, col, rows, columns, boxes);
  }

  private boolean backtrack(
      char[][] board, int row, int col, boolean[][] rows, boolean[][] columns, boolean[][] boxes) {
    while (board[row][col] != '.') {
      if (++col >= 9) {
        row++;
        col = 0;
      }
      if (row >= 9) {
        return true;
      }
    }

    for (int i = 0; i < chars.length; i++) {
      int idx = (row / 3) * 3 + col / 3;
      int d = Character.getNumericValue(chars[i]);
      if (!rows[row][d] && !columns[col][d] && !boxes[idx][d]) {
        rows[row][d] = true;
        columns[col][d] = true;
        boxes[idx][d] = true;
        board[row][col] = chars[i];

        if (backtrack(board, row, col, rows, columns, boxes)) {
          return true;
        } else {
          rows[row][d] = false;
          columns[col][d] = false;
          boxes[idx][d] = false;
          board[row][col] = '.';
        }
      }
    }
    return false;
  }
}
