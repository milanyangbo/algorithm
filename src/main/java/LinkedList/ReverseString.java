package LinkedList;

/** https://leetcode-cn.com/problems/reverse-string/ */
public class ReverseString {
  public static void main(String[] args) {
    new ReverseString().reverseString(new char[] {'h', 'e', 'l', 'l', 'o'});
  }

  public void reverseString(char[] s) {
    int i = 0;
    int j = s.length - 1;

    while (i < j) {
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;
      i++;
      j--;
    }
  }
}
