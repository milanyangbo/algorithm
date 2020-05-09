package DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Stock {

  /** mp[i][j][k] i第N天，j是否持有股票，k交易多少次 */
  public int maxProfit(int[] prices) {
    return maxProfit(2, prices);
  }

  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    /**
     * 当k大于等于数组长度一半时, 问题退化为贪心问题此时采用 买卖股票的最佳时机 II 的贪心方法解决可以大幅提升时间性能，如果不用这个贪心，有个testCase过不去，会报空间超 限
     */
    if (k >= prices.length / 2) return greedy(prices);
    int[][][] mp = new int[prices.length][2][k + 1];
    for (int i = 0; i <= k; i++) {
      // 第 1 天买入 - 卖出循环 K 次之后不再买入，所以初始值为 0
      mp[0][0][i] = 0;
      // 第 1 天买入 - 卖出循环 K 次之后又买入，所以初始值为 -prices[0]
      mp[0][1][i] = -prices[0];
    }
    for (int i = 1; i < prices.length; i++) {
      for (int j = 0; j <= k; j++) {
        mp[i][0][j] =
            j != 0 ? Math.max(mp[i - 1][1][j - 1] + prices[i], mp[i - 1][0][j]) : mp[i - 1][0][j];
        mp[i][1][j] = Math.max(mp[i - 1][0][j] - prices[i], mp[i - 1][1][j]);
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i <= k; i++) max = Math.max(max, mp[prices.length - 1][0][i]);
    return max;
  }

  private int greedy(int[] prices) {
    int max = 0;
    for (int i = 1; i < prices.length; ++i) {
      if (prices[i] > prices[i - 1]) max += prices[i] - prices[i - 1];
    }
    return max;
  }
}
