package train.queuestackarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** https://leetcode-cn.com/problems/merge-intervals/ */
public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return new int[0][];
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> result = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      if (result.size() == 0 || result.get(result.size() - 1)[1] < intervals[i][0])
        result.add(intervals[i]);
      else
        result.get(result.size() - 1)[1] =
            Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
    }
    return result.toArray(new int[result.size()][]);
  }
}
