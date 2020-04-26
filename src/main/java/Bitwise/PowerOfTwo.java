package Bitwise;

/** https://leetcode-cn.com/problems/power-of-two/ */
public class PowerOfTwo {

  /** 有且只有一个1 n = n & (n - 1) 清零最低位的1 */
  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
}
