package train.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** https://leetcode-cn.com/problems/combinations/ */
public class Combinations {

  public static void main(String[] args) {
    List<List<Integer>> res = new Combinations().combine(4, 2);
  }

  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {
    backtrack(n, k, 1, new LinkedList<>());
    return result;
  }

  private void backtrack(int n, int k, int start, LinkedList<Integer> track) {
    if (track.size() == k) {
      result.add(new LinkedList<>(track));
      return;
    }
    for (int i = start; i <= n; i++) {
      if (track.contains(i)) continue;
      track.add(i);
      backtrack(n, k, i + 1, track);
      track.removeLast();
    }
  }
}
