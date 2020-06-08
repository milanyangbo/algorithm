package train.backtrack;

/** https://leetcode-cn.com/problems/word-search/ */
public class WordSearch {

  public static void main(String[] args) {
    char[][] board =
        new char[][] {
          {'A', 'B', 'C', 'E'},
          {'S', 'F', 'C', 'S'},
          {'A', 'D', 'E', 'E'},
        };

    new WordSearch().exist(board, "ABCCED");
  }

  private int[][] directs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private boolean hasFind = false;

  public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    hasFind = false;
    char[] chars = word.toCharArray();
    if (board.length * board[0].length < word.length()) return false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == chars[0]) {
          backTrack(board, chars, 1, i, j, visited);
          if (hasFind) return true;
        }
      }
    }
    return false;
  }

  private void backTrack(
      char[][] board, char[] chars, int charIndex, int i, int j, boolean[][] visited) {
    if (hasFind) return;
    if (charIndex == chars.length) {
      hasFind = true;
      return;
    }

    visited[i][j] = true;
    for (int[] direct : directs) {
      int newI = i + direct[0], newJ = j + direct[1];
      if (newI >= 0
          && newI < board.length
          && newJ >= 0
          && newJ < board[0].length
          && !visited[newI][newJ]
          && board[newI][newJ] == chars[charIndex]
          && !hasFind) {
        backTrack(board, chars, charIndex + 1, newI, newJ, visited);
      }
    }
    visited[i][j] = false;
  }
}
