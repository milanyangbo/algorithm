package QueueAndStack;

/** https://leetcode-cn.com/problems/longest-palindromic-substring/ */
public class LongestPalindrome {
  public static void main(String[] args) {
    new LongestPalindrome().longestPalindrome("babad");
  }

  public String longestPalindrome(String s) {
    if (s.length() == 1) {
      return s;
    }
    int n = s.length();
    String p = "";
    for (int start = 0; start < n; start++) {
      int end = start + 1;
      int len = 0;
      while (end < n) {
        if (!isVaild(s, start, end)) {
          --end;
          break;
        }
        len = end - start + 1;
        ++end;
      }

      if (len > p.length()) {
        p = s.substring(start, end + 1);
      }
    }
    return p;
  }

  private boolean isVaild(String s, int start, int end) {
    int end1 = ((end + start) / 2);
    while (start <= end1) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      end--;
      start++;
    }
    return true;
  }
}
