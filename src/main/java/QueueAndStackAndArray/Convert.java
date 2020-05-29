package QueueAndStackAndArray;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode-cn.com/problems/zigzag-conversion/ */
public class Convert {

  public static void main(String[] args) {
    new Convert().convert("PAYPALISHIRING", 3);
  }

  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      rows.add(new StringBuilder());
    }
    int curRow = 0;
    boolean goingDown = false;
    for (int i = 0; i < s.length(); i++) {
      rows.get(curRow).append(s.charAt(i));
      if (curRow == 0 || curRow == numRows - 1) {
        goingDown = !goingDown;
      }
      curRow += goingDown ? 1 : -1;
    }

    StringBuilder ret = new StringBuilder();
    for (StringBuilder row : rows) {
      ret.append(row);
    }
    return ret.toString();
  }
}
