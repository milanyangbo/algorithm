package Greedy;

import java.util.LinkedHashMap;
import java.util.Map;

/** https://leetcode-cn.com/problems/integer-to-roman/ */
public class IntToRoman {

  public static void main(String[] args) {
    new IntToRoman().intToRoman(58);
  }

  static Map<Integer, String> map = new LinkedHashMap<>();

  static {
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
  }

  public String intToRoman(int num) {
    StringBuilder ret = new StringBuilder();
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      while (entry.getKey() <= num) {
        ret.append(entry.getValue());
        num = num - entry.getKey();
      }
    }
    return ret.toString();
  }
}
