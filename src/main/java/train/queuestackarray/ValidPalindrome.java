package train.queuestackarray;

/** https://leetcode-cn.com/problems/valid-palindrome/ */
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left <= right) {
      if (!Character.isLetterOrDigit(s.charAt(left))) {
        left++;
        continue;
      }
      if (!Character.isLetterOrDigit(s.charAt(right))) {
        right++;
        continue;
      }
      if (right >= left
          && Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
        left++;
        right--;
      } else return false;
    }
    return true;
  }
}
