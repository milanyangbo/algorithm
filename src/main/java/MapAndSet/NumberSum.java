package MapAndSet;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/two-sum/ https://leetcode-cn.com/problems/3sum/
 */
public class NumberSum {
    public static void main(String[] args) {
        twoSum(new int[]{3, 2, 4}, 6);
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        threeSum(new int[]{1, 2, -2, -1});
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int element = target - nums[i];
            if (map.containsKey(element) && map.get(element) != i) {
                return new int[]{i, map.get(element)};
            }
        }

        throw new IllegalArgumentException(" no two sum");
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            int sub = zero - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int element = sub - nums[j];
                    if (map.containsKey(element) && map.get(element) != j && map.get(element) != i) {
                        int x = map.get(element);
                        ans.add(Arrays.asList(nums[i], nums[j], nums[x]));
//                        map.remove(nums[i]);
//                        map.remove(nums[j]);
//                        map.remove(element);
                    }
                }
            }
        }

        return ans;
    }
}
