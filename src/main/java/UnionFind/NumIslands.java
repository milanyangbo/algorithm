package UnionFind;

/** https://leetcode-cn.com/problems/number-of-islands/ */
public class NumIslands {

  public static void main(String[] args) {
    NumIslands numIslands = new NumIslands();
    char[][] grid =
        new char[][] {
          {'1', '1', '1', '1', '0'},
          {'1', '1', '0', '1', '0'},
          {'1', '1', '0', '0', '0'},
          {'0', '0', '0', '0', '0'}
        };
    numIslands.numIslands(grid);
  }

  public int numIslands(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    QuickUnionUF unionUF = new QuickUnionUF();
    unionUF.roots = new int[grid.length * grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          unionUF.roots[grid[i].length * i + j] = grid[i].length * i + j;
          ++unionUF.count;
        }
      }
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          grid[i][j] = '0';
          if ((i - 1) >= 0 && grid[i - 1][j] == '1') {
            unionUF.union(grid[i].length * i + j, grid[i].length * (i - 1) + j);
          }
          if ((i + 1) < grid.length && grid[i + 1][j] == '1') {
            unionUF.union(grid[i].length * i + j, grid[i].length * (i + 1) + j);
          }
          if ((j - 1) >= 0 && grid[i][j - 1] == '1') {
            unionUF.union(grid[i].length * i + j, grid[i].length * i + (j - 1));
          }
          if ((j + 1) < grid[i].length && grid[i][j + 1] == '1') {
            unionUF.union(grid[i].length * i + j, grid[i].length * i + (j + 1));
          }
        }
      }
    }

    return unionUF.count;
  }

  public int numIslandsDfs(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    int count = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          dfs(grid, visited, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
    if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0') {
      return;
    }
    visited[i][j] = true;
    grid[i][j] = '0';
    dfs(grid, visited, i + 1, j);
    dfs(grid, visited, i - 1, j);
    dfs(grid, visited, i, j + 1);
    dfs(grid, visited, i, j - 1);
  }
}
