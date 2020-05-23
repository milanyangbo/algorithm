package QueueAndStack;

import java.util.*;

/** https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/ */
public class LengthOfLongestSubstring {

  public static void main(String[] args) {
    new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
  }

  public int lengthOfLongestSubstring(String s) {
    Set<Character> occ = new HashSet<>();
    int n = s.length();
    int rk = -1, ans = 0;
    for (int i = 0; i < n; i++) {
      if (i != 0) {
        occ.remove(s.charAt(i - 1));
      }
      while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
        occ.add(s.charAt(rk + 1));
        ++rk;
      }
      ans = Math.max(ans, rk - i + 1);
    }
    return ans;
  }
}
