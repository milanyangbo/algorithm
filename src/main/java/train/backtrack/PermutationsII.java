package train.backtrack;

import java.util.*;
import java.util.stream.Collectors;

/** https://leetcode-cn.com/problems/permutations-ii/ */
public class PermutationsII {

  public static void main(String[] args) {
    List<List<Integer>> res = new PermutationsII().permuteUnique(new int[] {1, 1, 2});
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    // 记录「路径」
    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return new ArrayList<>(res);
  }

  Set<List<Integer>> res = new HashSet<>();

  // 路径：记录在 track 中
  // 选择列表：nums 中不存在于 track 的那些元素
  // 结束条件：nums 中的元素全都在 track 中出现
  void backtrack(int[] nums, LinkedList<Integer> track) {
    // 触发结束条件
    if (track.size() == nums.length) {
      res.add(new LinkedList(track.stream().map(i -> nums[i]).collect(Collectors.toList())));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // 排除不合法的选择
      if (track.contains(i)) {
        continue;
      }
      // 做选择
      track.add(i);
      // 进入下一层决策树
      backtrack(nums, track);
      // 取消选择
      track.removeLast();
    }
  }
}
