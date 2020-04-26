package Bitwise;

/** https://leetcode-cn.com/problems/number-of-1-bits/ */
public class OneBit {

  public static void main(String[] args) {
    new OneBit().hammingWeight(6);
  }

  /** n = n & (n - 1) 清零最低位的1 */
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count++;
      n = n & (n - 1);
    }
    return count;
  }
}
