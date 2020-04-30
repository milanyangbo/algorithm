package DynamicProgramming;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode-cn.com/problems/triangle/description/ */
public class Triangle {

  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();
    // [[2],[3,4],[6,5,7],[4,1,8,3]]
    triangle.add(Lists.newArrayList(2));
    triangle.add(Lists.newArrayList(3, 4));
    triangle.add(Lists.newArrayList(6, 5, 7));
    triangle.add(Lists.newArrayList(4, 1, 8, 3));
    new Triangle().minimumTotal(triangle);
  }

  /** DP[i,j] = min( DP[i+1,j],DP[i+1,j+1]) + Triangle[i,j] */
  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> result = triangle.get(triangle.size() - 1);
    for (int row = triangle.size() - 2; row >= 0; row--) {
      for (int col = 0; col < triangle.get(row).size(); col++) {
        result.set(
            col, Math.min(result.get(col), result.get(col + 1)) + triangle.get(row).get(col));
      }
    }
    return result.get(0);
  }
}
