package DFSAndBFS;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode-cn.com/problems/generate-parentheses/ */
public class Parenthesis {

  public static void main(String[] args) {
    List<String> resultList = new Parenthesis().generateParenthesis(3);
  }

  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    List<String> resultList = new ArrayList<>();
    String subList = "";
    generateParenthesis(resultList, subList, n, n);
    return resultList;
  }

  private void generateParenthesis(List<String> resultList, String subList, int left, int right) {

    if (left > 0) {
      generateParenthesis(resultList, subList + "(", left - 1, right);
    }
    if (left < right && right > 0) {
      generateParenthesis(resultList, subList + ")", left, right - 1);
    }
    if (left == 0 && right == 0) {
      resultList.add(subList);
    }
  }
}
