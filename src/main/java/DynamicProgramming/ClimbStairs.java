package DynamicProgramming;

/** https://leetcode-cn.com/problems/climbing-stairs/description/ */
public class ClimbStairs {

  public static void main(String[] args) {
    new ClimbStairs().climbStairs(4);
  }

  /**
   * 线性模型
   *
   * <p>这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
   *
   * <p>第 ii 阶可以由以下两种方法得到：
   *
   * <p>在第 (i-1)(i−1) 阶后向上爬一阶。
   *
   * <p>在第 (i-2)(i−2) 阶后向上爬 22 阶。
   *
   * <p>所以到达第 ii 阶的方法总数就是到第 (i-1)(i−1) 阶和第 (i-2)(i−2) 阶的方法数之和。
   *
   * <p>令 dp[i]dp[i] 表示能到达第 ii 阶的方法总数：
   *
   * <p>dp[i]=dp[i-1]+dp[i-2]
   */
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}
