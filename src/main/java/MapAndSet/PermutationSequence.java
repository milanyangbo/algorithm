package MapAndSet;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode-cn.com/problems/permutation-sequence/ */
public class PermutationSequence {
  public static void main(String[] args) {
    new PermutationSequence().getPermutation(3, 3);
  }

  public String getPermutation(int n, int k) {
    List<Integer> nums = new ArrayList<>();
    int[] factorials = new int[n];
    nums.add(1);
    factorials[0] = 1;
    for (int i = 1; i < n; i++) {
      factorials[i] = factorials[i - 1] * i;
      nums.add(i + 1);
    }

    k--;
    StringBuilder sb = new StringBuilder();
    for (int i = n - 1; i >= 0; i--) {
      int idx = k / factorials[i];
      k -= idx * factorials[i];
      sb.append(nums.get(idx));
      nums.remove(idx);
    }

    return sb.toString();
  }
}
