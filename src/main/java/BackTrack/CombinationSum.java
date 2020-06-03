package BackTrack;

import java.util.*;

/** https://leetcode-cn.com/problems/combination-sum/ */
public class CombinationSum {

  public static void main(String[] args) {
    System.out.println(new CombinationSum().combinationSum(new int[] {2, 3, 5}, 8));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    Arrays.sort(candidates);
    backTrack(candidates, 0, target, track, result);
    return result;
  }

  public void backTrack(
      int[] candidates,
      int start,
      int target,
      LinkedList<Integer> track,
      List<List<Integer>> result) {
    if (target < 0) return;
    if (target == 0) {
      result.add(new LinkedList<>(track));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if (candidates[i] > target) break;
      track.add(candidates[i]);
      backTrack(candidates, i, target - candidates[i], track, result);
      track.removeLast();
    }
  }
}
