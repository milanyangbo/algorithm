package train.greedy;

/** https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/ */
public class BuySellStocks {
  public static void main(String[] args) {
    new BuySellStocks().maxProfitGreedy(new int[]{1,2,3,4,5});
  }

  /**
   * 贪心算法 res = (prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])
   * =prices[3] - prices[0] 等价于：“在索引为 0 的那一天买入，在索引为 3 的那一天卖出” “贪心算法” 在每一步总是做出在当前看来最好的选择
   * 贪心算法时间复杂度一般是线性的，空间复杂度是常数级别的
   */
  public int maxProfitGreedy(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      int tmp = prices[i] - prices[i - 1];
      if (tmp > 0) {
        profit += tmp;
      }
    }
    return profit;
  }

  /** 动态规划 */
  public int maxProfitDP(int[] prices) {
    return 0;
  }
}
