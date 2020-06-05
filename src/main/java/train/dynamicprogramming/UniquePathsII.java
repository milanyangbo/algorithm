package train.dynamicprogramming;

/** https://leetcode-cn.com/problems/unique-paths-ii/ */
public class UniquePathsII {

  public static void main(String[] args) {
    new UniquePathsII().uniquePathsWithObstacles(new int[][] {{0, 1}});
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    if (obstacleGrid == null || obstacleGrid.length == 0) {
      return 0;
    }
    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    for (int i = 0; i < obstacleGrid.length; i++) {
      for (int j = 0; j < obstacleGrid[0].length; j++) {
        if (obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
          continue;
        }
        if (i == 0 & j == 0) dp[i][j] = 1;
        else if (i == 0 & j > 0) dp[i][j] = dp[i][j - 1] == 0 ? 0 : 1;
        else if (i > 0 & j == 0) dp[i][j] = dp[i - 1][j] == 0 ? 0 : 1;
        else
          dp[i][j] =
              (obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j])
                  + (obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1]);
      }
    }
    return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
  }
}
