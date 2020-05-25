package QueueAndStackAndArray;

/** https://leetcode-cn.com/problems/longest-palindromic-substring/ */
public class LongestPalindrome {
  public static void main(String[] args) {
    new LongestPalindrome().longestPalindrome("babad");
  }

  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = lenPalindrome(s, i, i);
      int len2 = lenPalindrome(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }

    return s.substring(start, end + 1);
  }

  private int lenPalindrome(String s, int start, int end) {
    int L = start, R = end;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }
}
