package DynamicProgramming;

/** https://leetcode-cn.com/problems/edit-distance/ */
public class MinDistance {

  public static void main(String[] args) {
    new MinDistance().minDistance("horse", "ros");
  }

  /** 非常重要 */
  public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    if (n * m == 0) {
      return n + m;
    }
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j < m + 1; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        int insert = dp[i][j - 1];
        int delete = dp[i - 1][j];
        int replace = dp[i - 1][j - 1];
        dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
        }
      }
    }

    return dp[n][m];
  }
}
