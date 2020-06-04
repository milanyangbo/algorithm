package QueueAndStackAndArray;

/** https://leetcode-cn.com/problems/multiply-strings/ */
public class MultiplyStrings {

  public static void main(String[] args) {
    new MultiplyStrings().multiply("123", "456");
  }

  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) return "0";
    int[] nums = new int[num1.length() + num2.length()];
    for (int i = num1.length() - 1; i >= 0; i--) {
      int n1 = num1.charAt(i) - '0';
      for (int j = num2.length() - 1; j >= 0; j--) {
        int n2 = num2.charAt(j) - '0';
        int n = n1 * n2 + nums[i + j + 1];
        nums[i + j] += n / 10;
        nums[i + j + 1] = n % 10;
      }
    }

    StringBuilder res = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0 && i == 0) continue;
      res.append(nums[i]);
    }

    return res.toString();
  }
}
