package train.queuestackarray;

/** https://leetcode-cn.com/problems/longest-common-prefix/ */
public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 1) {
      return "";
    }
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      String str = strs[i];
      int j = 0;
      while (j < str.length() && j < prefix.length()) {
        if (prefix.charAt(j) != str.charAt(j)) {
          break;
        }
        j++;
      }
      prefix = prefix.substring(0, j);
      if (prefix.equals("")) {
        return "";
      }
    }
    return prefix;
  }
}
