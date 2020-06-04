package DynamicProgramming;

/** https://leetcode-cn.com/problems/regular-expression-matching/ */
public class RegularExpressionMatching {

  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[s.length()][p.length()] = true;
    for (int i = s.length(); i >= 0; i--) {
      for (int j = p.length(); j >= 0; j--) {
        boolean first_match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
          dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
        } else {
          dp[i][j] = first_match && dp[i + 1][j + 1];
        }
      }
    }
    return dp[0][0];
  }
}
