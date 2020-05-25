package MapAndSet;

import java.util.HashMap;
import java.util.Map;

/** https://leetcode-cn.com/problems/roman-to-integer/ */
public class RomanToInt {
  public static void main(String[] args) {
    new RomanToInt().romanToInt("MCMXCIV");
  }

  static Map<String, Integer> map = new HashMap<>();

  static {
    map.put("I", 1);
    map.put("IV", 3);
    map.put("V", 5);
    map.put("IX", 8);
    map.put("X", 10);
    map.put("XL", 30);
    map.put("L", 50);
    map.put("XC", 80);
    map.put("C", 100);
    map.put("CD", 300);
    map.put("D", 500);
    map.put("CM", 800);
    map.put("M", 1000);
  }

  public int romanToInt(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
        res += map.get(s.substring(i, i + 1));
      if ((i + 2) <= s.length() && map.containsKey(s.substring(i, i + 2))) {
        res += map.get(s.substring(i, i + 2));
        i++;
      }
    }
    return res;
  }
}
