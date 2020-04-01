package Greedy;

/** https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/ */
public class BuySellStocks {

  /**
   * 贪心算法 res = (prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])
   * =prices[3] - prices[0] 等价于：“在索引为 0 的那一天买入，在索引为 3 的那一天卖出” “贪心算法” 在每一步总是做出在当前看来最好的选择
   * 贪心算法时间复杂度一般是线性的，空间复杂度是常数级别的
   */
  public int maxProfitGreedy(int[] prices) {
    return 0;
  }

  /** 动态规划 */
  public int maxProfitDP(int[] prices) {
    return 0;
  }
}
