package train.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/ */
public class LetterCombinations {
  public static void main(String[] args) {
    new LetterCombinations().letterCombinations("23");
  }

  List<String> list = new ArrayList<>();
  Map<Character, String> phone =
      new HashMap<Character, String>() {
        {
          put('2', "abc");
          put('3', "def");
          put('4', "ghi");
          put('5', "jkl");
          put('6', "mno");
          put('7', "pqrs");
          put('8', "tuv");
          put('9', "wxyz");
        }
      };

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0 || digits.contains("1")) {
      return new ArrayList<>();
    }
    backTrack(digits, "");
    return list;
  }

  public void backTrack(String digits, String ret) {
    if (digits.length() == 0) {
      list.add(ret);
      return;
    }

    String numStr = phone.get(digits.charAt(0));
    for (int j = 0; j < numStr.length(); j++) {
      backTrack(digits.substring(1), ret + numStr.charAt(j));
    }
  }
}
