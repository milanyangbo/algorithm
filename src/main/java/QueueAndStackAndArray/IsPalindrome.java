package QueueAndStackAndArray;

/** https://leetcode-cn.com/problems/palindrome-number/ */
public class IsPalindrome {
  public boolean isPalindrome(int x) {
    // 如上所述，当 x < 0 时，x 不是回文数。
    // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
    // 则其第一位数字也应该是 0
    // 只有 0 满足这一属性
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int reverNum = 0;
    while (x > reverNum) {
      reverNum = reverNum * 10 + x % 10;
      x = x / 10;
    }
    return x == reverNum || x == reverNum / 10;
  }
}
