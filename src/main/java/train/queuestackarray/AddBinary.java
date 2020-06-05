package train.queuestackarray;

/** https://leetcode-cn.com/problems/add-binary/ */
public class AddBinary {

  public static void main(String[] args) {
    new AddBinary().addBinary("11", "1");
  }

  public String addBinary(String a, String b) {
    int n = Math.max(a.length(), b.length());
    StringBuilder sb = new StringBuilder();
    int k = 0;
    int i = 0;
    while (i < n) {
      int c1 =
          i < a.length()
              ? Character.getNumericValue(a.charAt(a.length() - i - 1))
              : Character.getNumericValue('0');
      int c2 =
          i < b.length()
              ? Character.getNumericValue(b.charAt(b.length() - i - 1))
              : Character.getNumericValue('0');
      i++;
      int v = c1 + c2 + k;
      k = v / 2;
      sb.append(v % 2);
    }
    sb.append(k != 0 ? k : "");

    return sb.reverse().toString();
  }
}
